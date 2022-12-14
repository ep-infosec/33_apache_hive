/**
 * Autogenerated by Thrift Compiler (0.16.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package org.apache.hadoop.hive.serde2.thrift.test;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.16.0)")
public class SetIntString implements org.apache.thrift.TBase<SetIntString, SetIntString._Fields>, java.io.Serializable, Cloneable, Comparable<SetIntString> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("SetIntString");

  private static final org.apache.thrift.protocol.TField S_INT_STRING_FIELD_DESC = new org.apache.thrift.protocol.TField("sIntString", org.apache.thrift.protocol.TType.SET, (short)1);
  private static final org.apache.thrift.protocol.TField A_STRING_FIELD_DESC = new org.apache.thrift.protocol.TField("aString", org.apache.thrift.protocol.TType.STRING, (short)2);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new SetIntStringStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new SetIntStringTupleSchemeFactory();

  private @org.apache.thrift.annotation.Nullable java.util.Set<IntString> sIntString; // required
  private @org.apache.thrift.annotation.Nullable java.lang.String aString; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    S_INT_STRING((short)1, "sIntString"),
    A_STRING((short)2, "aString");

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
        case 1: // S_INT_STRING
          return S_INT_STRING;
        case 2: // A_STRING
          return A_STRING;
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
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.S_INT_STRING, new org.apache.thrift.meta_data.FieldMetaData("sIntString", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.SetMetaData(org.apache.thrift.protocol.TType.SET, 
            new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, IntString.class))));
    tmpMap.put(_Fields.A_STRING, new org.apache.thrift.meta_data.FieldMetaData("aString", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(SetIntString.class, metaDataMap);
  }

  public SetIntString() {
  }

  public SetIntString(
    java.util.Set<IntString> sIntString,
    java.lang.String aString)
  {
    this();
    this.sIntString = sIntString;
    this.aString = aString;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public SetIntString(SetIntString other) {
    if (other.isSetSIntString()) {
      java.util.Set<IntString> __this__sIntString = new java.util.HashSet<IntString>(other.sIntString.size());
      for (IntString other_element : other.sIntString) {
        __this__sIntString.add(new IntString(other_element));
      }
      this.sIntString = __this__sIntString;
    }
    if (other.isSetAString()) {
      this.aString = other.aString;
    }
  }

  public SetIntString deepCopy() {
    return new SetIntString(this);
  }

  @Override
  public void clear() {
    this.sIntString = null;
    this.aString = null;
  }

  public int getSIntStringSize() {
    return (this.sIntString == null) ? 0 : this.sIntString.size();
  }

  @org.apache.thrift.annotation.Nullable
  public java.util.Iterator<IntString> getSIntStringIterator() {
    return (this.sIntString == null) ? null : this.sIntString.iterator();
  }

  public void addToSIntString(IntString elem) {
    if (this.sIntString == null) {
      this.sIntString = new java.util.HashSet<IntString>();
    }
    this.sIntString.add(elem);
  }

  @org.apache.thrift.annotation.Nullable
  public java.util.Set<IntString> getSIntString() {
    return this.sIntString;
  }

  public void setSIntString(@org.apache.thrift.annotation.Nullable java.util.Set<IntString> sIntString) {
    this.sIntString = sIntString;
  }

  public void unsetSIntString() {
    this.sIntString = null;
  }

  /** Returns true if field sIntString is set (has been assigned a value) and false otherwise */
  public boolean isSetSIntString() {
    return this.sIntString != null;
  }

  public void setSIntStringIsSet(boolean value) {
    if (!value) {
      this.sIntString = null;
    }
  }

  @org.apache.thrift.annotation.Nullable
  public java.lang.String getAString() {
    return this.aString;
  }

  public void setAString(@org.apache.thrift.annotation.Nullable java.lang.String aString) {
    this.aString = aString;
  }

  public void unsetAString() {
    this.aString = null;
  }

  /** Returns true if field aString is set (has been assigned a value) and false otherwise */
  public boolean isSetAString() {
    return this.aString != null;
  }

  public void setAStringIsSet(boolean value) {
    if (!value) {
      this.aString = null;
    }
  }

  public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {
    switch (field) {
    case S_INT_STRING:
      if (value == null) {
        unsetSIntString();
      } else {
        setSIntString((java.util.Set<IntString>)value);
      }
      break;

    case A_STRING:
      if (value == null) {
        unsetAString();
      } else {
        setAString((java.lang.String)value);
      }
      break;

    }
  }

  @org.apache.thrift.annotation.Nullable
  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case S_INT_STRING:
      return getSIntString();

    case A_STRING:
      return getAString();

    }
    throw new java.lang.IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new java.lang.IllegalArgumentException();
    }

    switch (field) {
    case S_INT_STRING:
      return isSetSIntString();
    case A_STRING:
      return isSetAString();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that instanceof SetIntString)
      return this.equals((SetIntString)that);
    return false;
  }

  public boolean equals(SetIntString that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_sIntString = true && this.isSetSIntString();
    boolean that_present_sIntString = true && that.isSetSIntString();
    if (this_present_sIntString || that_present_sIntString) {
      if (!(this_present_sIntString && that_present_sIntString))
        return false;
      if (!this.sIntString.equals(that.sIntString))
        return false;
    }

    boolean this_present_aString = true && this.isSetAString();
    boolean that_present_aString = true && that.isSetAString();
    if (this_present_aString || that_present_aString) {
      if (!(this_present_aString && that_present_aString))
        return false;
      if (!this.aString.equals(that.aString))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + ((isSetSIntString()) ? 131071 : 524287);
    if (isSetSIntString())
      hashCode = hashCode * 8191 + sIntString.hashCode();

    hashCode = hashCode * 8191 + ((isSetAString()) ? 131071 : 524287);
    if (isSetAString())
      hashCode = hashCode * 8191 + aString.hashCode();

    return hashCode;
  }

  @Override
  public int compareTo(SetIntString other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.compare(isSetSIntString(), other.isSetSIntString());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetSIntString()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.sIntString, other.sIntString);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetAString(), other.isSetAString());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetAString()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.aString, other.aString);
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
    java.lang.StringBuilder sb = new java.lang.StringBuilder("SetIntString(");
    boolean first = true;

    sb.append("sIntString:");
    if (this.sIntString == null) {
      sb.append("null");
    } else {
      sb.append(this.sIntString);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("aString:");
    if (this.aString == null) {
      sb.append("null");
    } else {
      sb.append(this.aString);
    }
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
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class SetIntStringStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public SetIntStringStandardScheme getScheme() {
      return new SetIntStringStandardScheme();
    }
  }

  private static class SetIntStringStandardScheme extends org.apache.thrift.scheme.StandardScheme<SetIntString> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, SetIntString struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // S_INT_STRING
            if (schemeField.type == org.apache.thrift.protocol.TType.SET) {
              {
                org.apache.thrift.protocol.TSet _set82 = iprot.readSetBegin();
                struct.sIntString = new java.util.HashSet<IntString>(2*_set82.size);
                @org.apache.thrift.annotation.Nullable IntString _elem83;
                for (int _i84 = 0; _i84 < _set82.size; ++_i84)
                {
                  _elem83 = new IntString();
                  _elem83.read(iprot);
                  struct.sIntString.add(_elem83);
                }
                iprot.readSetEnd();
              }
              struct.setSIntStringIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // A_STRING
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.aString = iprot.readString();
              struct.setAStringIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, SetIntString struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.sIntString != null) {
        oprot.writeFieldBegin(S_INT_STRING_FIELD_DESC);
        {
          oprot.writeSetBegin(new org.apache.thrift.protocol.TSet(org.apache.thrift.protocol.TType.STRUCT, struct.sIntString.size()));
          for (IntString _iter85 : struct.sIntString)
          {
            _iter85.write(oprot);
          }
          oprot.writeSetEnd();
        }
        oprot.writeFieldEnd();
      }
      if (struct.aString != null) {
        oprot.writeFieldBegin(A_STRING_FIELD_DESC);
        oprot.writeString(struct.aString);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class SetIntStringTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public SetIntStringTupleScheme getScheme() {
      return new SetIntStringTupleScheme();
    }
  }

  private static class SetIntStringTupleScheme extends org.apache.thrift.scheme.TupleScheme<SetIntString> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, SetIntString struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetSIntString()) {
        optionals.set(0);
      }
      if (struct.isSetAString()) {
        optionals.set(1);
      }
      oprot.writeBitSet(optionals, 2);
      if (struct.isSetSIntString()) {
        {
          oprot.writeI32(struct.sIntString.size());
          for (IntString _iter86 : struct.sIntString)
          {
            _iter86.write(oprot);
          }
        }
      }
      if (struct.isSetAString()) {
        oprot.writeString(struct.aString);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, SetIntString struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet incoming = iprot.readBitSet(2);
      if (incoming.get(0)) {
        {
          org.apache.thrift.protocol.TSet _set87 = iprot.readSetBegin(org.apache.thrift.protocol.TType.STRUCT);
          struct.sIntString = new java.util.HashSet<IntString>(2*_set87.size);
          @org.apache.thrift.annotation.Nullable IntString _elem88;
          for (int _i89 = 0; _i89 < _set87.size; ++_i89)
          {
            _elem88 = new IntString();
            _elem88.read(iprot);
            struct.sIntString.add(_elem88);
          }
        }
        struct.setSIntStringIsSet(true);
      }
      if (incoming.get(1)) {
        struct.aString = iprot.readString();
        struct.setAStringIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

