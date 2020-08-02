package com.nacos.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface EchoService {
     @GetMapping(value = "/echo/{str}")
     String echo(@PathVariable("str") String str);
 }