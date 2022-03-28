// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: automate_orders.proto

package com.grpc.orderService;

/**
 * <pre>
 *quote
 * </pre>
 *
 * Protobuf type {@code StockQuoteResponse}
 */
public  final class StockQuoteResponse extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:StockQuoteResponse)
    StockQuoteResponseOrBuilder {
private static final long serialVersionUID = 0L;
  // Use StockQuoteResponse.newBuilder() to construct.
  private StockQuoteResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private StockQuoteResponse() {
    message_ = "";
    products_ = java.util.Collections.emptyList();
    price_ = 0;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private StockQuoteResponse(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 10: {
            java.lang.String s = input.readStringRequireUtf8();

            message_ = s;
            break;
          }
          case 18: {
            if (!((mutable_bitField0_ & 0x00000002) == 0x00000002)) {
              products_ = new java.util.ArrayList<com.grpc.orderService.product>();
              mutable_bitField0_ |= 0x00000002;
            }
            products_.add(
                input.readMessage(com.grpc.orderService.product.parser(), extensionRegistry));
            break;
          }
          case 24: {

            price_ = input.readInt32();
            break;
          }
          default: {
            if (!parseUnknownFieldProto3(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      if (((mutable_bitField0_ & 0x00000002) == 0x00000002)) {
        products_ = java.util.Collections.unmodifiableList(products_);
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.grpc.orderService.AutomateOrdersImpl.internal_static_StockQuoteResponse_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.grpc.orderService.AutomateOrdersImpl.internal_static_StockQuoteResponse_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.grpc.orderService.StockQuoteResponse.class, com.grpc.orderService.StockQuoteResponse.Builder.class);
  }

  private int bitField0_;
  public static final int MESSAGE_FIELD_NUMBER = 1;
  private volatile java.lang.Object message_;
  /**
   * <code>string message = 1;</code>
   */
  public java.lang.String getMessage() {
    java.lang.Object ref = message_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      message_ = s;
      return s;
    }
  }
  /**
   * <code>string message = 1;</code>
   */
  public com.google.protobuf.ByteString
      getMessageBytes() {
    java.lang.Object ref = message_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      message_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int PRODUCTS_FIELD_NUMBER = 2;
  private java.util.List<com.grpc.orderService.product> products_;
  /**
   * <code>repeated .product products = 2;</code>
   */
  public java.util.List<com.grpc.orderService.product> getProductsList() {
    return products_;
  }
  /**
   * <code>repeated .product products = 2;</code>
   */
  public java.util.List<? extends com.grpc.orderService.productOrBuilder> 
      getProductsOrBuilderList() {
    return products_;
  }
  /**
   * <code>repeated .product products = 2;</code>
   */
  public int getProductsCount() {
    return products_.size();
  }
  /**
   * <code>repeated .product products = 2;</code>
   */
  public com.grpc.orderService.product getProducts(int index) {
    return products_.get(index);
  }
  /**
   * <code>repeated .product products = 2;</code>
   */
  public com.grpc.orderService.productOrBuilder getProductsOrBuilder(
      int index) {
    return products_.get(index);
  }

  public static final int PRICE_FIELD_NUMBER = 3;
  private int price_;
  /**
   * <code>int32 price = 3;</code>
   */
  public int getPrice() {
    return price_;
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (!getMessageBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, message_);
    }
    for (int i = 0; i < products_.size(); i++) {
      output.writeMessage(2, products_.get(i));
    }
    if (price_ != 0) {
      output.writeInt32(3, price_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getMessageBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, message_);
    }
    for (int i = 0; i < products_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(2, products_.get(i));
    }
    if (price_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(3, price_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof com.grpc.orderService.StockQuoteResponse)) {
      return super.equals(obj);
    }
    com.grpc.orderService.StockQuoteResponse other = (com.grpc.orderService.StockQuoteResponse) obj;

    boolean result = true;
    result = result && getMessage()
        .equals(other.getMessage());
    result = result && getProductsList()
        .equals(other.getProductsList());
    result = result && (getPrice()
        == other.getPrice());
    result = result && unknownFields.equals(other.unknownFields);
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + MESSAGE_FIELD_NUMBER;
    hash = (53 * hash) + getMessage().hashCode();
    if (getProductsCount() > 0) {
      hash = (37 * hash) + PRODUCTS_FIELD_NUMBER;
      hash = (53 * hash) + getProductsList().hashCode();
    }
    hash = (37 * hash) + PRICE_FIELD_NUMBER;
    hash = (53 * hash) + getPrice();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.grpc.orderService.StockQuoteResponse parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.grpc.orderService.StockQuoteResponse parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.grpc.orderService.StockQuoteResponse parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.grpc.orderService.StockQuoteResponse parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.grpc.orderService.StockQuoteResponse parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.grpc.orderService.StockQuoteResponse parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.grpc.orderService.StockQuoteResponse parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.grpc.orderService.StockQuoteResponse parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.grpc.orderService.StockQuoteResponse parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.grpc.orderService.StockQuoteResponse parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.grpc.orderService.StockQuoteResponse parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.grpc.orderService.StockQuoteResponse parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(com.grpc.orderService.StockQuoteResponse prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * <pre>
   *quote
   * </pre>
   *
   * Protobuf type {@code StockQuoteResponse}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:StockQuoteResponse)
      com.grpc.orderService.StockQuoteResponseOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.grpc.orderService.AutomateOrdersImpl.internal_static_StockQuoteResponse_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.grpc.orderService.AutomateOrdersImpl.internal_static_StockQuoteResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.grpc.orderService.StockQuoteResponse.class, com.grpc.orderService.StockQuoteResponse.Builder.class);
    }

    // Construct using com.grpc.orderService.StockQuoteResponse.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
        getProductsFieldBuilder();
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      message_ = "";

      if (productsBuilder_ == null) {
        products_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000002);
      } else {
        productsBuilder_.clear();
      }
      price_ = 0;

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.grpc.orderService.AutomateOrdersImpl.internal_static_StockQuoteResponse_descriptor;
    }

    @java.lang.Override
    public com.grpc.orderService.StockQuoteResponse getDefaultInstanceForType() {
      return com.grpc.orderService.StockQuoteResponse.getDefaultInstance();
    }

    @java.lang.Override
    public com.grpc.orderService.StockQuoteResponse build() {
      com.grpc.orderService.StockQuoteResponse result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.grpc.orderService.StockQuoteResponse buildPartial() {
      com.grpc.orderService.StockQuoteResponse result = new com.grpc.orderService.StockQuoteResponse(this);
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      result.message_ = message_;
      if (productsBuilder_ == null) {
        if (((bitField0_ & 0x00000002) == 0x00000002)) {
          products_ = java.util.Collections.unmodifiableList(products_);
          bitField0_ = (bitField0_ & ~0x00000002);
        }
        result.products_ = products_;
      } else {
        result.products_ = productsBuilder_.build();
      }
      result.price_ = price_;
      result.bitField0_ = to_bitField0_;
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return (Builder) super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof com.grpc.orderService.StockQuoteResponse) {
        return mergeFrom((com.grpc.orderService.StockQuoteResponse)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.grpc.orderService.StockQuoteResponse other) {
      if (other == com.grpc.orderService.StockQuoteResponse.getDefaultInstance()) return this;
      if (!other.getMessage().isEmpty()) {
        message_ = other.message_;
        onChanged();
      }
      if (productsBuilder_ == null) {
        if (!other.products_.isEmpty()) {
          if (products_.isEmpty()) {
            products_ = other.products_;
            bitField0_ = (bitField0_ & ~0x00000002);
          } else {
            ensureProductsIsMutable();
            products_.addAll(other.products_);
          }
          onChanged();
        }
      } else {
        if (!other.products_.isEmpty()) {
          if (productsBuilder_.isEmpty()) {
            productsBuilder_.dispose();
            productsBuilder_ = null;
            products_ = other.products_;
            bitField0_ = (bitField0_ & ~0x00000002);
            productsBuilder_ = 
              com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                 getProductsFieldBuilder() : null;
          } else {
            productsBuilder_.addAllMessages(other.products_);
          }
        }
      }
      if (other.getPrice() != 0) {
        setPrice(other.getPrice());
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      com.grpc.orderService.StockQuoteResponse parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.grpc.orderService.StockQuoteResponse) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private java.lang.Object message_ = "";
    /**
     * <code>string message = 1;</code>
     */
    public java.lang.String getMessage() {
      java.lang.Object ref = message_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        message_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string message = 1;</code>
     */
    public com.google.protobuf.ByteString
        getMessageBytes() {
      java.lang.Object ref = message_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        message_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string message = 1;</code>
     */
    public Builder setMessage(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      message_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string message = 1;</code>
     */
    public Builder clearMessage() {
      
      message_ = getDefaultInstance().getMessage();
      onChanged();
      return this;
    }
    /**
     * <code>string message = 1;</code>
     */
    public Builder setMessageBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      message_ = value;
      onChanged();
      return this;
    }

    private java.util.List<com.grpc.orderService.product> products_ =
      java.util.Collections.emptyList();
    private void ensureProductsIsMutable() {
      if (!((bitField0_ & 0x00000002) == 0x00000002)) {
        products_ = new java.util.ArrayList<com.grpc.orderService.product>(products_);
        bitField0_ |= 0x00000002;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
        com.grpc.orderService.product, com.grpc.orderService.product.Builder, com.grpc.orderService.productOrBuilder> productsBuilder_;

    /**
     * <code>repeated .product products = 2;</code>
     */
    public java.util.List<com.grpc.orderService.product> getProductsList() {
      if (productsBuilder_ == null) {
        return java.util.Collections.unmodifiableList(products_);
      } else {
        return productsBuilder_.getMessageList();
      }
    }
    /**
     * <code>repeated .product products = 2;</code>
     */
    public int getProductsCount() {
      if (productsBuilder_ == null) {
        return products_.size();
      } else {
        return productsBuilder_.getCount();
      }
    }
    /**
     * <code>repeated .product products = 2;</code>
     */
    public com.grpc.orderService.product getProducts(int index) {
      if (productsBuilder_ == null) {
        return products_.get(index);
      } else {
        return productsBuilder_.getMessage(index);
      }
    }
    /**
     * <code>repeated .product products = 2;</code>
     */
    public Builder setProducts(
        int index, com.grpc.orderService.product value) {
      if (productsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureProductsIsMutable();
        products_.set(index, value);
        onChanged();
      } else {
        productsBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .product products = 2;</code>
     */
    public Builder setProducts(
        int index, com.grpc.orderService.product.Builder builderForValue) {
      if (productsBuilder_ == null) {
        ensureProductsIsMutable();
        products_.set(index, builderForValue.build());
        onChanged();
      } else {
        productsBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .product products = 2;</code>
     */
    public Builder addProducts(com.grpc.orderService.product value) {
      if (productsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureProductsIsMutable();
        products_.add(value);
        onChanged();
      } else {
        productsBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <code>repeated .product products = 2;</code>
     */
    public Builder addProducts(
        int index, com.grpc.orderService.product value) {
      if (productsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureProductsIsMutable();
        products_.add(index, value);
        onChanged();
      } else {
        productsBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .product products = 2;</code>
     */
    public Builder addProducts(
        com.grpc.orderService.product.Builder builderForValue) {
      if (productsBuilder_ == null) {
        ensureProductsIsMutable();
        products_.add(builderForValue.build());
        onChanged();
      } else {
        productsBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .product products = 2;</code>
     */
    public Builder addProducts(
        int index, com.grpc.orderService.product.Builder builderForValue) {
      if (productsBuilder_ == null) {
        ensureProductsIsMutable();
        products_.add(index, builderForValue.build());
        onChanged();
      } else {
        productsBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .product products = 2;</code>
     */
    public Builder addAllProducts(
        java.lang.Iterable<? extends com.grpc.orderService.product> values) {
      if (productsBuilder_ == null) {
        ensureProductsIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, products_);
        onChanged();
      } else {
        productsBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <code>repeated .product products = 2;</code>
     */
    public Builder clearProducts() {
      if (productsBuilder_ == null) {
        products_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000002);
        onChanged();
      } else {
        productsBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>repeated .product products = 2;</code>
     */
    public Builder removeProducts(int index) {
      if (productsBuilder_ == null) {
        ensureProductsIsMutable();
        products_.remove(index);
        onChanged();
      } else {
        productsBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <code>repeated .product products = 2;</code>
     */
    public com.grpc.orderService.product.Builder getProductsBuilder(
        int index) {
      return getProductsFieldBuilder().getBuilder(index);
    }
    /**
     * <code>repeated .product products = 2;</code>
     */
    public com.grpc.orderService.productOrBuilder getProductsOrBuilder(
        int index) {
      if (productsBuilder_ == null) {
        return products_.get(index);  } else {
        return productsBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <code>repeated .product products = 2;</code>
     */
    public java.util.List<? extends com.grpc.orderService.productOrBuilder> 
         getProductsOrBuilderList() {
      if (productsBuilder_ != null) {
        return productsBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(products_);
      }
    }
    /**
     * <code>repeated .product products = 2;</code>
     */
    public com.grpc.orderService.product.Builder addProductsBuilder() {
      return getProductsFieldBuilder().addBuilder(
          com.grpc.orderService.product.getDefaultInstance());
    }
    /**
     * <code>repeated .product products = 2;</code>
     */
    public com.grpc.orderService.product.Builder addProductsBuilder(
        int index) {
      return getProductsFieldBuilder().addBuilder(
          index, com.grpc.orderService.product.getDefaultInstance());
    }
    /**
     * <code>repeated .product products = 2;</code>
     */
    public java.util.List<com.grpc.orderService.product.Builder> 
         getProductsBuilderList() {
      return getProductsFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilderV3<
        com.grpc.orderService.product, com.grpc.orderService.product.Builder, com.grpc.orderService.productOrBuilder> 
        getProductsFieldBuilder() {
      if (productsBuilder_ == null) {
        productsBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
            com.grpc.orderService.product, com.grpc.orderService.product.Builder, com.grpc.orderService.productOrBuilder>(
                products_,
                ((bitField0_ & 0x00000002) == 0x00000002),
                getParentForChildren(),
                isClean());
        products_ = null;
      }
      return productsBuilder_;
    }

    private int price_ ;
    /**
     * <code>int32 price = 3;</code>
     */
    public int getPrice() {
      return price_;
    }
    /**
     * <code>int32 price = 3;</code>
     */
    public Builder setPrice(int value) {
      
      price_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 price = 3;</code>
     */
    public Builder clearPrice() {
      
      price_ = 0;
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFieldsProto3(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:StockQuoteResponse)
  }

  // @@protoc_insertion_point(class_scope:StockQuoteResponse)
  private static final com.grpc.orderService.StockQuoteResponse DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.grpc.orderService.StockQuoteResponse();
  }

  public static com.grpc.orderService.StockQuoteResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<StockQuoteResponse>
      PARSER = new com.google.protobuf.AbstractParser<StockQuoteResponse>() {
    @java.lang.Override
    public StockQuoteResponse parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new StockQuoteResponse(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<StockQuoteResponse> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<StockQuoteResponse> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.grpc.orderService.StockQuoteResponse getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

