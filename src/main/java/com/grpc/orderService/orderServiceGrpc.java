package com.grpc.orderService;

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
    comments = "Source: automate_orders.proto")
public final class orderServiceGrpc {

  private orderServiceGrpc() {}

  public static final String SERVICE_NAME = "orderService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.grpc.orderService.orderRequest,
      com.grpc.orderService.orderResponse> getCreateOrderMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "createOrder",
      requestType = com.grpc.orderService.orderRequest.class,
      responseType = com.grpc.orderService.orderResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.grpc.orderService.orderRequest,
      com.grpc.orderService.orderResponse> getCreateOrderMethod() {
    io.grpc.MethodDescriptor<com.grpc.orderService.orderRequest, com.grpc.orderService.orderResponse> getCreateOrderMethod;
    if ((getCreateOrderMethod = orderServiceGrpc.getCreateOrderMethod) == null) {
      synchronized (orderServiceGrpc.class) {
        if ((getCreateOrderMethod = orderServiceGrpc.getCreateOrderMethod) == null) {
          orderServiceGrpc.getCreateOrderMethod = getCreateOrderMethod = 
              io.grpc.MethodDescriptor.<com.grpc.orderService.orderRequest, com.grpc.orderService.orderResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "orderService", "createOrder"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.orderService.orderRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.orderService.orderResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new orderServiceMethodDescriptorSupplier("createOrder"))
                  .build();
          }
        }
     }
     return getCreateOrderMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.grpc.orderService.StockQuoteRequest,
      com.grpc.orderService.StockQuoteResponse> getStreamStockQuoteMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "streamStockQuote",
      requestType = com.grpc.orderService.StockQuoteRequest.class,
      responseType = com.grpc.orderService.StockQuoteResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<com.grpc.orderService.StockQuoteRequest,
      com.grpc.orderService.StockQuoteResponse> getStreamStockQuoteMethod() {
    io.grpc.MethodDescriptor<com.grpc.orderService.StockQuoteRequest, com.grpc.orderService.StockQuoteResponse> getStreamStockQuoteMethod;
    if ((getStreamStockQuoteMethod = orderServiceGrpc.getStreamStockQuoteMethod) == null) {
      synchronized (orderServiceGrpc.class) {
        if ((getStreamStockQuoteMethod = orderServiceGrpc.getStreamStockQuoteMethod) == null) {
          orderServiceGrpc.getStreamStockQuoteMethod = getStreamStockQuoteMethod = 
              io.grpc.MethodDescriptor.<com.grpc.orderService.StockQuoteRequest, com.grpc.orderService.StockQuoteResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "orderService", "streamStockQuote"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.orderService.StockQuoteRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.orderService.StockQuoteResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new orderServiceMethodDescriptorSupplier("streamStockQuote"))
                  .build();
          }
        }
     }
     return getStreamStockQuoteMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.grpc.orderService.FilterPriceRequest,
      com.grpc.orderService.FilterPriceResponse> getFilterPriceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "FilterPrice",
      requestType = com.grpc.orderService.FilterPriceRequest.class,
      responseType = com.grpc.orderService.FilterPriceResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.grpc.orderService.FilterPriceRequest,
      com.grpc.orderService.FilterPriceResponse> getFilterPriceMethod() {
    io.grpc.MethodDescriptor<com.grpc.orderService.FilterPriceRequest, com.grpc.orderService.FilterPriceResponse> getFilterPriceMethod;
    if ((getFilterPriceMethod = orderServiceGrpc.getFilterPriceMethod) == null) {
      synchronized (orderServiceGrpc.class) {
        if ((getFilterPriceMethod = orderServiceGrpc.getFilterPriceMethod) == null) {
          orderServiceGrpc.getFilterPriceMethod = getFilterPriceMethod = 
              io.grpc.MethodDescriptor.<com.grpc.orderService.FilterPriceRequest, com.grpc.orderService.FilterPriceResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "orderService", "FilterPrice"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.orderService.FilterPriceRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.orderService.FilterPriceResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new orderServiceMethodDescriptorSupplier("FilterPrice"))
                  .build();
          }
        }
     }
     return getFilterPriceMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static orderServiceStub newStub(io.grpc.Channel channel) {
    return new orderServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static orderServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new orderServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static orderServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new orderServiceFutureStub(channel);
  }

