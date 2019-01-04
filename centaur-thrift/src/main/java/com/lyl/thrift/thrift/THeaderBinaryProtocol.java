package com.lyl.thrift.thrift;

import com.lyl.thrift.common.Trace;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.*;
import org.apache.thrift.transport.TTransport;

/**
 * Created by lyl
 * Date 2019/1/4 11:11
 */
public class THeaderBinaryProtocol extends TBinaryProtocol implements ThriftHeaderProtocol{
    private static final String TRACE_INFO_HEADER_NAME = "_TRACE_INFO_HEADER";
    private static final String SIGNATURE_INFO_HEADER_NAME = "_SIGNATURE_INFO_HEADER";

    private static final long NO_LENGTH_LIMIT = -1;
    private final ThriftHeaderProvider thriftHeaderProvider;



    private final boolean isClient;
    private TField firstField;
    private Trace headerTrace;
    private String headerSign;

    /**
     * 仅客户端使用
     * @param trans
     * @param thriftHeaderProvider
     */
    public THeaderBinaryProtocol(TTransport trans, ThriftHeaderProvider thriftHeaderProvider) {
        this(trans, NO_LENGTH_LIMIT, NO_LENGTH_LIMIT, false, false, thriftHeaderProvider, true);
    }

    private THeaderBinaryProtocol(TTransport trans, long stringLengthLimit, long containerLengthLimit,
                                  boolean strictRead, boolean strictWrite, ThriftHeaderProvider thriftHeaderProvider, boolean isClient) {
        super(trans, stringLengthLimit, containerLengthLimit, strictRead, strictWrite);
        this.thriftHeaderProvider = thriftHeaderProvider;
        this.isClient = isClient;
    }



    public static class ServerSideFactory implements TProtocolFactory {

        protected long stringLengthLimit_;
        protected long containerLengthLimit_;
        protected boolean strictRead_;
        protected boolean strictWrite_;
        private final ThriftHeaderProvider thriftHeaderProvider;

        /**
         * 仅仅服务端使用
         */
        public ServerSideFactory() {
            this(false, true, null);
        }

        private ServerSideFactory(boolean strictRead, boolean strictWrite,
                                  ThriftHeaderProvider thriftHeaderProvider) {
            this(strictRead, strictWrite, NO_LENGTH_LIMIT, NO_LENGTH_LIMIT, thriftHeaderProvider);
        }


        private ServerSideFactory(boolean strictRead, boolean strictWrite, long stringLengthLimit,
                                  long containerLengthLimit, ThriftHeaderProvider thriftHeaderProvider) {
            stringLengthLimit_ = stringLengthLimit;
            containerLengthLimit_ = containerLengthLimit;
            strictRead_ = strictRead;
            strictWrite_ = strictWrite;
            this.thriftHeaderProvider = thriftHeaderProvider;
        }

        public TProtocol getProtocol(TTransport trans) {
            return new THeaderBinaryProtocol(trans, stringLengthLimit_, containerLengthLimit_,
                    strictRead_, strictWrite_, thriftHeaderProvider,false);
        }
    }
    @Override
    public void writeMessageBegin(TMessage message) throws TException {
        super.writeMessageBegin(message);
        if(isClient) {
            processSign();
            processTrace();
        }
    }

    /**
     * 发送trace
     *
     * @throws TException
     */
    private void processTrace() throws TException {
        if (thriftHeaderProvider == null) {
            return;
        }
        Trace trace = thriftHeaderProvider.provideTrace();
        if (trace == null) {
            return;
        }
        super.writeFieldBegin(new TField(TRACE_INFO_HEADER_NAME, TType.STRUCT, (short) 0));
        trace.write(this);
        super.writeFieldEnd();
    }

    /**
     * 发送验签信息
     *
     * @throws TException
     */
    private void processSign() throws TException {
        if (thriftHeaderProvider == null) {
            return;
        }
        String sign = thriftHeaderProvider.provideSignatureInfo();
        if (sign == null || sign.length() == 0) {
            return;
        }

        super.writeFieldBegin(new TField(SIGNATURE_INFO_HEADER_NAME, TType.STRING, (short) -1));
        super.writeString(sign);
        super.writeFieldEnd();
    }

    @Override
    public TMessage readMessageBegin() throws TException {
        TMessage tMessage = super.readMessageBegin();
        if(isClient) {
            return tMessage;
        }
        while (true) {
            TField tField = super.readFieldBegin();
            if (tField.id > 0) {
                firstField = tField;
                break;
            }
            if (tField.id == -1) {
                headerSign = super.readString();
                super.readFieldEnd();
                continue;
            }

            if (tField.id == 0) {
                Trace trace = new Trace();
                trace.read(this);
                headerTrace = trace;
                super.readFieldEnd();
                continue;
            }
            throw new TException();
        }
        return tMessage;
    }

    @Override
    public TField readFieldBegin() throws TException {
        if (firstField == null) {
            return super.readFieldBegin();
        }

        TField t = firstField;
        firstField = null;
        return t;
    }

    @Override
    public Trace getTrace() {
        return headerTrace;
    }

    @Override
    public String getSignatureString() {
        return headerSign;
    }
}
