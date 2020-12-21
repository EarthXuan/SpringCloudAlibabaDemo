package com.example.sirngcloud.alibaba.demo.service;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "springcloud-alibaba-nacos-producer-demo")
public interface ProducerFeignClient {
    @GetMapping("/producer/test")
    String test();
}
