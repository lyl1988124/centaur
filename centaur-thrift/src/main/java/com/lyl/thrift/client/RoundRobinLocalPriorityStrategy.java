package com.lyl.thrift.client;

import com.lyl.thrift.util.InetUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by lyl
 * Date 2019/1/8 20:11
 */
public class RoundRobinLocalPriorityStrategy implements ServerSelectionStrategy {
    private final static Logger LOGGER = LogManager.getLogger(RoundRobinLocalPriorityStrategy.class);

    private final int retries;
    private final List<CandidateRecorder> recorders;
    private final int retryIntervalAfterFailure = 3000;
    private final AtomicInteger currCandidateIndex = new AtomicInteger();
    private final String LOCAL_HOST = "127.0。0.1";

    public RoundRobinLocalPriorityStrategy(ServerInfo[] serverInfos, int retries){
        this.recorders = new ArrayList<>(serverInfos.length);
        for(ServerInfo serverInfo : serverInfos){
            if(serverInfo.getHost().equals(InetUtil.getLocalHost())){
                serverInfo.setHost(LOCAL_HOST);
            }
            this.recorders.add(new CandidateRecorder(retryIntervalAfterFailure,serverInfo));
        }
        this.retries = (retries < 0? 0: retries);
    }

    private ServerInfo localHostServerProbe(){
        for(int i=0; i<recorders.size(); i++){
            if(recorders.get(i).getCandidate().getHost().equals(LOCAL_HOST)){
                ServerInfo validCandidate = recorders.get(i).getValidCandidate();
                if(validCandidate != null){
                    return validCandidate;
                }
            }
        }
        return null;
    }

    @Override
    public int getRetries() {
        return retries;
    }

    @Override
    public ServerInfo getCandidate() {
        ServerInfo localServer = localHostServerProbe();
        if(localServer != null){
            return localServer;
        }
        for(int i = 0; i < recorders.size(); i++){
            int currentIndex = Math.abs(currCandidateIndex.getAndIncrement() % recorders.size());
            CandidateRecorder recorder = this.recorders.get(currentIndex);
            ServerInfo serverInfo = recorder.getCandidate();
            if(serverInfo != null){
                return serverInfo;
            }
        }

        //all dead
        int currentIndex = Math.abs(currCandidateIndex.getAndIncrement() % recorders.size());
        CandidateRecorder recorder = this.recorders.get(currentIndex);

        return recorder.getCandidate();
    }

    @Override
    public void onCandidateCallResult(ServerInfo candidate, boolean success) {
        if(candidate == null){
            return;
        }
        for(int i = 0; i < this.recorders.size(); i++){
            CandidateRecorder recorder = recorders.get(i);
            if(recorder.getCandidate().equals(candidate)){
                recorder.recordCallresult(success);
                return;
            }
        }
        throw new RpcException("Fatal: this is error" + candidate);
    }
}
