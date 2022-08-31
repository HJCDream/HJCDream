package com.hjc.springbootwechatshop;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@MapperScan("com.hjc.springbootwechatshop.*")
@ComponentScan("com.hjc.springbootwechatshop.*")
@SpringBootApplication
public class SpringbootwechatshopApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootwechatshopApplication.class, args);
        System.out.println("启动完成");

    }

}
