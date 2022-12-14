/**
 * Autogenerated by Thrift Compiler (0.16.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package org.apache.hadoop.hive.serde2.thrift.test;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.16.0)")
public class IntString implements org.apache.thrift.TBase<IntString, IntString._Fields>, java.io.Serializable, Cloneable, Comparable<IntString> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("IntString");

  private static final org.apache.thrift.protocol.TField MYINT_FIELD_DESC = new org.apache.thrift.protocol.TField("myint", org.apache.thrift.protocol.TType.I32, (short)1);
  private static final org.apache.thrift.protocol.TField MY_STRING_FIELD_DESC = new org.apache.thrift.protocol.TField("myString", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField UNDERSCORE_INT_FIELD_DESC = new org.apache.thrift.protocol.TField("underscore_int", org.apache.thrift.protocol.TType.I32, (short)3);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new IntStringStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new IntStringTupleSchemeFactory();

  private int myint; // required
  private @org.apache.thrift.annotation.Nullable java.lang.String myString; // required
  private int underscore_int; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    MYINT((short)1, "myint"),
    MY_STRING((short)2, "myString"),
    UNDERSCORE_INT((short)3, "underscore_int");

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
        case 1: // MYINT
          return MYINT;
        case 2: // MY_STRING
          return MY_STRING;
        case 3: // UNDERSCORE_INT
          return UNDERSCORE_INT;
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
  private static final int __MYINT_ISSET_ID = 0;
  private static final int __UNDERSCORE_INT_ISSET_ID = 1;
  private byte __isset_bitfield = 0;
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.MYINT, new org.apache.thrift.meta_data.FieldMetaData("myint", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.MY_STRING, new org.apache.thrift.meta_data.FieldMetaData("myString", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.UNDERSCORE_INT, new org.apache.thrift.meta_data.FieldMetaData("underscore_int", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(IntString.class, metaDataMap);
  }

  public IntString() {
  }

  public IntString(
    int myint,
    java.lang.String myString,
    int underscore_int)
  {
    this();
    this.myint = myint;
    setMyintIsSet(true);
    this.myString = myString;
    this.underscore_int = underscore_int;
    setUnderscore_intIsSet(true);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public IntString(IntString other) {
    __isset_bitfield = other.__isset_bitfield;
    this.myint = other.myint;
    if (other.isSetMyString()) {
      this.myString = other.myString;
    }
    this.underscore_int = other.underscore_int;
  }

  public IntString deepCopy() {
    return new IntString(this);
  }

  @Override
  public void clear() {
    setMyintIsSet(false);
    this.myint = 0;
    this.myString = null;
    setUnderscore_intIsSet(false);
    this.underscore_int = 0;
  }

  public int getMyint() {
    return this.myint;
  }

  public void setMyint(int myint) {
    this.myint = myint;
    setMyintIsSet(true);
  }

  public void unsetMyint() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __MYINT_ISSET_ID);
  }

  /** Returns true if field myint is set (has been assigned a value) and false otherwise */
  public boolean isSetMyint() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __MYINT_ISSET_ID);
  }

  public void setMyintIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __MYINT_ISSET_ID, value);
  }

  @org.apache.thrift.annotation.Nullable
  public java.lang.String getMyString() {
    return this.myString;
  }

  public void setMyString(@org.apache.thrift.annotation.Nullable java.lang.String myString) {
    this.myString = myString;
  }

  public void unsetMyString() {
    this.myString = null;
  }

  /** Returns true if field myString is set (has been assigned a value) and false otherwise */
  public boolean isSetMyString() {
    return this.myString != null;
  }

  public void setMyStringIsSet(boolean value) {
    if (!value) {
      this.myString = null;
    }
  }

  public int getUnderscore_int() {
    return this.underscore_int;
  }

  public void setUnderscore_int(int underscore_int) {
    this.underscore_int = underscore_int;
    setUnderscore_intIsSet(true);
  }

  public void unsetUnderscore_int() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __UNDERSCORE_INT_ISSET_ID);
  }

  /** Returns true if field underscore_int is set (has been assigned a value) and false otherwise */
  public boolean isSetUnderscore_int() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __UNDERSCORE_INT_ISSET_ID);
  }

  public void setUnderscore_intIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __UNDERSCORE_INT_ISSET_ID, value);
  }

  public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {
    switch (field) {
    case MYINT:
      if (value == null) {
        unsetMyint();
      } else {
        setMyint((java.lang.Integer)value);
      }
      break;

    case MY_STRING:
      if (value == null) {
        unsetMyString();
      } else {
        setMyString((java.lang.String)value);
      }
      break;

    case UNDERSCORE_INT:
      if (value == null) {
        unsetUnderscore_int();
      } else {
        setUnderscore_int((java.lang.Integer)value);
      }
      break;

    }
  }

  @org.apache.thrift.annotation.Nullable
  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case MYINT:
      return getMyint();

    case MY_STRING:
      return getMyString();

    case UNDERSCORE_INT:
      return getUnderscore_int();

    }
    throw new java.lang.IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new java.lang.IllegalArgumentException();
    }

    switch (field) {
    case MYINT:
      return isSetMyint();
    case MY_STRING:
      return isSetMyString();
    case UNDERSCORE_INT:
      return isSetUnderscore_int();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that instanceof IntString)
      return this.equals((IntString)that);
    return false;
  }

  public boolean equals(IntString that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_myint = true;
    boolean that_present_myint = true;
    if (this_present_myint || that_present_myint) {
      if (!(this_present_myint && that_present_myint))
        return false;
      if (this.myint != that.myint)
        return false;
    }

    boolean this_present_myString = true && this.isSetMyString();
    boolean that_present_myString = true && that.isSetMyString();
    if (this_present_myString || that_present_myString) {
      if (!(this_present_myString && that_present_myString))
        return false;
      if (!this.myString.equals(that.myString))
        return false;
    }

    boolean this_present_underscore_int = true;
    boolean that_present_underscore_int = true;
    if (this_present_underscore_int || that_present_underscore_int) {
      if (!(this_present_underscore_int && that_present_underscore_int))
        return false;
      if (this.underscore_int != that.underscore_int)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + myint;

    hashCode = hashCode * 8191 + ((isSetMyString()) ? 131071 : 524287);
    if (isSetMyString())
      hashCode = hashCode * 8191 + myString.hashCode();

    hashCode = hashCode * 8191 + underscore_int;

    return hashCode;
  }

  @Override
  public int compareTo(IntString other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.compare(isSetMyint(), other.isSetMyint());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetMyint()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.myint, other.myint);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetMyString(), other.isSetMyString());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetMyString()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.myString, other.myString);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetUnderscore_int(), other.isSetUnderscore_int());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetUnderscore_int()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.underscore_int, other.underscore_int);
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
    java.lang.StringBuilder sb = new java.lang.StringBuilder("IntString(");
    boolean first = true;

    sb.append("myint:");
    sb.append(this.myint);
    first = false;
    if (!first) sb.append(", ");
    sb.append("myString:");
    if (this.myString == null) {
      sb.append("null");
    } else {
      sb.append(this.myString);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("underscore_int:");
    sb.append(this.underscore_int);
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

  private static class IntStringStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public IntStringStandardScheme getScheme() {
      return new IntStringStandardScheme();
    }
  }

  private static class IntStringStandardScheme extends org.apache.thrift.scheme.StandardScheme<IntString> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, IntString struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // MYINT
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.myint = iprot.readI32();
              struct.setMyintIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // MY_STRING
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.myString = iprot.readString();
              struct.setMyStringIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // UNDERSCORE_INT
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.underscore_int = iprot.readI32();
              struct.setUnderscore_intIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, IntString struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      oprot.writeFieldBegin(MYINT_FIELD_DESC);
      oprot.writeI32(struct.myint);
      oprot.writeFieldEnd();
      if (struct.myString != null) {
        oprot.writeFieldBegin(MY_STRING_FIELD_DESC);
        oprot.writeString(struct.myString);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldBegin(UNDERSCORE_INT_FIELD_DESC);
      oprot.writeI32(struct.underscore_int);
      oprot.writeFieldEnd();
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class IntStringTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public IntStringTupleScheme getScheme() {
      return new IntStringTupleScheme();
    }
  }

  private static class IntStringTupleScheme extends org.apache.thrift.scheme.TupleScheme<IntString> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, IntString struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetMyint()) {
        optionals.set(0);
      }
      if (struct.isSetMyString()) {
        optionals.set(1);
      }
      if (struct.isSetUnderscore_int()) {
        optionals.set(2);
      }
      oprot.writeBitSet(optionals, 3);
      if (struct.isSetMyint()) {
        oprot.writeI32(struct.myint);
      }
      if (struct.isSetMyString()) {
        oprot.writeString(struct.myString);
      }
      if (struct.isSetUnderscore_int()) {
        oprot.writeI32(struct.underscore_int);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, IntString struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet incoming = iprot.readBitSet(3);
      if (incoming.get(0)) {
        struct.myint = iprot.readI32();
        struct.setMyintIsSet(true);
      }
      if (incoming.get(1)) {
        struct.myString = iprot.readString();
        struct.setMyStringIsSet(true);
      }
      if (incoming.get(2)) {
        struct.underscore_int = iprot.readI32();
        struct.setUnderscore_intIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

