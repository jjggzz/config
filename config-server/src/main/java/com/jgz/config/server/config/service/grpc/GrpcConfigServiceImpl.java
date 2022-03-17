package com.jgz.config.server.config.service.grpc;

import com.jgz.config.grpc.ConfigServiceGrpc;
import com.jgz.config.grpc.ConfigServiceOuterClass;
import com.jgz.config.server.config.mapper.ConfigMapper;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

import javax.annotation.Resource;

@GrpcService
public class GrpcConfigServiceImpl extends ConfigServiceGrpc.ConfigServiceImplBase  {

    @Resource
    private ConfigMapper configMapper;

    @Override
    public void query(ConfigServiceOuterClass.ConfigRequest request, StreamObserver<ConfigServiceOuterClass.ConfigResponse> responseObserver) {
        ConfigServiceOuterClass.ConfigResponse giao = ConfigServiceOuterClass.ConfigResponse.newBuilder().setKey("giao").build();
        responseObserver.onNext(giao);
        responseObserver.onCompleted();
    }
}
