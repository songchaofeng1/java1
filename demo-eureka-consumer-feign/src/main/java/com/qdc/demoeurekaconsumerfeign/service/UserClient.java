package com.qdc.demoeurekaconsumerfeign.service;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "eureka-provider1")
public interface UserClient {
    @RequestMapping(value = "/port")
    public String hello();
/*
* @FeignClient注解定义在接口上，指定在接口中的方法上以feign组件调用restfull
* 接口的方法。例如上面代码可以定义一个调用User服务的接口
* 属性name用于指定要调用的服务提供者的应用名称，实际上就越是服务ID,其在服务提供者应用的
* application.yml中通过spring.application.name来定义
* 当调用接口UserClient的hello()方法时，实际上相当于调用User服务的/user/sayHi接口
*
* */
}
