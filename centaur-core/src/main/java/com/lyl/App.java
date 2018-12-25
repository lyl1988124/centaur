package com.lyl;


import com.lyl.core.service.TestService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

/**
 * Created by lyl
 * Date 2018/11/28
 */

@SpringBootApplication
@MapperScan("com.lyl.core.dao.mapper")
public class App {
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(App.class, args);
        ctx.start();

    }
}
