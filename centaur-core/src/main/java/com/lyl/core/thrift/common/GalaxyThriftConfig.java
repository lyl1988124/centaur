package com.lyl.core.thrift.common;

import com.lyl.thrift.client.ThriftServerConfig;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

/**
 * Created by lyl
 * Date 2019/1/9 15:56
 */
@ConfigurationProperties("galaxy")
@Data
public class GalaxyThriftConfig {
    private List<ThriftServerConfig> servers;
}
