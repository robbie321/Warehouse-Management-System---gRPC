// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: automate_orders.proto

package com.grpc.orderService;

public interface StockQuoteRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:StockQuoteRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>.product product = 1;</code>
   */
  boolean hasProduct();
  /**
   * <code>.product product = 1;</code>
   */
  com.grpc.orderService.product getProduct();
  /**
   * <code>.product product = 1;</code>
   */
  com.grpc.orderService.productOrBuilder getProductOrBuilder();

  /**
   * <code>int32 quantity = 2;</code>
   */
  int getQuantity();
}
