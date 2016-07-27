package com.trip;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.annotation.Order;

@SpringBootApplication
@ConfigurationProperties(prefix = "spring.redis", locations = "classpath:config/redis.properties")
@Order(value = 1)
public class CoreApplication implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(CoreApplication.class);

    @Override
    public void run(String... args) throws Exception {
        LOGGER.info("trip-core startup success!");
    }

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(CoreApplication.class);
        springApplication.setWebEnvironment(false);
        springApplication.run(args);
    }
}
