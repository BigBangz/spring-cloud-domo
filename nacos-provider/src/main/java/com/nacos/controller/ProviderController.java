package com.nacos.controller;

import com.nacos.service.EchoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ProviderController {

    @GetMapping(value = "/echo/{string}")
    public String echo(@PathVariable String string) {
        return string;
    }
 }