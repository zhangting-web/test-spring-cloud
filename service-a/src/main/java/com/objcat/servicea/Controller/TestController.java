package com.objcat.servicea.Controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Value("${server.port}")
    private String port;
    @HystrixCommand(fallbackMethod ="fallback")
    @RequestMapping("/hello")
    public String hello() {
        System.out.println("线程池名称"+Thread.currentThread().getName());
        try{
            Thread.sleep(1500);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        return "hello world"+"端口号"+port;
    }
    @RequestMapping("/otherService")
    String fallback() {
        return "服务器繁忙";
    }

}







