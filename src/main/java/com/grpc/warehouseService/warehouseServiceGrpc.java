package com.grpc.warehouseService;

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
 * <pre>
 *Explain method &amp; message payload for all
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: update_warehouse_service.proto")
public final class warehouseServiceGrpc {

  private warehouseServiceGrpc() {}

  public static final String SERVICE_NAME = "warehouseService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.grpc.warehouseService.reportRequest,
      com.grpc.warehouseService.reportResponse> getGenerateReportStreamMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "generateReportStream",
      requestType = com.grpc.warehouseService.reportRequest.class,
      responseType = com.grpc.warehouseService.reportResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.grpc.warehouseService.reportRequest,
      com.grpc.warehouseService.reportResponse> getGenerateReportStreamMethod() {
    io.grpc.MethodDescriptor<com.grpc.warehouseService.reportRequest, com.grpc.warehouseService.reportResponse> getGenerateReportStreamMethod;
    if ((getGenerateReportStreamMethod = warehouseServiceGrpc.getGenerateReportStreamMethod) == null) {
      synchronized (warehouseServiceGrpc.class) {
        if ((getGenerateReportStreamMethod = warehouseServiceGrpc.getGenerateReportStreamMethod) == null) {
          warehouseServiceGrpc.getGenerateReportStreamMethod = getGenerateReportStreamMethod = 
              io.grpc.MethodDescriptor.<com.grpc.warehouseService.reportRequest, com.grpc.warehouseService.reportResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "warehouseService", "generateReportStream"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.warehouseService.reportRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.warehouseService.reportResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new warehouseServiceMethodDescriptorSupplier("generateReportStream"))
                  .build();
          }
        }
     }
     return getGenerateReportStreamMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.grpc.warehouseService.orderNumberRequest,
      com.grpc.warehouseService.orderNumberResponse> getReportAnOrderMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "reportAnOrder",
      requestType = com.grpc.warehouseService.orderNumberRequest.class,
      responseType = com.grpc.warehouseService.orderNumberResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.grpc.warehouseService.orderNumberRequest,
      com.grpc.warehouseService.orderNumberResponse> getReportAnOrderMethod() {
    io.grpc.MethodDescriptor<com.grpc.warehouseService.orderNumberRequest, com.grpc.warehouseService.orderNumberResponse> getReportAnOrderMethod;
    if ((getReportAnOrderMethod = warehouseServiceGrpc.getReportAnOrderMethod) == null) {
      synchronized (warehouseServiceGrpc.class) {
        if ((getReportAnOrderMethod = warehouseServiceGrpc.getReportAnOrderMethod) == null) {
          warehouseServiceGrpc.getReportAnOrderMethod = getReportAnOrderMethod = 
              io.grpc.MethodDescriptor.<com.grpc.warehouseService.orderNumberRequest, com.grpc.warehouseService.orderNumberResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "warehouseService", "reportAnOrder"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.warehouseService.orderNumberRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.warehouseService.orderNumberResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new warehouseServiceMethodDescriptorSupplier("reportAnOrder"))
                  .build();
          }
        }
     }
     return getReportAnOrderMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.grpc.warehouseService.lastOrdersRequest,
      com.grpc.warehouseService.lastOrdersResponse> getCheckLastOrdersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "checkLastOrders",
      requestType = com.grpc.warehouseService.lastOrdersRequest.class,
      responseType = com.grpc.warehouseService.lastOrdersResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.grpc.warehouseService.lastOrdersRequest,
      com.grpc.warehouseService.lastOrdersResponse> getCheckLastOrdersMethod() {
    io.grpc.MethodDescriptor<com.grpc.warehouseService.lastOrdersRequest, com.grpc.warehouseService.lastOrdersResponse> getCheckLastOrdersMethod;
    if ((getCheckLastOrdersMethod = warehouseServiceGrpc.getCheckLastOrdersMethod) == null) {
      synchronized (warehouseServiceGrpc.class) {
        if ((getCheckLastOrdersMethod = warehouseServiceGrpc.getCheckLastOrdersMethod) == null) {
          warehouseServiceGrpc.getCheckLastOrdersMethod = getCheckLastOrdersMethod = 
              io.grpc.MethodDescriptor.<com.grpc.warehouseService.lastOrdersRequest, com.grpc.warehouseService.lastOrdersResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "warehouseService", "checkLastOrders"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.warehouseService.lastOrdersRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.warehouseService.lastOrdersResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new warehouseServiceMethodDescriptorSupplier("checkLastOrders"))
                  .build();
          }
        }
     }
     return getCheckLastOrdersMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static warehouseServiceStub newStub(io.grpc.Channel channel) {
    return new warehouseServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static warehouseServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new warehouseServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static warehouseServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new warehouseServiceFutureStub(channel);
  }

