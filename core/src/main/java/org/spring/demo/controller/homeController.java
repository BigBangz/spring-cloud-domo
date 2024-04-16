package org.spring.demo.controller;

import org.spring.demo.entity.Account;
import org.spring.demo.service.AccountApplicationService;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import javax.websocket.server.PathParam;

/**
 * @author bigbangz.github.io
 * @date 2024/4/1 15:07
 */
@RestController
@CacheConfig(cacheNames = "resource.account")
public class homeController {

    @GetMapping("/home")
    public String home() {
        return "open home!";
    }

    @Resource
    private AccountApplicationService service;

    /**
     * 根据用户名称获取用户详情
     */
    @GetMapping(value = "/{username}")
    public Account getUser(@PathParam("username") String username) {
        return service.findAccountByUsername(username);
    }

    /**
     * 创建新的用户
     */
    @PostMapping(value = "/createUse")
    @ResponseBody
    public Account createUser(@RequestBody @Valid Account user) {
        service.createAccount(user);
        return user;
    }

    /**
     * 更新用户信息
     */
    @PutMapping("/update")
    @CacheEvict(key = "#user.username")
    @ResponseBody
    public Object updateUser(@RequestBody @Valid Account user) {
        service.updateAccount(user);
        return user;
    }

}
