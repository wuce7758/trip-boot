package com.trip.geteway.config;


import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2Config {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.com.trip.geteway.rest"))
                .paths(paths())
                .build();
    }

    @SuppressWarnings("unchecked")
    private Predicate<String> paths() {
        return Predicates.or(Predicates.containsPattern("/api/*"));
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Spring Boot中使用Swagger2构建RESTful APIs")
                .description("我的个人博客：https://biezhi.me <br/>" +
                             "我的github：https://github.com/biezhi")
                .termsOfServiceUrl("https://biezhi.me")
                .contact("王爵nice")
                .license("Apache 2.0")
                .version("1.0")
                .build();
    }

}