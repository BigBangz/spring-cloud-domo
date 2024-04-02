package org.spring.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author bigbangz.github.io
 * @date 2024/4/1 15:07
 */
@RestController
public class homeController {

    @GetMapping("/home")
    public String home() {
        return "open home!";
    }
}
