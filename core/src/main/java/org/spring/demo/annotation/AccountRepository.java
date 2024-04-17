package org.spring.demo.annotation;

import lombok.extern.slf4j.Slf4j;
import org.spring.demo.entity.Account;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;



/**
 * 用户对象数据仓库
 *
 * @author bigbangz.github.io
 * @date 2024/4/3 16:23
 **/
@CacheConfig(cacheNames = "repository.account")
@Service
@Slf4j
public class AccountRepository{

    @Cacheable(key = "#account.username",value = "repository.account")
    public Account save(Account account) {
        log.info("新增成功：{}", account.toString());
        return account;
    }

    @Cacheable(value = "repository.account", key = "#username")
    public Account findByUsername(String username) {
        log.info("查询{}成功", username);
        return null;
    }

    @CacheEvict(value = "repository.account", key = "#username")
    public void deleteData(String username) {
        log.info("执行{}删除数据的逻辑...", username);
    }

    @CachePut(value = "repository.account", key = "#username")
    public Account updateData(String username, Account updatedData) {
        log.info("执行{}更新数据的逻辑...", username);
        return updatedData;
    }

    // todo
    public boolean existsById(Long id) {
        return true;
    }

    // todo
    public boolean existsByUsernameOrEmailOrTelephone(Account account) {
        return true;
    }
}
