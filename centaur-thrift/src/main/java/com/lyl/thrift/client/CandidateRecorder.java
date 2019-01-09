package com.lyl.thrift.client;

import lombok.Getter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by lyl
 * Date 2019/1/8 16:53
 */
public class CandidateRecorder {
    private final static Logger LOGGER = LogManager.getLogger(CandidateRecorder.class);

    private final int maxTtdInMs = 1 * 60 * 1000;
    private final int ttdInMsUnit;
    private int ttdInMs = 0;

    @Getter
    private ServerInfo candidate;
    private long invalidStartTime = 0;
    private int failCount = 0;

    public CandidateRecorder(int ttdInMsUnit, ServerInfo candidate) {
        this.ttdInMsUnit = ttdInMsUnit;
        this.candidate = candidate;
        this.ttdInMs = this.ttdInMsUnit;
    }

    public ServerInfo getValidCandidate(){
        long currentTime = System.currentTimeMillis();
        if(ttdInMs > 0 && currentTime - invalidStartTime <= ttdInMs){
            return null;
        }else{
            return this.candidate;
        }
    }

    private void markFailEnd() {
        this.failCount = 0;
        this.ttdInMs = 0;
        this.invalidStartTime = 0;
    }

    private void markFailStart(){
        this.invalidStartTime = System.currentTimeMillis();
    }

    protected void calTtd(final boolean success){
        if(success){
            markFailEnd();
            return;
        }
        failCount++;
        if(failCount == 1){
            this.ttdInMs = this.ttdInMsUnit;
        }else if(failCount == 2){
            this.ttdInMs = 2 * this.ttdInMsUnit;
        }else {
            this.ttdInMs = this.maxTtdInMs;
        }

        if(this.ttdInMs > this.maxTtdInMs){
            this.ttdInMs = this.maxTtdInMs;
        }
        markFailStart();

        LOGGER.info("Candidate fail count:{}, set ttd :{}, with: {}", this.failCount, this.ttdInMs, this.candidate);
    }

    public void recordCallresult(boolean success){

    }

}
