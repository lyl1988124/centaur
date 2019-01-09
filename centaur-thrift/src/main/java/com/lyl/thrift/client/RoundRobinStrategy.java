package com.lyl.thrift.client;

import org.apache.logging.log4j.core.jmx.Server;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by lyl
 * Date 2019/1/8 16:47
 */
public class RoundRobinStrategy implements ServerSelectionStrategy{

    private final List<CandidateRecorder> recorders;
    private final int tries;
    private final int retryIntervalAfterFailure = 3000;
    private final AtomicInteger currCandidateIndex = new AtomicInteger();

    public RoundRobinStrategy(ServerInfo[] servers, int tries) {
        this.recorders = new ArrayList<>(servers.length);
        for(ServerInfo server : servers){
            this.recorders.add(new CandidateRecorder(retryIntervalAfterFailure,server));
        }
        this.tries = (tries < 0 ? 0 : tries);
    }

    @Override
    public int getRetries() {
        return tries;
    }

    @Override
    public ServerInfo getCandidate() {
        for(int i = 0; i< recorders.size(); i++){
            int currentIndex = Math.abs(currCandidateIndex.getAndIncrement() % recorders.size());
            CandidateRecorder recorder = this.recorders.get(currentIndex);
            ServerInfo validCandidate = recorder.getValidCandidate();

            if(validCandidate!=null){
                return validCandidate;
            }
        }
        //ALL DEAD
        int currentIndex = Math.abs(currCandidateIndex.getAndIncrement()) % recorders.size();
        CandidateRecorder recorder = this.recorders.get(currentIndex);
        return  recorder.getCandidate();
    }

    @Override
    public void onCandidateCallResult(ServerInfo candidate, boolean success) {
        if(candidate == null){
            return;
        }
        for(int i = 0; i < this.recorders.size(); i++){
            CandidateRecorder recorder = this.recorders.get(i);
            recorder.recordCallresult(success);
            return;
        }
        throw new RpcException("Fatal: Very serious mistake" + candidate);
    }
}
