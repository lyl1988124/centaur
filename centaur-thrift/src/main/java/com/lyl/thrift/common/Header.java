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
@Generated(value = "Autogenerated by Thrift Compiler (0.9.3)", date = "2019-01-04")
public class Header implements org.apache.thrift.TBase<Header, Header._Fields>, java.io.Serializable, Cloneable, Comparable<Header> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("Header");

  private static final org.apache.thrift.protocol.TField CALLER_FIELD_DESC = new org.apache.thrift.protocol.TField("caller", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField TRACE_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("traceId", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField SPAN_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("spanId", org.apache.thrift.protocol.TType.STRING, (short)3);
  private static final org.apache.thrift.protocol.TField OTHER_MAP_FIELD_DESC = new org.apache.thrift.protocol.TField("otherMap", org.apache.thrift.protocol.TType.MAP, (short)4);
  private static final org.apache.thrift.protocol.TField BIZ_CONTEXT_FIELD_DESC = new org.apache.thrift.protocol.TField("bizContext", org.apache.thrift.protocol.TType.STRUCT, (short)5);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new HeaderStandardSchemeFactory());
    schemes.put(TupleScheme.class, new HeaderTupleSchemeFactory());
  }

  public String caller; // required
  public String traceId; // optional
  public String spanId; // optional
  public Map<String,String> otherMap; // optional
  public BizContext bizContext; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    CALLER((short)1, "caller"),
    TRACE_ID((short)2, "traceId"),
    SPAN_ID((short)3, "spanId"),
    OTHER_MAP((short)4, "otherMap"),
    BIZ_CONTEXT((short)5, "bizContext");

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
        case 1: // CALLER
          return CALLER;
        case 2: // TRACE_ID
          return TRACE_ID;
        case 3: // SPAN_ID
          return SPAN_ID;
        case 4: // OTHER_MAP
          return OTHER_MAP;
        case 5: // BIZ_CONTEXT
          return BIZ_CONTEXT;
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
  private static final _Fields optionals[] = {_Fields.TRACE_ID,_Fields.SPAN_ID,_Fields.OTHER_MAP,_Fields.BIZ_CONTEXT};
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.CALLER, new org.apache.thrift.meta_data.FieldMetaData("caller", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.TRACE_ID, new org.apache.thrift.meta_data.FieldMetaData("traceId", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.SPAN_ID, new org.apache.thrift.meta_data.FieldMetaData("spanId", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.OTHER_MAP, new org.apache.thrift.meta_data.FieldMetaData("otherMap", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.MapMetaData(org.apache.thrift.protocol.TType.MAP, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING), 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING))));
    tmpMap.put(_Fields.BIZ_CONTEXT, new org.apache.thrift.meta_data.FieldMetaData("bizContext", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, BizContext.class)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(Header.class, metaDataMap);
  }

  public Header() {
  }

  public Header(
    String caller)
  {
    this();
    this.caller = caller;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public Header(Header other) {
    if (other.isSetCaller()) {
      this.caller = other.caller;
    }
    if (other.isSetTraceId()) {
      this.traceId = other.traceId;
    }
    if (other.isSetSpanId()) {
      this.spanId = other.spanId;
    }
    if (other.isSetOtherMap()) {
      Map<String,String> __this__otherMap = new HashMap<String,String>(other.otherMap);
      this.otherMap = __this__otherMap;
    }
    if (other.isSetBizContext()) {
      this.bizContext = new BizContext(other.bizContext);
    }
  }

  public Header deepCopy() {
    return new Header(this);
  }

  @Override
  public void clear() {
    this.caller = null;
    this.traceId = null;
    this.spanId = null;
    this.otherMap = null;
    this.bizContext = null;
  }

  public String getCaller() {
    return this.caller;
  }

  public Header setCaller(String caller) {
    this.caller = caller;
    return this;
  }

  public void unsetCaller() {
    this.caller = null;
  }

  /** Returns true if field caller is set (has been assigned a value) and false otherwise */
  public boolean isSetCaller() {
    return this.caller != null;
  }

  public void setCallerIsSet(boolean value) {
    if (!value) {
      this.caller = null;
    }
  }

  public String getTraceId() {
    return this.traceId;
  }

  public Header setTraceId(String traceId) {
    this.traceId = traceId;
    return this;
  }

  public void unsetTraceId() {
    this.traceId = null;
  }

  /** Returns true if field traceId is set (has been assigned a value) and false otherwise */
  public boolean isSetTraceId() {
    return this.traceId != null;
  }

  public void setTraceIdIsSet(boolean value) {
    if (!value) {
      this.traceId = null;
    }
  }

  public String getSpanId() {
    return this.spanId;
  }

  public Header setSpanId(String spanId) {
    this.spanId = spanId;
    return this;
  }

  public void unsetSpanId() {
    this.spanId = null;
  }

  /** Returns true if field spanId is set (has been assigned a value) and false otherwise */
  public boolean isSetSpanId() {
    return this.spanId != null;
  }

  public void setSpanIdIsSet(boolean value) {
    if (!value) {
      this.spanId = null;
    }
  }

  public int getOtherMapSize() {
    return (this.otherMap == null) ? 0 : this.otherMap.size();
  }

  public void putToOtherMap(String key, String val) {
    if (this.otherMap == null) {
      this.otherMap = new HashMap<String,String>();
    }
    this.otherMap.put(key, val);
  }

  public Map<String,String> getOtherMap() {
    return this.otherMap;
  }

  public Header setOtherMap(Map<String,String> otherMap) {
    this.otherMap = otherMap;
    return this;
  }

  public void unsetOtherMap() {
    this.otherMap = null;
  }

  /** Returns true if field otherMap is set (has been assigned a value) and false otherwise */
  public boolean isSetOtherMap() {
    return this.otherMap != null;
  }

  public void setOtherMapIsSet(boolean value) {
    if (!value) {
      this.otherMap = null;
    }
  }

  public BizContext getBizContext() {
    return this.bizContext;
  }

  public Header setBizContext(BizContext bizContext) {
    this.bizContext = bizContext;
    return this;
  }

  public void unsetBizContext() {
    this.bizContext = null;
  }

  /** Returns true if field bizContext is set (has been assigned a value) and false otherwise */
  public boolean isSetBizContext() {
    return this.bizContext != null;
  }

  public void setBizContextIsSet(boolean value) {
    if (!value) {
      this.bizContext = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case CALLER:
      if (value == null) {
        unsetCaller();
      } else {
        setCaller((String)value);
      }
      break;

    case TRACE_ID:
      if (value == null) {
        unsetTraceId();
      } else {
        setTraceId((String)value);
      }
      break;

    case SPAN_ID:
      if (value == null) {
        unsetSpanId();
      } else {
        setSpanId((String)value);
      }
      break;

    case OTHER_MAP:
      if (value == null) {
        unsetOtherMap();
      } else {
        setOtherMap((Map<String,String>)value);
      }
      break;

    case BIZ_CONTEXT:
      if (value == null) {
        unsetBizContext();
      } else {
        setBizContext((BizContext)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case CALLER:
      return getCaller();

    case TRACE_ID:
      return getTraceId();

    case SPAN_ID:
      return getSpanId();

    case OTHER_MAP:
      return getOtherMap();

    case BIZ_CONTEXT:
      return getBizContext();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case CALLER:
      return isSetCaller();
    case TRACE_ID:
      return isSetTraceId();
    case SPAN_ID:
      return isSetSpanId();
    case OTHER_MAP:
      return isSetOtherMap();
    case BIZ_CONTEXT:
      return isSetBizContext();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof Header)
      return this.equals((Header)that);
    return false;
  }

  public boolean equals(Header that) {
    if (that == null)
      return false;

    boolean this_present_caller = true && this.isSetCaller();
    boolean that_present_caller = true && that.isSetCaller();
    if (this_present_caller || that_present_caller) {
      if (!(this_present_caller && that_present_caller))
        return false;
      if (!this.caller.equals(that.caller))
        return false;
    }

    boolean this_present_traceId = true && this.isSetTraceId();
    boolean that_present_traceId = true && that.isSetTraceId();
    if (this_present_traceId || that_present_traceId) {
      if (!(this_present_traceId && that_present_traceId))
        return false;
      if (!this.traceId.equals(that.traceId))
        return false;
    }

    boolean this_present_spanId = true && this.isSetSpanId();
    boolean that_present_spanId = true && that.isSetSpanId();
    if (this_present_spanId || that_present_spanId) {
      if (!(this_present_spanId && that_present_spanId))
        return false;
      if (!this.spanId.equals(that.spanId))
        return false;
    }

    boolean this_present_otherMap = true && this.isSetOtherMap();
    boolean that_present_otherMap = true && that.isSetOtherMap();
    if (this_present_otherMap || that_present_otherMap) {
      if (!(this_present_otherMap && that_present_otherMap))
        return false;
      if (!this.otherMap.equals(that.otherMap))
        return false;
    }

    boolean this_present_bizContext = true && this.isSetBizContext();
    boolean that_present_bizContext = true && that.isSetBizContext();
    if (this_present_bizContext || that_present_bizContext) {
      if (!(this_present_bizContext && that_present_bizContext))
        return false;
      if (!this.bizContext.equals(that.bizContext))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    List<Object> list = new ArrayList<Object>();

    boolean present_caller = true && (isSetCaller());
    list.add(present_caller);
    if (present_caller)
      list.add(caller);

    boolean present_traceId = true && (isSetTraceId());
    list.add(present_traceId);
    if (present_traceId)
      list.add(traceId);

    boolean present_spanId = true && (isSetSpanId());
    list.add(present_spanId);
    if (present_spanId)
      list.add(spanId);

    boolean present_otherMap = true && (isSetOtherMap());
    list.add(present_otherMap);
    if (present_otherMap)
      list.add(otherMap);

    boolean present_bizContext = true && (isSetBizContext());
    list.add(present_bizContext);
    if (present_bizContext)
      list.add(bizContext);

    return list.hashCode();
  }

  @Override
  public int compareTo(Header other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetCaller()).compareTo(other.isSetCaller());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetCaller()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.caller, other.caller);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetTraceId()).compareTo(other.isSetTraceId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTraceId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.traceId, other.traceId);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetSpanId()).compareTo(other.isSetSpanId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetSpanId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.spanId, other.spanId);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetOtherMap()).compareTo(other.isSetOtherMap());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetOtherMap()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.otherMap, other.otherMap);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetBizContext()).compareTo(other.isSetBizContext());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetBizContext()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.bizContext, other.bizContext);
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
    StringBuilder sb = new StringBuilder("Header(");
    boolean first = true;

    sb.append("caller:");
    if (this.caller == null) {
      sb.append("null");
    } else {
      sb.append(this.caller);
    }
    first = false;
    if (isSetTraceId()) {
      if (!first) sb.append(", ");
      sb.append("traceId:");
      if (this.traceId == null) {
        sb.append("null");
      } else {
        sb.append(this.traceId);
      }
      first = false;
    }
    if (isSetSpanId()) {
      if (!first) sb.append(", ");
      sb.append("spanId:");
      if (this.spanId == null) {
        sb.append("null");
      } else {
        sb.append(this.spanId);
      }
      first = false;
    }
    if (isSetOtherMap()) {
      if (!first) sb.append(", ");
      sb.append("otherMap:");
      if (this.otherMap == null) {
        sb.append("null");
      } else {
        sb.append(this.otherMap);
      }
      first = false;
    }
    if (isSetBizContext()) {
      if (!first) sb.append(", ");
      sb.append("bizContext:");
      if (this.bizContext == null) {
        sb.append("null");
      } else {
        sb.append(this.bizContext);
      }
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    if (caller == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'caller' was not present! Struct: " + toString());
    }
    // check for sub-struct validity
    if (bizContext != null) {
      bizContext.validate();
    }
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

  private static class HeaderStandardSchemeFactory implements SchemeFactory {
    public HeaderStandardScheme getScheme() {
      return new HeaderStandardScheme();
    }
  }

  private static class HeaderStandardScheme extends StandardScheme<Header> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, Header struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // CALLER
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.caller = iprot.readString();
              struct.setCallerIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // TRACE_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.traceId = iprot.readString();
              struct.setTraceIdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // SPAN_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.spanId = iprot.readString();
              struct.setSpanIdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // OTHER_MAP
            if (schemeField.type == org.apache.thrift.protocol.TType.MAP) {
              {
                org.apache.thrift.protocol.TMap _map10 = iprot.readMapBegin();
                struct.otherMap = new HashMap<String,String>(2*_map10.size);
                String _key11;
                String _val12;
                for (int _i13 = 0; _i13 < _map10.size; ++_i13)
                {
                  _key11 = iprot.readString();
                  _val12 = iprot.readString();
                  struct.otherMap.put(_key11, _val12);
                }
                iprot.readMapEnd();
              }
              struct.setOtherMapIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 5: // BIZ_CONTEXT
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.bizContext = new BizContext();
              struct.bizContext.read(iprot);
              struct.setBizContextIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, Header struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.caller != null) {
        oprot.writeFieldBegin(CALLER_FIELD_DESC);
        oprot.writeString(struct.caller);
        oprot.writeFieldEnd();
      }
      if (struct.traceId != null) {
        if (struct.isSetTraceId()) {
          oprot.writeFieldBegin(TRACE_ID_FIELD_DESC);
          oprot.writeString(struct.traceId);
          oprot.writeFieldEnd();
        }
      }
      if (struct.spanId != null) {
        if (struct.isSetSpanId()) {
          oprot.writeFieldBegin(SPAN_ID_FIELD_DESC);
          oprot.writeString(struct.spanId);
          oprot.writeFieldEnd();
        }
      }
      if (struct.otherMap != null) {
        if (struct.isSetOtherMap()) {
          oprot.writeFieldBegin(OTHER_MAP_FIELD_DESC);
          {
            oprot.writeMapBegin(new org.apache.thrift.protocol.TMap(org.apache.thrift.protocol.TType.STRING, org.apache.thrift.protocol.TType.STRING, struct.otherMap.size()));
            for (Map.Entry<String, String> _iter14 : struct.otherMap.entrySet())
            {
              oprot.writeString(_iter14.getKey());
              oprot.writeString(_iter14.getValue());
            }
            oprot.writeMapEnd();
          }
          oprot.writeFieldEnd();
        }
      }
      if (struct.bizContext != null) {
        if (struct.isSetBizContext()) {
          oprot.writeFieldBegin(BIZ_CONTEXT_FIELD_DESC);
          struct.bizContext.write(oprot);
          oprot.writeFieldEnd();
        }
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class HeaderTupleSchemeFactory implements SchemeFactory {
    public HeaderTupleScheme getScheme() {
      return new HeaderTupleScheme();
    }
  }

  private static class HeaderTupleScheme extends TupleScheme<Header> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, Header struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      oprot.writeString(struct.caller);
      BitSet optionals = new BitSet();
      if (struct.isSetTraceId()) {
        optionals.set(0);
      }
      if (struct.isSetSpanId()) {
        optionals.set(1);
      }
      if (struct.isSetOtherMap()) {
        optionals.set(2);
      }
      if (struct.isSetBizContext()) {
        optionals.set(3);
      }
      oprot.writeBitSet(optionals, 4);
      if (struct.isSetTraceId()) {
        oprot.writeString(struct.traceId);
      }
      if (struct.isSetSpanId()) {
        oprot.writeString(struct.spanId);
      }
      if (struct.isSetOtherMap()) {
        {
          oprot.writeI32(struct.otherMap.size());
          for (Map.Entry<String, String> _iter15 : struct.otherMap.entrySet())
          {
            oprot.writeString(_iter15.getKey());
            oprot.writeString(_iter15.getValue());
          }
        }
      }
      if (struct.isSetBizContext()) {
        struct.bizContext.write(oprot);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, Header struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      struct.caller = iprot.readString();
      struct.setCallerIsSet(true);
      BitSet incoming = iprot.readBitSet(4);
      if (incoming.get(0)) {
        struct.traceId = iprot.readString();
        struct.setTraceIdIsSet(true);
      }
      if (incoming.get(1)) {
        struct.spanId = iprot.readString();
        struct.setSpanIdIsSet(true);
      }
      if (incoming.get(2)) {
        {
          org.apache.thrift.protocol.TMap _map16 = new org.apache.thrift.protocol.TMap(org.apache.thrift.protocol.TType.STRING, org.apache.thrift.protocol.TType.STRING, iprot.readI32());
          struct.otherMap = new HashMap<String,String>(2*_map16.size);
          String _key17;
          String _val18;
          for (int _i19 = 0; _i19 < _map16.size; ++_i19)
          {
            _key17 = iprot.readString();
            _val18 = iprot.readString();
            struct.otherMap.put(_key17, _val18);
          }
        }
        struct.setOtherMapIsSet(true);
      }
      if (incoming.get(3)) {
        struct.bizContext = new BizContext();
        struct.bizContext.read(iprot);
        struct.setBizContextIsSet(true);
      }
    }
  }

}

