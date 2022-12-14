/**
 * Autogenerated by Thrift Compiler (0.16.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package org.apache.hadoop.hive.serde.test;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.16.0)")
public class InnerStruct implements org.apache.thrift.TBase<InnerStruct, InnerStruct._Fields>, java.io.Serializable, Cloneable, Comparable<InnerStruct> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("InnerStruct");

  private static final org.apache.thrift.protocol.TField FIELD0_FIELD_DESC = new org.apache.thrift.protocol.TField("field0", org.apache.thrift.protocol.TType.I32, (short)1);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new InnerStructStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new InnerStructTupleSchemeFactory();

  private int field0; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    FIELD0((short)1, "field0");

    private static final java.util.Map<java.lang.String, _Fields> byName = new java.util.HashMap<java.lang.String, _Fields>();

    static {
      for (_Fields field : java.util.EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    @org.apache.thrift.annotation.Nullable
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // FIELD0
          return FIELD0;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new java.lang.IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    @org.apache.thrift.annotation.Nullable
    public static _Fields findByName(java.lang.String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final java.lang.String _fieldName;

    _Fields(short thriftId, java.lang.String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public java.lang.String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final int __FIELD0_ISSET_ID = 0;
  private byte __isset_bitfield = 0;
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.FIELD0, new org.apache.thrift.meta_data.FieldMetaData("field0", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(InnerStruct.class, metaDataMap);
  }

  public InnerStruct() {
  }

  public InnerStruct(
    int field0)
  {
    this();
    this.field0 = field0;
    setField0IsSet(true);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public InnerStruct(InnerStruct other) {
    __isset_bitfield = other.__isset_bitfield;
    this.field0 = other.field0;
  }

  public InnerStruct deepCopy() {
    return new InnerStruct(this);
  }

  @Override
  public void clear() {
    setField0IsSet(false);
    this.field0 = 0;
  }

  public int getField0() {
    return this.field0;
  }

  public void setField0(int field0) {
    this.field0 = field0;
    setField0IsSet(true);
  }

  public void unsetField0() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __FIELD0_ISSET_ID);
  }

  /** Returns true if field field0 is set (has been assigned a value) and false otherwise */
  public boolean isSetField0() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __FIELD0_ISSET_ID);
  }

  public void setField0IsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __FIELD0_ISSET_ID, value);
  }

  public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {
    switch (field) {
    case FIELD0:
      if (value == null) {
        unsetField0();
      } else {
        setField0((java.lang.Integer)value);
      }
      break;

    }
  }

  @org.apache.thrift.annotation.Nullable
  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case FIELD0:
      return getField0();

    }
    throw new java.lang.IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new java.lang.IllegalArgumentException();
    }

    switch (field) {
    case FIELD0:
      return isSetField0();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that instanceof InnerStruct)
      return this.equals((InnerStruct)that);
    return false;
  }

  public boolean equals(InnerStruct that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_field0 = true;
    boolean that_present_field0 = true;
    if (this_present_field0 || that_present_field0) {
      if (!(this_present_field0 && that_present_field0))
        return false;
      if (this.field0 != that.field0)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + field0;

    return hashCode;
  }

  @Override
  public int compareTo(InnerStruct other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.compare(isSetField0(), other.isSetField0());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetField0()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.field0, other.field0);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  @org.apache.thrift.annotation.Nullable
  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    scheme(iprot).read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    scheme(oprot).write(oprot, this);
  }

  @Override
  public java.lang.String toString() {
    java.lang.StringBuilder sb = new java.lang.StringBuilder("InnerStruct(");
    boolean first = true;

    sb.append("field0:");
    sb.append(this.field0);
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, java.lang.ClassNotFoundException {
    try {
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class InnerStructStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public InnerStructStandardScheme getScheme() {
      return new InnerStructStandardScheme();
    }
  }

  private static class InnerStructStandardScheme extends org.apache.thrift.scheme.StandardScheme<InnerStruct> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, InnerStruct struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // FIELD0
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.field0 = iprot.readI32();
              struct.setField0IsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, InnerStruct struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      oprot.writeFieldBegin(FIELD0_FIELD_DESC);
      oprot.writeI32(struct.field0);
      oprot.writeFieldEnd();
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class InnerStructTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public InnerStructTupleScheme getScheme() {
      return new InnerStructTupleScheme();
    }
  }

  private static class InnerStructTupleScheme extends org.apache.thrift.scheme.TupleScheme<InnerStruct> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, InnerStruct struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetField0()) {
        optionals.set(0);
      }
      oprot.writeBitSet(optionals, 1);
      if (struct.isSetField0()) {
        oprot.writeI32(struct.field0);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, InnerStruct struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet incoming = iprot.readBitSet(1);
      if (incoming.get(0)) {
        struct.field0 = iprot.readI32();
        struct.setField0IsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

