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
public final class checkStockGrpc {

  private checkStockGrpc() {}

  public static final String SERVICE_NAME = "checkStock";

  // Static method descriptors that strictly reflect the proto.
  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static checkStockStub newStub(io.grpc.Channel channel) {
    return new checkStockStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static checkStockBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new checkStockBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static checkStockFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new checkStockFutureStub(channel);
  }

  /**
   * <pre>
   *Explain method &amp; message payload for all
   * </pre>
   */
  public static abstract class checkStockImplBase implements io.grpc.BindableService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .build();
    }
  }

  /**
   * <pre>
   *Explain method &amp; message payload for all
   * </pre>
   */
  public static final class checkStockStub extends io.grpc.stub.AbstractStub<checkStockStub> {
    private checkStockStub(io.grpc.Channel channel) {
      super(channel);
    }

    private checkStockStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected checkStockStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new checkStockStub(channel, callOptions);
    }
  }

  /**
   * <pre>
   *Explain method &amp; message payload for all
   * </pre>
   */
  public static final class checkStockBlockingStub extends io.grpc.stub.AbstractStub<checkStockBlockingStub> {
    private checkStockBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private checkStockBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected checkStockBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new checkStockBlockingStub(channel, callOptions);
    }
  }

  /**
   * <pre>
   *Explain method &amp; message payload for all
   * </pre>
   */
  public static final class checkStockFutureStub extends io.grpc.stub.AbstractStub<checkStockFutureStub> {
    private checkStockFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private checkStockFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected checkStockFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new checkStockFutureStub(channel, callOptions);
    }
  }


  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final checkStockImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(checkStockImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
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

  private static abstract class checkStockBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    checkStockBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.grpc.warehouseService.UpdateWarehouseService.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("checkStock");
    }
  }

  private static final class checkStockFileDescriptorSupplier
      extends checkStockBaseDescriptorSupplier {
    checkStockFileDescriptorSupplier() {}
  }

  private static final class checkStockMethodDescriptorSupplier
      extends checkStockBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    checkStockMethodDescriptorSupplier(String methodName) {
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
      synchronized (checkStockGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new checkStockFileDescriptorSupplier())
              .build();
        }
      }
    }
    return result;
  }
}
