package com.tongji.express;

import com.timesten.jdbc.TimesTenDataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class ExpressApplication {

    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("com.timesten.jdbc.TimesTenDriver");
        ttds.setUrl("jdbc:timesten:client:ttc_server=8.133.185.160;tcp_port=53397;ttc_server_dsn=my_ttdb;uid=test;pwd=test");
        SpringApplication.run(ExpressApplication.class, args);
    }
    public static TimesTenDataSource ttds = new TimesTenDataSource();


}
