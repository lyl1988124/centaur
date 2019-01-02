package com.lyl;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Created by lyl
 * Date 2018/11/28
 */

//@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
@SpringBootApplication
@MapperScan("com.lyl.core.dao.mapper")
public class App {
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(App.class, args);
        System.out.println("!!!!");

        //ctx.start();
        //通知关闭
        //ctx.stop();
        System.out.println("###");
        //彻底关闭
        //ctx.close();
    }


}
