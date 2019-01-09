package com.lyl.thrift.client;

/**
 * Created by lyl
 * Date 2019/1/8 16:20
 */
public interface ServerSelectionStrategy {
    int getRetries();
    ServerInfo getCandidate();
    void onCandidateCallResult(ServerInfo candidate, boolean success);
}
