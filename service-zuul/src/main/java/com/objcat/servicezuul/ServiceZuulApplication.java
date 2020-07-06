package com.objcat.servicezuul;

import com.objcat.filter.TokenFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
public class ServiceZuulApplication {

    public static void main(String[] args) {

        SpringApplication.run(ServiceZuulApplication.class, args);
    }
@Bean
    TokenFilter tokenFilter(){
        return new TokenFilter();
}
}
