package com.trip;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

// 启动mvc
@EnableWebMvc
// 启用异步调用
@EnableAsync
@SpringBootApplication
public class GetewayApplication implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(GetewayApplication.class);

    /**
     * 应用启动后运行
     *
     * @param strings
     * @throws Exception
     */
    @Override
    public void run(String... strings) throws Exception {
        LOGGER.info("gateway startup success!");
    }

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(GetewayApplication.class, args);
        /*
        String[] beanNames = ctx.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        for (String beanName : beanNames) {
            LOGGER.info(beanName);
        }*/
    }

}
