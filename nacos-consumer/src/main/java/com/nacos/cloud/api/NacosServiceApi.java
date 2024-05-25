package com.nacos.cloud.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface NacosServiceApi {
   @GetMapping(value = "/echo/{msg}")
   String echo(@PathVariable("msg")String msg);
}
