package org.spring.demo.controller;

import org.spring.demo.annotation.validation.group.AddGroup;
import org.spring.demo.annotation.validation.group.UpdateGroup;
import org.spring.demo.entity.Account;
import org.spring.demo.service.AccountApplicationService;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.groups.Default;
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
    // 不要漏掉默认分组Default.class，否则就只会校验groups
    public Account createUser(@RequestBody @Validated({AddGroup.class, Default.class}) Account user) {
        service.createAccount(user);
        return user;
    }

    /**
     * 更新用户信息
     */
    @PutMapping("/update")
    @CacheEvict(key = "#user.username")
    @ResponseBody
    public Object updateUser(@RequestBody @Validated({UpdateGroup.class, Default.class}) Account account) {
        service.updateAccount(account);
        return account;
    }

}
