package com.lyl;


import com.lyl.core.thrift.common.GalaxyThriftConfig;
import com.lyl.thrift.server.*;
import org.apache.thrift.transport.TTransportException;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * Created by lyl
 * Date 2018/11/28
 */

//@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
@SpringBootApplication
@MapperScan("com.lyl.core.dao.mapper")
@EnableConfigurationProperties(GalaxyThriftConfig.class)
public class App {
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(App.class, args);
        startThrift(ctx);
    }

    private static void startThrift(ConfigurableApplicationContext ctx) {
        ThriftConfigProvider thriftConfigProvider = ctx
                .getBean("thriftConfigProvider", ThriftConfigProvider.class);
        try {
            ThriftLoader.load(new SpringContainerContext(ctx), thriftConfigProvider);
        } catch (TTransportException e) {
            throw new RuntimeException(e);
        }
    }

    @Bean
    public SpringThriftConfigProvider thriftConfigProvider() {
        SpringThriftConfigProvider provider = new SpringThriftConfigProvider();
        return provider;
    }


    @Bean
    public ThriftSignatureChecker defaultThriftSignChecker() {
        return (Object[] args, String methodName, byte[] body, String sign) -> {
            System.out.println(sign);
            if (sign == null || sign.length() == 0) {
                return true;
            }
            String md5 = SignatureHelper.md5Signature(body);
            return sign.equalsIgnoreCase(md5);
        };
    }
}