  /**
   * <pre>
   *Explain method &amp; message payload for all
   * </pre>
   */
  public static abstract class warehouseServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     *report completed orders
     * </pre>
     */
    public void generateReportStream(com.grpc.warehouseService.reportRequest request,
        io.grpc.stub.StreamObserver<com.grpc.warehouseService.reportResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGenerateReportStreamMethod(), responseObserver);
    }

    /**
     * <pre>
     *search order number
     * </pre>
     */
    public void reportAnOrder(com.grpc.warehouseService.orderNumberRequest request,
        io.grpc.stub.StreamObserver<com.grpc.warehouseService.orderNumberResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getReportAnOrderMethod(), responseObserver);
    }

    /**
     * <pre>
     *Send shipping information
     * </pre>
     */
    public void checkLastOrders(com.grpc.warehouseService.lastOrdersRequest request,
        io.grpc.stub.StreamObserver<com.grpc.warehouseService.lastOrdersResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getCheckLastOrdersMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGenerateReportStreamMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                com.grpc.warehouseService.reportRequest,
                com.grpc.warehouseService.reportResponse>(
                  this, METHODID_GENERATE_REPORT_STREAM)))
          .addMethod(
            getReportAnOrderMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.grpc.warehouseService.orderNumberRequest,
                com.grpc.warehouseService.orderNumberResponse>(
                  this, METHODID_REPORT_AN_ORDER)))
          .addMethod(
            getCheckLastOrdersMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.grpc.warehouseService.lastOrdersRequest,
                com.grpc.warehouseService.lastOrdersResponse>(
                  this, METHODID_CHECK_LAST_ORDERS)))
          .build();
    }
  }

  /**
   * <pre>
   *Explain method &amp; message payload for all
   * </pre>
   */
  public static final class warehouseServiceStub extends io.grpc.stub.AbstractStub<warehouseServiceStub> {
    private warehouseServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private warehouseServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected warehouseServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new warehouseServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     *report completed orders
     * </pre>
     */
    public void generateReportStream(com.grpc.warehouseService.reportRequest request,
        io.grpc.stub.StreamObserver<com.grpc.warehouseService.reportResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getGenerateReportStreamMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *search order number
     * </pre>
     */
    public void reportAnOrder(com.grpc.warehouseService.orderNumberRequest request,
        io.grpc.stub.StreamObserver<com.grpc.warehouseService.orderNumberResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReportAnOrderMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *Send shipping information
     * </pre>
     */
    public void checkLastOrders(com.grpc.warehouseService.lastOrdersRequest request,
        io.grpc.stub.StreamObserver<com.grpc.warehouseService.lastOrdersResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCheckLastOrdersMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   *Explain method &amp; message payload for all
   * </pre>
   */
  public static final class warehouseServiceBlockingStub extends io.grpc.stub.AbstractStub<warehouseServiceBlockingStub> {
    private warehouseServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private warehouseServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected warehouseServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new warehouseServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     *report completed orders
     * </pre>
     */
    public java.util.Iterator<com.grpc.warehouseService.reportResponse> generateReportStream(
        com.grpc.warehouseService.reportRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getGenerateReportStreamMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     *search order number
     * </pre>
     */
    public com.grpc.warehouseService.orderNumberResponse reportAnOrder(com.grpc.warehouseService.orderNumberRequest request) {
      return blockingUnaryCall(
          getChannel(), getReportAnOrderMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     *Send shipping information
     * </pre>
     */
    public com.grpc.warehouseService.lastOrdersResponse checkLastOrders(com.grpc.warehouseService.lastOrdersRequest request) {
      return blockingUnaryCall(
          getChannel(), getCheckLastOrdersMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   *Explain method &amp; message payload for all
   * </pre>
   */
  public static final class warehouseServiceFutureStub extends io.grpc.stub.AbstractStub<warehouseServiceFutureStub> {
    private warehouseServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private warehouseServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected warehouseServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new warehouseServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     *search order number
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.grpc.warehouseService.orderNumberResponse> reportAnOrder(
        com.grpc.warehouseService.orderNumberRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getReportAnOrderMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     *Send shipping information
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.grpc.warehouseService.lastOrdersResponse> checkLastOrders(
        com.grpc.warehouseService.lastOrdersRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCheckLastOrdersMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GENERATE_REPORT_STREAM = 0;
  private static final int METHODID_REPORT_AN_ORDER = 1;
  private static final int METHODID_CHECK_LAST_ORDERS = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final warehouseServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(warehouseServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GENERATE_REPORT_STREAM:
          serviceImpl.generateReportStream((com.grpc.warehouseService.reportRequest) request,
              (io.grpc.stub.StreamObserver<com.grpc.warehouseService.reportResponse>) responseObserver);
          break;
        case METHODID_REPORT_AN_ORDER:
          serviceImpl.reportAnOrder((com.grpc.warehouseService.orderNumberRequest) request,
              (io.grpc.stub.StreamObserver<com.grpc.warehouseService.orderNumberResponse>) responseObserver);
          break;
        case METHODID_CHECK_LAST_ORDERS:
          serviceImpl.checkLastOrders((com.grpc.warehouseService.lastOrdersRequest) request,
              (io.grpc.stub.StreamObserver<com.grpc.warehouseService.lastOrdersResponse>) responseObserver);
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

  private static abstract class warehouseServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    warehouseServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.grpc.warehouseService.UpdateWarehouseService.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("warehouseService");
    }
  }

  private static final class warehouseServiceFileDescriptorSupplier
      extends warehouseServiceBaseDescriptorSupplier {
    warehouseServiceFileDescriptorSupplier() {}
  }

  private static final class warehouseServiceMethodDescriptorSupplier
      extends warehouseServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    warehouseServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (warehouseServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new warehouseServiceFileDescriptorSupplier())
              .addMethod(getGenerateReportStreamMethod())
              .addMethod(getReportAnOrderMethod())
              .addMethod(getCheckLastOrdersMethod())
              .build();
        }
      }
    }
    return result;
  }
}
