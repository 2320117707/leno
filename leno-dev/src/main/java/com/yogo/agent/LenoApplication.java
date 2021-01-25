package com.yogo.agent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @Author 董乙辰
 * @Date 2021/1/24 11:42
 * @Description
 **/
@SpringBootApplication
@ComponentScan(basePackages = "com.yogo")
@MapperScan(basePackages = "com.yogo.agent.mapper")
public class LenoApplication {
    public static void main(String[] args) {
        SpringApplication.run(LenoApplication.class, args);
    }
}
