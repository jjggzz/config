package com.jgz.config.grpc.start;

import com.ecwid.consul.v1.ConsulClient;
import com.ecwid.consul.v1.agent.model.NewCheck;
import com.ecwid.consul.v1.agent.model.NewService;
import io.grpc.BindableService;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import net.devh.boot.grpc.server.service.GrpcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.consul.discovery.ConsulDiscoveryProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Map;

/**
 * Grpc服务启动监听器，spring容器启动完成后执行，由它暴露gprc服务给外部系统
 */
//@Component
public class GrpcServerStartListener implements ApplicationListener<ContextRefreshedEvent> {

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    private Server server;

    @Value("${grpc.port:8081}")
    private Integer grpcPort;
    @Value("${grpc.discovery.consul.host:localhost}")
    private String host;
    @Value("${grpc.discovery.consul.port:8500}")
    private Integer port;
    @Value("${grpc.discovery.consul.service-name}")
    private String serviceName;


    @Resource
    private ConsulClient consulClient;

    @Resource
    private ConsulDiscoveryProperties properties;

    /**
     * 当spring容器启动完成后会出发此监听器
     * 通过注解获取容器中所有需要暴露的grpc服务实现类
     * 将这些实现类绑定到指定的grpc端口上供外部使用
     * @param event
     */
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        ApplicationContext applicationContext = event.getApplicationContext();

        try {
            ServerBuilder<?> serverBuilder = ServerBuilder.forPort(grpcPort);
            // 采用注解扫描方式，添加服务
            Map<String, Object> beansWithAnnotation = applicationContext.getBeansWithAnnotation(GrpcService.class);
            for (Map.Entry<String, Object> beanEntry : beansWithAnnotation.entrySet()) {
                Object service = beanEntry.getValue();
                if (service instanceof BindableService) {
                    serverBuilder.addService((BindableService) service);
                    LOGGER.error("grpc service {} already register", beanEntry.getKey());
                }
            }
            // 启动服务
            server = serverBuilder.build().start();

            LOGGER.error("grpc server is started at {}", grpcPort);

            // 增加一个钩子，当JVM进程退出时，Server 关闭
            Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                LOGGER.error("*** shutting down gRPC server since JVM is shutting down");
                if (server != null) {
                    server.shutdown();
                }
                LOGGER.error("*** server shut down！！！！");
            }));

            NewService newService = new NewService();
            newService.setId(serviceName);
            newService.setName(serviceName);
            newService.setPort(grpcPort);
            newService.setAddress("192.168.1.101");
            consulClient.agentServiceRegister(newService);

            NewCheck newCheck = new NewCheck();
            newCheck.setId(serviceName);
            newCheck.setName(serviceName);
            newCheck.setGrpcUseTLS(false);
            newCheck.setInterval("10s");
            newCheck.setGrpc("192.168.1.101:8081");
            consulClient.agentCheckRegister(newCheck);


        } catch (IOException e) {
            LOGGER.error("start grpc server error", e);
        }
    }

}
