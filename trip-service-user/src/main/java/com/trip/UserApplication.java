package com.trip;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.annotation.Order;
import org.springframework.transaction.annotation.EnableTransactionManagement;

// 启用事务管理
@EnableTransactionManagement
@SpringBootApplication
@Order(value = 2)
public class UserApplication implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(CoreApplication.class);

    @Override
    public void run(String... args) throws Exception {
        LOGGER.info("trip-user-service startup success!");
    }

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(CoreApplication.class);
        springApplication.setWebEnvironment(false);
        springApplication.run(args);
    }
}
