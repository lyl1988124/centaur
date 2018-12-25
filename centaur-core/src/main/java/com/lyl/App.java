package com.lyl;


import com.lyl.core.service.TestService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Created by lyl
 * Date 2018/11/28
 */

@SpringBootApplication
public class App {


    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(App.class, args);
        ctx.start();

    }
}
