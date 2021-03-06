// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: automate_orders.proto

package com.grpc.orderService;

/**
 * <pre>
 *product
 * </pre>
 *
 * Protobuf type {@code product}
 */
public  final class product extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:product)
    productOrBuilder {
private static final long serialVersionUID = 0L;
  // Use product.newBuilder() to construct.
  private product(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private product() {
    stockId_ = 0;
    cost_ = 0F;
    productName_ = "";
    quantityAvailable_ = 0;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private product(
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
          case 8: {

            stockId_ = input.readInt32();
            break;
          }
          case 21: {

            cost_ = input.readFloat();
            break;
          }
          case 26: {
            java.lang.String s = input.readStringRequireUtf8();

            productName_ = s;
            break;
          }
          case 32: {

            quantityAvailable_ = input.readInt32();
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
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.grpc.orderService.AutomateOrdersImpl.internal_static_product_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.grpc.orderService.AutomateOrdersImpl.internal_static_product_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.grpc.orderService.product.class, com.grpc.orderService.product.Builder.class);
  }

  public static final int STOCK_ID_FIELD_NUMBER = 1;
  private int stockId_;
  /**
   * <code>int32 stock_id = 1;</code>
   */
  public int getStockId() {
    return stockId_;
  }

  public static final int COST_FIELD_NUMBER = 2;
  private float cost_;
  /**
   * <code>float cost = 2;</code>
   */
  public float getCost() {
    return cost_;
  }

  public static final int PRODUCT_NAME_FIELD_NUMBER = 3;
  private volatile java.lang.Object productName_;
  /**
   * <code>string product_name = 3;</code>
   */
  public java.lang.String getProductName() {
    java.lang.Object ref = productName_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      productName_ = s;
      return s;
    }
  }
  /**
   * <code>string product_name = 3;</code>
   */
  public com.google.protobuf.ByteString
      getProductNameBytes() {
    java.lang.Object ref = productName_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      productName_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int QUANTITY_AVAILABLE_FIELD_NUMBER = 4;
  private int quantityAvailable_;
  /**
   * <code>int32 quantity_available = 4;</code>
   */
  public int getQuantityAvailable() {
    return quantityAvailable_;
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
    if (stockId_ != 0) {
      output.writeInt32(1, stockId_);
    }
    if (cost_ != 0F) {
      output.writeFloat(2, cost_);
    }
    if (!getProductNameBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 3, productName_);
    }
    if (quantityAvailable_ != 0) {
      output.writeInt32(4, quantityAvailable_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (stockId_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(1, stockId_);
    }
    if (cost_ != 0F) {
      size += com.google.protobuf.CodedOutputStream
        .computeFloatSize(2, cost_);
    }
    if (!getProductNameBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, productName_);
    }
    if (quantityAvailable_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(4, quantityAvailable_);
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
    if (!(obj instanceof com.grpc.orderService.product)) {
      return super.equals(obj);
    }
    com.grpc.orderService.product other = (com.grpc.orderService.product) obj;

    boolean result = true;
    result = result && (getStockId()
        == other.getStockId());
    result = result && (
        java.lang.Float.floatToIntBits(getCost())
        == java.lang.Float.floatToIntBits(
            other.getCost()));
    result = result && getProductName()
        .equals(other.getProductName());
    result = result && (getQuantityAvailable()
        == other.getQuantityAvailable());
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
    hash = (37 * hash) + STOCK_ID_FIELD_NUMBER;
    hash = (53 * hash) + getStockId();
    hash = (37 * hash) + COST_FIELD_NUMBER;
    hash = (53 * hash) + java.lang.Float.floatToIntBits(
        getCost());
    hash = (37 * hash) + PRODUCT_NAME_FIELD_NUMBER;
    hash = (53 * hash) + getProductName().hashCode();
    hash = (37 * hash) + QUANTITY_AVAILABLE_FIELD_NUMBER;
    hash = (53 * hash) + getQuantityAvailable();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.grpc.orderService.product parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.grpc.orderService.product parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.grpc.orderService.product parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.grpc.orderService.product parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.grpc.orderService.product parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.grpc.orderService.product parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.grpc.orderService.product parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.grpc.orderService.product parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.grpc.orderService.product parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.grpc.orderService.product parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.grpc.orderService.product parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.grpc.orderService.product parseFrom(
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
  public static Builder newBuilder(com.grpc.orderService.product prototype) {
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
   *product
   * </pre>
   *
   * Protobuf type {@code product}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:product)
      com.grpc.orderService.productOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.grpc.orderService.AutomateOrdersImpl.internal_static_product_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.grpc.orderService.AutomateOrdersImpl.internal_static_product_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.grpc.orderService.product.class, com.grpc.orderService.product.Builder.class);
    }

    // Construct using com.grpc.orderService.product.newBuilder()
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
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      stockId_ = 0;

      cost_ = 0F;

      productName_ = "";

      quantityAvailable_ = 0;

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.grpc.orderService.AutomateOrdersImpl.internal_static_product_descriptor;
    }

    @java.lang.Override
    public com.grpc.orderService.product getDefaultInstanceForType() {
      return com.grpc.orderService.product.getDefaultInstance();
    }

    @java.lang.Override
    public com.grpc.orderService.product build() {
      com.grpc.orderService.product result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.grpc.orderService.product buildPartial() {
      com.grpc.orderService.product result = new com.grpc.orderService.product(this);
      result.stockId_ = stockId_;
      result.cost_ = cost_;
      result.productName_ = productName_;
      result.quantityAvailable_ = quantityAvailable_;
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
      if (other instanceof com.grpc.orderService.product) {
        return mergeFrom((com.grpc.orderService.product)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.grpc.orderService.product other) {
      if (other == com.grpc.orderService.product.getDefaultInstance()) return this;
      if (other.getStockId() != 0) {
        setStockId(other.getStockId());
      }
      if (other.getCost() != 0F) {
        setCost(other.getCost());
      }
      if (!other.getProductName().isEmpty()) {
        productName_ = other.productName_;
        onChanged();
      }
      if (other.getQuantityAvailable() != 0) {
        setQuantityAvailable(other.getQuantityAvailable());
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
      com.grpc.orderService.product parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.grpc.orderService.product) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private int stockId_ ;
    /**
     * <code>int32 stock_id = 1;</code>
     */
    public int getStockId() {
      return stockId_;
    }
    /**
     * <code>int32 stock_id = 1;</code>
     */
    public Builder setStockId(int value) {
      
      stockId_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 stock_id = 1;</code>
     */
    public Builder clearStockId() {
      
      stockId_ = 0;
      onChanged();
      return this;
    }

    private float cost_ ;
    /**
     * <code>float cost = 2;</code>
     */
    public float getCost() {
      return cost_;
    }
    /**
     * <code>float cost = 2;</code>
     */
    public Builder setCost(float value) {
      
      cost_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>float cost = 2;</code>
     */
    public Builder clearCost() {
      
      cost_ = 0F;
      onChanged();
      return this;
    }

    private java.lang.Object productName_ = "";
    /**
     * <code>string product_name = 3;</code>
     */
    public java.lang.String getProductName() {
      java.lang.Object ref = productName_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        productName_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string product_name = 3;</code>
     */
    public com.google.protobuf.ByteString
        getProductNameBytes() {
      java.lang.Object ref = productName_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        productName_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string product_name = 3;</code>
     */
    public Builder setProductName(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      productName_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string product_name = 3;</code>
     */
    public Builder clearProductName() {
      
      productName_ = getDefaultInstance().getProductName();
      onChanged();
      return this;
    }
    /**
     * <code>string product_name = 3;</code>
     */
    public Builder setProductNameBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      productName_ = value;
      onChanged();
      return this;
    }

    private int quantityAvailable_ ;
    /**
     * <code>int32 quantity_available = 4;</code>
     */
    public int getQuantityAvailable() {
      return quantityAvailable_;
    }
    /**
     * <code>int32 quantity_available = 4;</code>
     */
    public Builder setQuantityAvailable(int value) {
      
      quantityAvailable_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 quantity_available = 4;</code>
     */
    public Builder clearQuantityAvailable() {
      
      quantityAvailable_ = 0;
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


    // @@protoc_insertion_point(builder_scope:product)
  }

  // @@protoc_insertion_point(class_scope:product)
  private static final com.grpc.orderService.product DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.grpc.orderService.product();
  }

  public static com.grpc.orderService.product getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<product>
      PARSER = new com.google.protobuf.AbstractParser<product>() {
    @java.lang.Override
    public product parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new product(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<product> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<product> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.grpc.orderService.product getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

