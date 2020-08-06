package com.nacos.cloud.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "nacos-provider-service")
public interface NacosServiceApi {
   @GetMapping(value = "/echo/{msg}")
   String echo(@PathVariable("msg")String msg);
}
