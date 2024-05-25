package com.nacos.cloud.controller;

import com.nacos.cloud.bean.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class ProviderController {

    @Value("${server.port}")
    private String serverPort;

    @Value("${spring.application.name}")
    private String serverName;

    @GetMapping("/echo")
    public String echo() {
        return "Hello " + serverName + " " + serverPort;
    }

    @PostMapping("/query")
    public User queryInfo(@RequestBody User user) {
        log.info(user.toString());
        return user;
    }
 }