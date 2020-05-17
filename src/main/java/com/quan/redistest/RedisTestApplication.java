package com.quan.redistest;

import tk.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("com.quan.redistest.Mapper")
@EnableScheduling
public class RedisTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(RedisTestApplication.class, args);
    }

}
