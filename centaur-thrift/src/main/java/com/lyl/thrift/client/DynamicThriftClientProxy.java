package com.lyl.thrift.client;

import com.google.gson.Gson;
import org.apache.commons.lang3.StringUtils;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TMultiplexedProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

import java.io.IOException;
import java.lang.reflect.*;
import java.net.ConnectException;
import java.net.SocketTimeoutException;

/**
 * Created by lyl
 * Date 2019/1/8 16:13
 */
public class DynamicThriftClientProxy<T> implements InvocationHandler {

    Class<T> clientClass;

    ServerInfo[] servers;
    Class protocolClass;
    Class transportClass;

    //服务选择策略
    ServerSelectionStrategy strategy;

    final static String MSG_THRIFT_UNKNOWN_EXCEPTION = "call_thrift_unknown_error";
    final static String MSG_SOCKET_TIMEOUT_EXCEPTION = "socket_time_out";
    final static String MSG_CONNECT_REFUSE_EXCEPTION = "connection_refuse";
    final static String MSG_CONNECT_SOCKET_EXCEPTION = "socket_exception";

    final static int THRIFT_STAT_CODE_SUCCESS = 10000;
    final static int THRIFT_STAT_CODE_SOCKET_TIMEOUT = 20000;
    final static int THRIFT_STAT_CODE_CONNECT_FAIL = 30000;
    final static int THRIFT_STAT_CODE_SOCKET_EXCEPTION = 40000;
    final static int THRIFT_STAT_CODE_UNKNOWN_ERROR = 50000;

    public DynamicThriftClientProxy(Class<T> clientClass, final ServerInfo[] servers) {
        this(clientClass, TBinaryProtocol.class, servers, new RoundRobinStrategy(servers, 1));
    }

    public DynamicThriftClientProxy(Class<T> clientClass, final ServerInfo[] servers,int retryCount) {
        this(clientClass, TBinaryProtocol.class, servers, new RoundRobinStrategy(servers,retryCount));
    }

    public DynamicThriftClientProxy(Class<T> clientClass, Class protocolClass, final ServerInfo[] servers, ServerSelectionStrategy strategy) {
        this(clientClass, protocolClass, null, servers, strategy);
    }

    public DynamicThriftClientProxy(Class<T> clientClass, Class protocolClass, Class transportClass,
                                    final ServerInfo[] servers, ServerSelectionStrategy strategy) {
        this.servers = new ServerInfo[servers.length];
        this.servers = servers;
        this.clientClass = clientClass;
        if(strategy == null) {
            //如果未设置strategy
            strategy = new RoundRobinStrategy(servers, 1);
        }
        this.strategy = strategy;
        this.protocolClass = protocolClass;
        this.transportClass = transportClass;
    }

    public Object getProxy(){
        return Proxy.newProxyInstance(clientClass.getClassLoader(),clientClass.getInterfaces(),this);
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
       int retries = strategy.getRetries();
       boolean success = false;
       Throwable failureException = null;
       T client = null;
       boolean retry = false;

       String className = clientClass.getName();

       do{
            failureException = null;
            final long before = System.currentTimeMillis();
            Object result = null;
           TSocket tSocket = null;
           ServerInfo serverInfo = null;
           try {
               serverInfo = strategy.getCandidate();
               if(serverInfo == null
                       || serverInfo.getHost() == null
                       || serverInfo.getPort() <=0
               ){
                   throw new RpcException("server info error =>" + serverInfo);
               }

               tSocket = new TSocket(serverInfo.getHost(),serverInfo.getPort());

               int timeout = serverInfo.getTimeOut(method.getName());

               tSocket.setSocketTimeout(timeout <=0 ? 100 : timeout);

               TProtocol tprotocol;

               if(StringUtils.equals(protocolClass.getCanonicalName(), TMultiplexedProtocol.class.getCanonicalName())){
                   Constructor<TProtocol> constructor = protocolClass.getConstructor(TProtocol.class, String.class);
                   tprotocol = constructor.newInstance(new TBinaryProtocol(tSocket),className.substring(0,className.indexOf("$")));
               }else if(this.transportClass != null){
                   Constructor<TTransport> transportConstructor = transportClass.getConstructor(TTransport.class);
                   TTransport tTransport = transportConstructor.newInstance(tSocket);
                   Constructor<TProtocol> constructor = protocolClass.getConstructor(TTransport.class);
                   tprotocol = constructor.newInstance(tTransport);
               }else {
                   Constructor<TProtocol> constructor = protocolClass.getConstructor(TTransport.class);
                   tprotocol = constructor.newInstance(tSocket);
               }

               Class[] argsClass  = new Class[]{
                  TProtocol.class
               };

               Constructor<T> constructor = clientClass.getConstructor(argsClass);
               client = constructor.newInstance(tprotocol);
               tSocket.open();

               result = method.invoke(client,args);

               //设置成功
               success = true;
               return result;
           }catch (InvocationTargetException e) {

               failureException = e.getTargetException();
               if(failureException == null){
                   failureException = e;
               }
           } catch (Throwable t) {
               failureException = t;
           } finally {
               if(tSocket != null){
                   closeConnection(tSocket);
               }
               this.strategy.onCandidateCallResult(serverInfo,success);

               Throwable rootException = lookupRootCause(failureException);
               retry = isNetWorkException(rootException);

               final long after = System.currentTimeMillis();
               final long cost = after - before;

               String host = serverInfo.getHost();
               String port = String.valueOf(serverInfo.getPort());
               String callee = getDefaultServiceName();
               Gson gson= new Gson();
               String argsStr = gson.toJson(args);
               String resultStr = gson.toJson(result);

               if(success){
                   //todo
               }else {
                   //todo
               }
           }
       }while (!success && retry && retries-- >0);


        return null;
    }

    private void closeConnection(TSocket tSocket){
        if(tSocket == null ){
            return;
        }
        tSocket.close();

    }

    private static Throwable lookupRootCause(final Throwable t) {
        if(t == null) {
            return null;
        }
        Throwable current = t;
        while(current.getCause() != null) {
            current = current.getCause();
        }
        return current;
    }

    public static boolean isNetWorkException(Throwable t){
        if(t != null && t instanceof IOException){
            if(t instanceof SocketTimeoutException){
                return true;
            }else if (t instanceof ConnectException){
                return true;
            }else {
                return true;
            }
        }
        return false;
    }

    public String getDefaultServiceName(){
        return this.clientClass.getName().split("\\$")[0];


    }
}
