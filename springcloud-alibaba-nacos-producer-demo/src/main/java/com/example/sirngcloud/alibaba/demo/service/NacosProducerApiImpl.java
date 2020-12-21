package com.example.sirngcloud.alibaba.demo.service;

import com.example.sirngcloud.alibaba.api.NacosProducerApi;
import org.apache.dubbo.config.annotation.DubboService;

@DubboService//旧的@Service已经废弃掉
//服务端接口实现
public class NacosProducerApiImpl implements NacosProducerApi {
    @Override
    public String test() {
        return "NacosProducerApiImpl";
    }
}
