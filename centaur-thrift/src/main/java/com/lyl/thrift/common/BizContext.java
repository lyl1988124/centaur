/**
 * Autogenerated by Thrift Compiler (0.9.3)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.lyl.thrift.common;

import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;

import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.protocol.TProtocolException;
import org.apache.thrift.EncodingUtils;
import org.apache.thrift.TException;
import org.apache.thrift.async.AsyncMethodCallback;
import org.apache.thrift.server.AbstractNonblockingServer.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.nio.ByteBuffer;
import java.util.Arrays;
import javax.annotation.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked"})
@Generated(value = "Autogenerated by Thrift Compiler (0.9.3)", date = "2018-12-25")
public class BizContext implements org.apache.thrift.TBase<BizContext, BizContext._Fields>, java.io.Serializable, Cloneable, Comparable<BizContext> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("BizContext");

  private static final org.apache.thrift.protocol.TField NAME_FIELD_DESC = new org.apache.thrift.protocol.TField("name", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField UID_FIELD_DESC = new org.apache.thrift.protocol.TField("uid", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField PRODUCT_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("productId", org.apache.thrift.protocol.TType.STRING, (short)3);
  private static final org.apache.thrift.protocol.TField REQ_TIME_FIELD_DESC = new org.apache.thrift.protocol.TField("reqTime", org.apache.thrift.protocol.TType.STRING, (short)4);
  private static final org.apache.thrift.protocol.TField BIZ_EXT_FIELD_DESC = new org.apache.thrift.protocol.TField("bizExt", org.apache.thrift.protocol.TType.MAP, (short)5);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new BizContextStandardSchemeFactory());
    schemes.put(TupleScheme.class, new BizContextTupleSchemeFactory());
  }

  public String name; // required
  public String uid; // required
  public String productId; // optional
  public String reqTime; // optional
  public Map<String,String> bizExt; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    NAME((short)1, "name"),
    UID((short)2, "uid"),
    PRODUCT_ID((short)3, "productId"),
    REQ_TIME((short)4, "reqTime"),
    BIZ_EXT((short)5, "bizExt");

    private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

    static {
      for (_Fields field : EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // NAME
          return NAME;
        case 2: // UID
          return UID;
        case 3: // PRODUCT_ID
          return PRODUCT_ID;
        case 4: // REQ_TIME
          return REQ_TIME;
        case 5: // BIZ_EXT
          return BIZ_EXT;
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
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final _Fields optionals[] = {_Fields.PRODUCT_ID,_Fields.REQ_TIME,_Fields.BIZ_EXT};
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.NAME, new org.apache.thrift.meta_data.FieldMetaData("name", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.UID, new org.apache.thrift.meta_data.FieldMetaData("uid", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.PRODUCT_ID, new org.apache.thrift.meta_data.FieldMetaData("productId", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.REQ_TIME, new org.apache.thrift.meta_data.FieldMetaData("reqTime", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.BIZ_EXT, new org.apache.thrift.meta_data.FieldMetaData("bizExt", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.MapMetaData(org.apache.thrift.protocol.TType.MAP, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING), 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING))));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(BizContext.class, metaDataMap);
  }

  public BizContext() {
  }

  public BizContext(
    String name,
    String uid)
  {
    this();
    this.name = name;
    this.uid = uid;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public BizContext(BizContext other) {
    if (other.isSetName()) {
      this.name = other.name;
    }
    if (other.isSetUid()) {
      this.uid = other.uid;
    }
    if (other.isSetProductId()) {
      this.productId = other.productId;
    }
    if (other.isSetReqTime()) {
      this.reqTime = other.reqTime;
    }
    if (other.isSetBizExt()) {
      Map<String,String> __this__bizExt = new HashMap<String,String>(other.bizExt);
      this.bizExt = __this__bizExt;
    }
  }

  public BizContext deepCopy() {
    return new BizContext(this);
  }

  @Override
  public void clear() {
    this.name = null;
    this.uid = null;
    this.productId = null;
    this.reqTime = null;
    this.bizExt = null;
  }

  public String getName() {
    return this.name;
  }

  public BizContext setName(String name) {
    this.name = name;
    return this;
  }

  public void unsetName() {
    this.name = null;
  }

  /** Returns true if field name is set (has been assigned a value) and false otherwise */
  public boolean isSetName() {
    return this.name != null;
  }

  public void setNameIsSet(boolean value) {
    if (!value) {
      this.name = null;
    }
  }

  public String getUid() {
    return this.uid;
  }

  public BizContext setUid(String uid) {
    this.uid = uid;
    return this;
  }

  public void unsetUid() {
    this.uid = null;
  }

  /** Returns true if field uid is set (has been assigned a value) and false otherwise */
  public boolean isSetUid() {
    return this.uid != null;
  }

  public void setUidIsSet(boolean value) {
    if (!value) {
      this.uid = null;
    }
  }

  public String getProductId() {
    return this.productId;
  }

  public BizContext setProductId(String productId) {
    this.productId = productId;
    return this;
  }

  public void unsetProductId() {
    this.productId = null;
  }

  /** Returns true if field productId is set (has been assigned a value) and false otherwise */
  public boolean isSetProductId() {
    return this.productId != null;
  }

  public void setProductIdIsSet(boolean value) {
    if (!value) {
      this.productId = null;
    }
  }

  public String getReqTime() {
    return this.reqTime;
  }

  public BizContext setReqTime(String reqTime) {
    this.reqTime = reqTime;
    return this;
  }

  public void unsetReqTime() {
    this.reqTime = null;
  }

  /** Returns true if field reqTime is set (has been assigned a value) and false otherwise */
  public boolean isSetReqTime() {
    return this.reqTime != null;
  }

  public void setReqTimeIsSet(boolean value) {
    if (!value) {
      this.reqTime = null;
    }
  }

  public int getBizExtSize() {
    return (this.bizExt == null) ? 0 : this.bizExt.size();
  }

  public void putToBizExt(String key, String val) {
    if (this.bizExt == null) {
      this.bizExt = new HashMap<String,String>();
    }
    this.bizExt.put(key, val);
  }

  public Map<String,String> getBizExt() {
    return this.bizExt;
  }

  public BizContext setBizExt(Map<String,String> bizExt) {
    this.bizExt = bizExt;
    return this;
  }

  public void unsetBizExt() {
    this.bizExt = null;
  }

  /** Returns true if field bizExt is set (has been assigned a value) and false otherwise */
  public boolean isSetBizExt() {
    return this.bizExt != null;
  }

  public void setBizExtIsSet(boolean value) {
    if (!value) {
      this.bizExt = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case NAME:
      if (value == null) {
        unsetName();
      } else {
        setName((String)value);
      }
      break;

    case UID:
      if (value == null) {
        unsetUid();
      } else {
        setUid((String)value);
      }
      break;

    case PRODUCT_ID:
      if (value == null) {
        unsetProductId();
      } else {
        setProductId((String)value);
      }
      break;

    case REQ_TIME:
      if (value == null) {
        unsetReqTime();
      } else {
        setReqTime((String)value);
      }
      break;

    case BIZ_EXT:
      if (value == null) {
        unsetBizExt();
      } else {
        setBizExt((Map<String,String>)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case NAME:
      return getName();

    case UID:
      return getUid();

    case PRODUCT_ID:
      return getProductId();

    case REQ_TIME:
      return getReqTime();

    case BIZ_EXT:
      return getBizExt();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case NAME:
      return isSetName();
    case UID:
      return isSetUid();
    case PRODUCT_ID:
      return isSetProductId();
    case REQ_TIME:
      return isSetReqTime();
    case BIZ_EXT:
      return isSetBizExt();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof BizContext)
      return this.equals((BizContext)that);
    return false;
  }

  public boolean equals(BizContext that) {
    if (that == null)
      return false;

    boolean this_present_name = true && this.isSetName();
    boolean that_present_name = true && that.isSetName();
    if (this_present_name || that_present_name) {
      if (!(this_present_name && that_present_name))
        return false;
      if (!this.name.equals(that.name))
        return false;
    }

    boolean this_present_uid = true && this.isSetUid();
    boolean that_present_uid = true && that.isSetUid();
    if (this_present_uid || that_present_uid) {
      if (!(this_present_uid && that_present_uid))
        return false;
      if (!this.uid.equals(that.uid))
        return false;
    }

    boolean this_present_productId = true && this.isSetProductId();
    boolean that_present_productId = true && that.isSetProductId();
    if (this_present_productId || that_present_productId) {
      if (!(this_present_productId && that_present_productId))
        return false;
      if (!this.productId.equals(that.productId))
        return false;
    }

    boolean this_present_reqTime = true && this.isSetReqTime();
    boolean that_present_reqTime = true && that.isSetReqTime();
    if (this_present_reqTime || that_present_reqTime) {
      if (!(this_present_reqTime && that_present_reqTime))
        return false;
      if (!this.reqTime.equals(that.reqTime))
        return false;
    }

    boolean this_present_bizExt = true && this.isSetBizExt();
    boolean that_present_bizExt = true && that.isSetBizExt();
    if (this_present_bizExt || that_present_bizExt) {
      if (!(this_present_bizExt && that_present_bizExt))
        return false;
      if (!this.bizExt.equals(that.bizExt))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    List<Object> list = new ArrayList<Object>();

    boolean present_name = true && (isSetName());
    list.add(present_name);
    if (present_name)
      list.add(name);

    boolean present_uid = true && (isSetUid());
    list.add(present_uid);
    if (present_uid)
      list.add(uid);

    boolean present_productId = true && (isSetProductId());
    list.add(present_productId);
    if (present_productId)
      list.add(productId);

    boolean present_reqTime = true && (isSetReqTime());
    list.add(present_reqTime);
    if (present_reqTime)
      list.add(reqTime);

    boolean present_bizExt = true && (isSetBizExt());
    list.add(present_bizExt);
    if (present_bizExt)
      list.add(bizExt);

    return list.hashCode();
  }

  @Override
  public int compareTo(BizContext other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetName()).compareTo(other.isSetName());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetName()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.name, other.name);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetUid()).compareTo(other.isSetUid());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetUid()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.uid, other.uid);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetProductId()).compareTo(other.isSetProductId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetProductId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.productId, other.productId);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetReqTime()).compareTo(other.isSetReqTime());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetReqTime()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.reqTime, other.reqTime);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetBizExt()).compareTo(other.isSetBizExt());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetBizExt()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.bizExt, other.bizExt);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("BizContext(");
    boolean first = true;

    sb.append("name:");
    if (this.name == null) {
      sb.append("null");
    } else {
      sb.append(this.name);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("uid:");
    if (this.uid == null) {
      sb.append("null");
    } else {
      sb.append(this.uid);
    }
    first = false;
    if (isSetProductId()) {
      if (!first) sb.append(", ");
      sb.append("productId:");
      if (this.productId == null) {
        sb.append("null");
      } else {
        sb.append(this.productId);
      }
      first = false;
    }
    if (isSetReqTime()) {
      if (!first) sb.append(", ");
      sb.append("reqTime:");
      if (this.reqTime == null) {
        sb.append("null");
      } else {
        sb.append(this.reqTime);
      }
      first = false;
    }
    if (isSetBizExt()) {
      if (!first) sb.append(", ");
      sb.append("bizExt:");
      if (this.bizExt == null) {
        sb.append("null");
      } else {
        sb.append(this.bizExt);
      }
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    if (name == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'name' was not present! Struct: " + toString());
    }
    if (uid == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'uid' was not present! Struct: " + toString());
    }
    // check for sub-struct validity
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class BizContextStandardSchemeFactory implements SchemeFactory {
    public BizContextStandardScheme getScheme() {
      return new BizContextStandardScheme();
    }
  }

  private static class BizContextStandardScheme extends StandardScheme<BizContext> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, BizContext struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // NAME
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.name = iprot.readString();
              struct.setNameIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // UID
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.uid = iprot.readString();
              struct.setUidIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // PRODUCT_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.productId = iprot.readString();
              struct.setProductIdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // REQ_TIME
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.reqTime = iprot.readString();
              struct.setReqTimeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 5: // BIZ_EXT
            if (schemeField.type == org.apache.thrift.protocol.TType.MAP) {
              {
                org.apache.thrift.protocol.TMap _map0 = iprot.readMapBegin();
                struct.bizExt = new HashMap<String,String>(2*_map0.size);
                String _key1;
                String _val2;
                for (int _i3 = 0; _i3 < _map0.size; ++_i3)
                {
                  _key1 = iprot.readString();
                  _val2 = iprot.readString();
                  struct.bizExt.put(_key1, _val2);
                }
                iprot.readMapEnd();
              }
              struct.setBizExtIsSet(true);
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

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, BizContext struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.name != null) {
        oprot.writeFieldBegin(NAME_FIELD_DESC);
        oprot.writeString(struct.name);
        oprot.writeFieldEnd();
      }
      if (struct.uid != null) {
        oprot.writeFieldBegin(UID_FIELD_DESC);
        oprot.writeString(struct.uid);
        oprot.writeFieldEnd();
      }
      if (struct.productId != null) {
        if (struct.isSetProductId()) {
          oprot.writeFieldBegin(PRODUCT_ID_FIELD_DESC);
          oprot.writeString(struct.productId);
          oprot.writeFieldEnd();
        }
      }
      if (struct.reqTime != null) {
        if (struct.isSetReqTime()) {
          oprot.writeFieldBegin(REQ_TIME_FIELD_DESC);
          oprot.writeString(struct.reqTime);
          oprot.writeFieldEnd();
        }
      }
      if (struct.bizExt != null) {
        if (struct.isSetBizExt()) {
          oprot.writeFieldBegin(BIZ_EXT_FIELD_DESC);
          {
            oprot.writeMapBegin(new org.apache.thrift.protocol.TMap(org.apache.thrift.protocol.TType.STRING, org.apache.thrift.protocol.TType.STRING, struct.bizExt.size()));
            for (Map.Entry<String, String> _iter4 : struct.bizExt.entrySet())
            {
              oprot.writeString(_iter4.getKey());
              oprot.writeString(_iter4.getValue());
            }
            oprot.writeMapEnd();
          }
          oprot.writeFieldEnd();
        }
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class BizContextTupleSchemeFactory implements SchemeFactory {
    public BizContextTupleScheme getScheme() {
      return new BizContextTupleScheme();
    }
  }

  private static class BizContextTupleScheme extends TupleScheme<BizContext> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, BizContext struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      oprot.writeString(struct.name);
      oprot.writeString(struct.uid);
      BitSet optionals = new BitSet();
      if (struct.isSetProductId()) {
        optionals.set(0);
      }
      if (struct.isSetReqTime()) {
        optionals.set(1);
      }
      if (struct.isSetBizExt()) {
        optionals.set(2);
      }
      oprot.writeBitSet(optionals, 3);
      if (struct.isSetProductId()) {
        oprot.writeString(struct.productId);
      }
      if (struct.isSetReqTime()) {
        oprot.writeString(struct.reqTime);
      }
      if (struct.isSetBizExt()) {
        {
          oprot.writeI32(struct.bizExt.size());
          for (Map.Entry<String, String> _iter5 : struct.bizExt.entrySet())
          {
            oprot.writeString(_iter5.getKey());
            oprot.writeString(_iter5.getValue());
          }
        }
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, BizContext struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      struct.name = iprot.readString();
      struct.setNameIsSet(true);
      struct.uid = iprot.readString();
      struct.setUidIsSet(true);
      BitSet incoming = iprot.readBitSet(3);
      if (incoming.get(0)) {
        struct.productId = iprot.readString();
        struct.setProductIdIsSet(true);
      }
      if (incoming.get(1)) {
        struct.reqTime = iprot.readString();
        struct.setReqTimeIsSet(true);
      }
      if (incoming.get(2)) {
        {
          org.apache.thrift.protocol.TMap _map6 = new org.apache.thrift.protocol.TMap(org.apache.thrift.protocol.TType.STRING, org.apache.thrift.protocol.TType.STRING, iprot.readI32());
          struct.bizExt = new HashMap<String,String>(2*_map6.size);
          String _key7;
          String _val8;
          for (int _i9 = 0; _i9 < _map6.size; ++_i9)
          {
            _key7 = iprot.readString();
            _val8 = iprot.readString();
            struct.bizExt.put(_key7, _val8);
          }
        }
        struct.setBizExtIsSet(true);
      }
    }
  }

}

