package com.jgz.config;

import com.jgz.config.grpc.ConfigServiceGrpc;
import com.jgz.config.grpc.ConfigServiceOuterClass;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableDiscoveryClient
@SpringBootApplication
@RestController
public class Main {

    @GrpcClient("dynamic-config-server")
    private ConfigServiceGrpc.ConfigServiceBlockingStub configServiceBlockingStub;

    public static void main(String[] args) {
        SpringApplication.run(Main.class,args);
    }

    @GetMapping("/get")
    public void get() {
        ConfigServiceOuterClass.ConfigResponse query = configServiceBlockingStub.query(ConfigServiceOuterClass.ConfigRequest.newBuilder().setKey("1").build());
        System.out.println(query);
    }



}
