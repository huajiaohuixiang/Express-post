package com.tongji.express;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class ExpressApplication {

    public static void main(String[] args) throws ClassNotFoundException {
        SpringApplication.run(ExpressApplication.class, args);
    }

}
