package com.lyl.thrift.thrift;

import com.lyl.thrift.common.Trace;
import org.apache.thrift.TBaseProcessor;
import org.apache.thrift.protocol.TProtocol;

import java.lang.reflect.Method;

/**
 * Created by lyl
 * Date 2019/1/3 16:46
 */
public class ThriftMethod {
    final TBaseProcessor processor;

    final Method targetMethod;

    final Class<?> holderClass;

    final Class<?> ifaceClass;

    final String fullMethodName;

    final ThriftProtocol thriftProtocol;

    final boolean forceSignature;

    public ThriftMethod(TBaseProcessor processor, Method targetMethod, Class<?> holderClass, Class<?> ifaceClass, ThriftProtocol thriftProtocol, boolean forceSignature) {
        this.processor = processor;
        this.targetMethod = targetMethod;
        this.holderClass = holderClass;
        this.ifaceClass = ifaceClass;
        this.fullMethodName = ifaceClass.getName() + "." + targetMethod.getName();;
        this.thriftProtocol = thriftProtocol;
        this.forceSignature = forceSignature;
    }

    static class HeaderInfo{
        final Trace trace;
        final String signString;

        public HeaderInfo(Trace trace, String signString) {
            this.trace = trace;
            this.signString = signString;
        }
    }

    static final ThreadLocal<HeaderInfo> TRACE_DOMAIN = new ThreadLocal<>();

    void acceptHeader(TProtocol protocol){
        if(protocol instanceof ThriftHeaderProtocol){
            ThriftHeaderProtocol thriftHeaderProtocol = (ThriftHeaderProtocol) protocol;
            TRACE_DOMAIN.set(new HeaderInfo(thriftHeaderProtocol.getTrace(),thriftHeaderProtocol.getSignatureString()));
        }
    }

    void clearTrace(){
        TRACE_DOMAIN.remove();
    }

    Object getTraceDomain(Object[] args){
        if(TRACE_DOMAIN.get()==null || TRACE_DOMAIN.get().trace == null){
            return args;
        }
        return TRACE_DOMAIN.get().trace;
    }

    String getSignString(){
        if(TRACE_DOMAIN.get() == null){
            return null;
        }
        return TRACE_DOMAIN.get().signString;
    }

}
