package com.grpc.stockCheckerService;

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
    comments = "Source: inventory_management.proto")
public final class inventoryCheckerServiceGrpc {

  private inventoryCheckerServiceGrpc() {}

  public static final String SERVICE_NAME = "inventoryCheckerService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.grpc.orderService.product,
      com.grpc.orderService.product> getAddProductsToStockMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "addProductsToStock",
      requestType = com.grpc.orderService.product.class,
      responseType = com.grpc.orderService.product.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.grpc.orderService.product,
      com.grpc.orderService.product> getAddProductsToStockMethod() {
    io.grpc.MethodDescriptor<com.grpc.orderService.product, com.grpc.orderService.product> getAddProductsToStockMethod;
    if ((getAddProductsToStockMethod = inventoryCheckerServiceGrpc.getAddProductsToStockMethod) == null) {
      synchronized (inventoryCheckerServiceGrpc.class) {
        if ((getAddProductsToStockMethod = inventoryCheckerServiceGrpc.getAddProductsToStockMethod) == null) {
          inventoryCheckerServiceGrpc.getAddProductsToStockMethod = getAddProductsToStockMethod = 
              io.grpc.MethodDescriptor.<com.grpc.orderService.product, com.grpc.orderService.product>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "inventoryCheckerService", "addProductsToStock"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.orderService.product.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.orderService.product.getDefaultInstance()))
                  .setSchemaDescriptor(new inventoryCheckerServiceMethodDescriptorSupplier("addProductsToStock"))
                  .build();
          }
        }
     }
     return getAddProductsToStockMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.grpc.orderService.product,
      com.grpc.orderService.product> getUpdateProductInfoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "updateProductInfo",
      requestType = com.grpc.orderService.product.class,
      responseType = com.grpc.orderService.product.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.grpc.orderService.product,
      com.grpc.orderService.product> getUpdateProductInfoMethod() {
    io.grpc.MethodDescriptor<com.grpc.orderService.product, com.grpc.orderService.product> getUpdateProductInfoMethod;
    if ((getUpdateProductInfoMethod = inventoryCheckerServiceGrpc.getUpdateProductInfoMethod) == null) {
      synchronized (inventoryCheckerServiceGrpc.class) {
        if ((getUpdateProductInfoMethod = inventoryCheckerServiceGrpc.getUpdateProductInfoMethod) == null) {
          inventoryCheckerServiceGrpc.getUpdateProductInfoMethod = getUpdateProductInfoMethod = 
              io.grpc.MethodDescriptor.<com.grpc.orderService.product, com.grpc.orderService.product>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "inventoryCheckerService", "updateProductInfo"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.orderService.product.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.orderService.product.getDefaultInstance()))
                  .setSchemaDescriptor(new inventoryCheckerServiceMethodDescriptorSupplier("updateProductInfo"))
                  .build();
          }
        }
     }
     return getUpdateProductInfoMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.grpc.stockCheckerService.lowStockRequest,
      com.grpc.stockCheckerService.lowStockResponse> getCheckLowStockMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "checkLowStock",
      requestType = com.grpc.stockCheckerService.lowStockRequest.class,
      responseType = com.grpc.stockCheckerService.lowStockResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.grpc.stockCheckerService.lowStockRequest,
      com.grpc.stockCheckerService.lowStockResponse> getCheckLowStockMethod() {
    io.grpc.MethodDescriptor<com.grpc.stockCheckerService.lowStockRequest, com.grpc.stockCheckerService.lowStockResponse> getCheckLowStockMethod;
    if ((getCheckLowStockMethod = inventoryCheckerServiceGrpc.getCheckLowStockMethod) == null) {
      synchronized (inventoryCheckerServiceGrpc.class) {
        if ((getCheckLowStockMethod = inventoryCheckerServiceGrpc.getCheckLowStockMethod) == null) {
          inventoryCheckerServiceGrpc.getCheckLowStockMethod = getCheckLowStockMethod = 
              io.grpc.MethodDescriptor.<com.grpc.stockCheckerService.lowStockRequest, com.grpc.stockCheckerService.lowStockResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "inventoryCheckerService", "checkLowStock"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.stockCheckerService.lowStockRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.stockCheckerService.lowStockResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new inventoryCheckerServiceMethodDescriptorSupplier("checkLowStock"))
                  .build();
          }
        }
     }
     return getCheckLowStockMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static inventoryCheckerServiceStub newStub(io.grpc.Channel channel) {
    return new inventoryCheckerServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static inventoryCheckerServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new inventoryCheckerServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static inventoryCheckerServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new inventoryCheckerServiceFutureStub(channel);
  }

  /**
   * <pre>
   *Explain method &amp; message payload for all
   * </pre>
   */
  public static abstract class inventoryCheckerServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     *Add products to stock
     * </pre>
     */
    public void addProductsToStock(com.grpc.orderService.product request,
        io.grpc.stub.StreamObserver<com.grpc.orderService.product> responseObserver) {
      asyncUnimplementedUnaryCall(getAddProductsToStockMethod(), responseObserver);
    }

    /**
     * <pre>
     *Update Stock info of a product
     * </pre>
     */
    public void updateProductInfo(com.grpc.orderService.product request,
        io.grpc.stub.StreamObserver<com.grpc.orderService.product> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateProductInfoMethod(), responseObserver);
    }

    /**
     * <pre>
     *check how many items have less than 10 items in stock, send back multiple items
     * </pre>
     */
    public void checkLowStock(com.grpc.stockCheckerService.lowStockRequest request,
        io.grpc.stub.StreamObserver<com.grpc.stockCheckerService.lowStockResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getCheckLowStockMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getAddProductsToStockMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.grpc.orderService.product,
                com.grpc.orderService.product>(
                  this, METHODID_ADD_PRODUCTS_TO_STOCK)))
          .addMethod(
            getUpdateProductInfoMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.grpc.orderService.product,
                com.grpc.orderService.product>(
                  this, METHODID_UPDATE_PRODUCT_INFO)))
          .addMethod(
            getCheckLowStockMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.grpc.stockCheckerService.lowStockRequest,
                com.grpc.stockCheckerService.lowStockResponse>(
                  this, METHODID_CHECK_LOW_STOCK)))
          .build();
    }
  }

  /**
   * <pre>
   *Explain method &amp; message payload for all
   * </pre>
   */
  public static final class inventoryCheckerServiceStub extends io.grpc.stub.AbstractStub<inventoryCheckerServiceStub> {
    private inventoryCheckerServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private inventoryCheckerServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected inventoryCheckerServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new inventoryCheckerServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     *Add products to stock
     * </pre>
     */
    public void addProductsToStock(com.grpc.orderService.product request,
        io.grpc.stub.StreamObserver<com.grpc.orderService.product> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getAddProductsToStockMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *Update Stock info of a product
     * </pre>
     */
    public void updateProductInfo(com.grpc.orderService.product request,
        io.grpc.stub.StreamObserver<com.grpc.orderService.product> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateProductInfoMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *check how many items have less than 10 items in stock, send back multiple items
     * </pre>
     */
    public void checkLowStock(com.grpc.stockCheckerService.lowStockRequest request,
        io.grpc.stub.StreamObserver<com.grpc.stockCheckerService.lowStockResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCheckLowStockMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   *Explain method &amp; message payload for all
   * </pre>
   */
  public static final class inventoryCheckerServiceBlockingStub extends io.grpc.stub.AbstractStub<inventoryCheckerServiceBlockingStub> {
    private inventoryCheckerServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private inventoryCheckerServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected inventoryCheckerServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new inventoryCheckerServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     *Add products to stock
     * </pre>
     */
    public com.grpc.orderService.product addProductsToStock(com.grpc.orderService.product request) {
      return blockingUnaryCall(
          getChannel(), getAddProductsToStockMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     *Update Stock info of a product
     * </pre>
     */
    public com.grpc.orderService.product updateProductInfo(com.grpc.orderService.product request) {
      return blockingUnaryCall(
          getChannel(), getUpdateProductInfoMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     *check how many items have less than 10 items in stock, send back multiple items
     * </pre>
     */
    public com.grpc.stockCheckerService.lowStockResponse checkLowStock(com.grpc.stockCheckerService.lowStockRequest request) {
      return blockingUnaryCall(
          getChannel(), getCheckLowStockMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   *Explain method &amp; message payload for all
   * </pre>
   */
  public static final class inventoryCheckerServiceFutureStub extends io.grpc.stub.AbstractStub<inventoryCheckerServiceFutureStub> {
    private inventoryCheckerServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private inventoryCheckerServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected inventoryCheckerServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new inventoryCheckerServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     *Add products to stock
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.grpc.orderService.product> addProductsToStock(
        com.grpc.orderService.product request) {
      return futureUnaryCall(
          getChannel().newCall(getAddProductsToStockMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     *Update Stock info of a product
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.grpc.orderService.product> updateProductInfo(
        com.grpc.orderService.product request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateProductInfoMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     *check how many items have less than 10 items in stock, send back multiple items
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.grpc.stockCheckerService.lowStockResponse> checkLowStock(
        com.grpc.stockCheckerService.lowStockRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCheckLowStockMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ADD_PRODUCTS_TO_STOCK = 0;
  private static final int METHODID_UPDATE_PRODUCT_INFO = 1;
  private static final int METHODID_CHECK_LOW_STOCK = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final inventoryCheckerServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(inventoryCheckerServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ADD_PRODUCTS_TO_STOCK:
          serviceImpl.addProductsToStock((com.grpc.orderService.product) request,
              (io.grpc.stub.StreamObserver<com.grpc.orderService.product>) responseObserver);
          break;
        case METHODID_UPDATE_PRODUCT_INFO:
          serviceImpl.updateProductInfo((com.grpc.orderService.product) request,
              (io.grpc.stub.StreamObserver<com.grpc.orderService.product>) responseObserver);
          break;
        case METHODID_CHECK_LOW_STOCK:
          serviceImpl.checkLowStock((com.grpc.stockCheckerService.lowStockRequest) request,
              (io.grpc.stub.StreamObserver<com.grpc.stockCheckerService.lowStockResponse>) responseObserver);
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

  private static abstract class inventoryCheckerServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    inventoryCheckerServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.grpc.stockCheckerService.InventoryManagement.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("inventoryCheckerService");
    }
  }

  private static final class inventoryCheckerServiceFileDescriptorSupplier
      extends inventoryCheckerServiceBaseDescriptorSupplier {
    inventoryCheckerServiceFileDescriptorSupplier() {}
  }

  private static final class inventoryCheckerServiceMethodDescriptorSupplier
      extends inventoryCheckerServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    inventoryCheckerServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (inventoryCheckerServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new inventoryCheckerServiceFileDescriptorSupplier())
              .addMethod(getAddProductsToStockMethod())
              .addMethod(getUpdateProductInfoMethod())
              .addMethod(getCheckLowStockMethod())
              .build();
        }
      }
    }
    return result;
  }
}