  /**
   * <pre>
   *Explain method &amp; message payload for all
   * </pre>
   */
  public static abstract class orderServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     *create an order request, respond with order confirmation
     * </pre>
     */
    public void createOrder(com.grpc.orderService.orderRequest request,
        io.grpc.stub.StreamObserver<com.grpc.orderService.orderResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateOrderMethod(), responseObserver);
    }

    /**
     * <pre>
     **
     *Client sends 1 or multiple requests, server responds with 1 result
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.grpc.orderService.StockQuoteRequest> streamStockQuote(
        io.grpc.stub.StreamObserver<com.grpc.orderService.StockQuoteResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getStreamStockQuoteMethod(), responseObserver);
    }

    /**
     * <pre>
     **
     *Client can send 1 or multiple requests, server responds with 1 cart result
     * </pre>
     */
    public void filterPrice(com.grpc.orderService.FilterPriceRequest request,
        io.grpc.stub.StreamObserver<com.grpc.orderService.FilterPriceResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getFilterPriceMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCreateOrderMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.grpc.orderService.orderRequest,
                com.grpc.orderService.orderResponse>(
                  this, METHODID_CREATE_ORDER)))
          .addMethod(
            getStreamStockQuoteMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                com.grpc.orderService.StockQuoteRequest,
                com.grpc.orderService.StockQuoteResponse>(
                  this, METHODID_STREAM_STOCK_QUOTE)))
          .addMethod(
            getFilterPriceMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                com.grpc.orderService.FilterPriceRequest,
                com.grpc.orderService.FilterPriceResponse>(
                  this, METHODID_FILTER_PRICE)))
          .build();
    }
  }

  /**
   * <pre>
   *Explain method &amp; message payload for all
   * </pre>
   */
  public static final class orderServiceStub extends io.grpc.stub.AbstractStub<orderServiceStub> {
    private orderServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private orderServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected orderServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new orderServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     *create an order request, respond with order confirmation
     * </pre>
     */
    public void createOrder(com.grpc.orderService.orderRequest request,
        io.grpc.stub.StreamObserver<com.grpc.orderService.orderResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateOrderMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     **
     *Client sends 1 or multiple requests, server responds with 1 result
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.grpc.orderService.StockQuoteRequest> streamStockQuote(
        io.grpc.stub.StreamObserver<com.grpc.orderService.StockQuoteResponse> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getStreamStockQuoteMethod(), getCallOptions()), responseObserver);
    }

    /**
     * <pre>
     **
     *Client can send 1 or multiple requests, server responds with 1 cart result
     * </pre>
     */
    public void filterPrice(com.grpc.orderService.FilterPriceRequest request,
        io.grpc.stub.StreamObserver<com.grpc.orderService.FilterPriceResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getFilterPriceMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   *Explain method &amp; message payload for all
   * </pre>
   */
  public static final class orderServiceBlockingStub extends io.grpc.stub.AbstractStub<orderServiceBlockingStub> {
    private orderServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private orderServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected orderServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new orderServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     *create an order request, respond with order confirmation
     * </pre>
     */
    public com.grpc.orderService.orderResponse createOrder(com.grpc.orderService.orderRequest request) {
      return blockingUnaryCall(
          getChannel(), getCreateOrderMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     **
     *Client can send 1 or multiple requests, server responds with 1 cart result
     * </pre>
     */
    public java.util.Iterator<com.grpc.orderService.FilterPriceResponse> filterPrice(
        com.grpc.orderService.FilterPriceRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getFilterPriceMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   *Explain method &amp; message payload for all
   * </pre>
   */
  public static final class orderServiceFutureStub extends io.grpc.stub.AbstractStub<orderServiceFutureStub> {
    private orderServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private orderServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected orderServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new orderServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     *create an order request, respond with order confirmation
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.grpc.orderService.orderResponse> createOrder(
        com.grpc.orderService.orderRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateOrderMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_ORDER = 0;
  private static final int METHODID_FILTER_PRICE = 1;
  private static final int METHODID_STREAM_STOCK_QUOTE = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final orderServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(orderServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_ORDER:
          serviceImpl.createOrder((com.grpc.orderService.orderRequest) request,
              (io.grpc.stub.StreamObserver<com.grpc.orderService.orderResponse>) responseObserver);
          break;
        case METHODID_FILTER_PRICE:
          serviceImpl.filterPrice((com.grpc.orderService.FilterPriceRequest) request,
              (io.grpc.stub.StreamObserver<com.grpc.orderService.FilterPriceResponse>) responseObserver);
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
        case METHODID_STREAM_STOCK_QUOTE:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.streamStockQuote(
              (io.grpc.stub.StreamObserver<com.grpc.orderService.StockQuoteResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class orderServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    orderServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.grpc.orderService.AutomateOrdersImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("orderService");
    }
  }

  private static final class orderServiceFileDescriptorSupplier
      extends orderServiceBaseDescriptorSupplier {
    orderServiceFileDescriptorSupplier() {}
  }

  private static final class orderServiceMethodDescriptorSupplier
      extends orderServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    orderServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (orderServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new orderServiceFileDescriptorSupplier())
              .addMethod(getCreateOrderMethod())
              .addMethod(getStreamStockQuoteMethod())
              .addMethod(getFilterPriceMethod())
              .build();
        }
      }
    }
    return result;
  }
}
