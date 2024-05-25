package com.spring.sourcecode.multithreading.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author bigbangz.github.io
 * @date 2024/5/21 15:25
 */
@RestController
@RequestMapping("/source-code")
public class ThreadController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/echo")
    public String echo() {
        return "Hello Nacos Discovery: " + serverPort;
    }
}
