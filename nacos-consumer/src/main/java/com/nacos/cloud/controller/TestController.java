package com.nacos.cloud.controller;

import com.nacos.cloud.feignclient.NacosProviderFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consumer")
public class TestController {

    @Autowired
    private NacosProviderFeignClient nacosProviderFeignClient;

    @GetMapping(value = "/echo")
    public String echo() {
        return nacosProviderFeignClient.echo();
    }

}