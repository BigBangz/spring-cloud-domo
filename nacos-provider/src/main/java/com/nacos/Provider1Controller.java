package com.nacos;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Provider1Controller {

    @GetMapping(value = "/echo1/{string}")
    public String echo(@PathVariable String string) {
        return string;
    }
 }