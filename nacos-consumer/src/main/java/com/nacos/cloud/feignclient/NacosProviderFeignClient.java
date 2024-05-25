package com.nacos.cloud.feignclient;

import com.nacos.cloud.configuration.NacosProviderFeignConfiguration;
import com.nacos.cloud.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "nacos-provider-service",configuration = NacosProviderFeignConfiguration.class)
public interface NacosProviderFeignClient {
    /**
     * http://nacos-provider-service:8081/echo
     */

    @GetMapping("/echo")
    public String echo();

    @PostMapping("/query")
    public UserDto queryInfo(@RequestBody UserDto user);

}
