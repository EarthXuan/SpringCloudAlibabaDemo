package com.example.sirngcloud.alibaba.demo.controller;

import com.example.sirngcloud.alibaba.demo.service.NacosConfigServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/producer")
@RefreshScope
public class ProducerTestController {

    @GetMapping("test")
    public String test() {
        return "producer test success!";
    }

    //例子好看点，所以放在这里
    @Value("${nacos.default-config}")
    private String defaultConfig;

    //测试自动刷新配置
    @GetMapping("testConfig")
    public String testConfig() {
        return defaultConfig;
    }


    //例子好看点，所以放在这里
    @Autowired
    private NacosConfigServiceImpl nacosConfigService;
    //测试service自动刷新配置
    @GetMapping("/service/testConfig")
    public String testServiceConfig() {
        return defaultConfig;
    }


}
