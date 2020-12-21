package com.example.sirngcloud.alibaba.demo.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;

@Service
@RefreshScope
public class NacosConfigServiceImpl {
    @Value("${nacos.default-config}")
    private String defaultConfig;

    public String testConfig(){
        return defaultConfig;
    }
}
