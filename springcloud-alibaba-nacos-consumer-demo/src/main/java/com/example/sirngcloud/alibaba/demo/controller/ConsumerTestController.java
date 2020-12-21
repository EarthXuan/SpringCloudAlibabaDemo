package com.example.sirngcloud.alibaba.demo.controller;

import com.example.sirngcloud.alibaba.api.NacosProducerApi;
import com.example.sirngcloud.alibaba.demo.service.ProducerFeignClient;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/consumer")
public class ConsumerTestController {
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    LoadBalancerClient loadBalancerClient;
    @GetMapping("test")
    public String test() {
        //获取实例
        ServiceInstance serviceInstance = loadBalancerClient.choose("springcloud-alibaba-nacos-producer-demo");
        //拼装路径
        String url = "http://" + serviceInstance.getServiceId() + ":" + serviceInstance.getPort() + "/producer/test";
        String result = restTemplate.getForObject(url, String.class);
        return result;
    }
    //例子好看点，所以放在这里
    @Autowired
    private ProducerFeignClient producerFeignClient;
    @GetMapping("feignTest")
    public String feignTest() {
        return producerFeignClient.test();
    }

    //例子好看点，所以放在这里
    @DubboReference//旧的@Reference已经被废弃
    private NacosProducerApi nacosProducerApi;
    @GetMapping("dubboTest")
    public String dubboTest() {
        return nacosProducerApi.test();
    }

}
