package com.jgz.config.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: ConfigService.proto")
public final class ConfigServiceGrpc {

  private ConfigServiceGrpc() {}

  public static final String SERVICE_NAME = "com.jgz.config.grpc.ConfigService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.jgz.config.grpc.ConfigServiceOuterClass.ConfigRequest,
      com.jgz.config.grpc.ConfigServiceOuterClass.ConfigResponse> getQueryMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "query",
      requestType = com.jgz.config.grpc.ConfigServiceOuterClass.ConfigRequest.class,
      responseType = com.jgz.config.grpc.ConfigServiceOuterClass.ConfigResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.jgz.config.grpc.ConfigServiceOuterClass.ConfigRequest,
      com.jgz.config.grpc.ConfigServiceOuterClass.ConfigResponse> getQueryMethod() {
    io.grpc.MethodDescriptor<com.jgz.config.grpc.ConfigServiceOuterClass.ConfigRequest, com.jgz.config.grpc.ConfigServiceOuterClass.ConfigResponse> getQueryMethod;
    if ((getQueryMethod = ConfigServiceGrpc.getQueryMethod) == null) {
      synchronized (ConfigServiceGrpc.class) {
        if ((getQueryMethod = ConfigServiceGrpc.getQueryMethod) == null) {
          ConfigServiceGrpc.getQueryMethod = getQueryMethod = 
              io.grpc.MethodDescriptor.<com.jgz.config.grpc.ConfigServiceOuterClass.ConfigRequest, com.jgz.config.grpc.ConfigServiceOuterClass.ConfigResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "com.jgz.config.grpc.ConfigService", "query"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.jgz.config.grpc.ConfigServiceOuterClass.ConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.jgz.config.grpc.ConfigServiceOuterClass.ConfigResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new ConfigServiceMethodDescriptorSupplier("query"))
                  .build();
          }
        }
     }
     return getQueryMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ConfigServiceStub newStub(io.grpc.Channel channel) {
    return new ConfigServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ConfigServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new ConfigServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ConfigServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new ConfigServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class ConfigServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void query(com.jgz.config.grpc.ConfigServiceOuterClass.ConfigRequest request,
        io.grpc.stub.StreamObserver<com.jgz.config.grpc.ConfigServiceOuterClass.ConfigResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getQueryMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getQueryMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.jgz.config.grpc.ConfigServiceOuterClass.ConfigRequest,
                com.jgz.config.grpc.ConfigServiceOuterClass.ConfigResponse>(
                  this, METHODID_QUERY)))
          .build();
    }
  }

  /**
   */
  public static final class ConfigServiceStub extends io.grpc.stub.AbstractStub<ConfigServiceStub> {
    private ConfigServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ConfigServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ConfigServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ConfigServiceStub(channel, callOptions);
    }

    /**
     */
    public void query(com.jgz.config.grpc.ConfigServiceOuterClass.ConfigRequest request,
        io.grpc.stub.StreamObserver<com.jgz.config.grpc.ConfigServiceOuterClass.ConfigResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getQueryMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class ConfigServiceBlockingStub extends io.grpc.stub.AbstractStub<ConfigServiceBlockingStub> {
    private ConfigServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ConfigServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ConfigServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ConfigServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.jgz.config.grpc.ConfigServiceOuterClass.ConfigResponse query(com.jgz.config.grpc.ConfigServiceOuterClass.ConfigRequest request) {
      return blockingUnaryCall(
          getChannel(), getQueryMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class ConfigServiceFutureStub extends io.grpc.stub.AbstractStub<ConfigServiceFutureStub> {
    private ConfigServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ConfigServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ConfigServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ConfigServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.jgz.config.grpc.ConfigServiceOuterClass.ConfigResponse> query(
        com.jgz.config.grpc.ConfigServiceOuterClass.ConfigRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getQueryMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_QUERY = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ConfigServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ConfigServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_QUERY:
          serviceImpl.query((com.jgz.config.grpc.ConfigServiceOuterClass.ConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.jgz.config.grpc.ConfigServiceOuterClass.ConfigResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class ConfigServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ConfigServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.jgz.config.grpc.ConfigServiceOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ConfigService");
    }
  }

  private static final class ConfigServiceFileDescriptorSupplier
      extends ConfigServiceBaseDescriptorSupplier {
    ConfigServiceFileDescriptorSupplier() {}
  }

  private static final class ConfigServiceMethodDescriptorSupplier
      extends ConfigServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ConfigServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (ConfigServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ConfigServiceFileDescriptorSupplier())
              .addMethod(getQueryMethod())
              .build();
        }
      }
    }
    return result;
  }
}
