package org.spring.demo.service;

import org.spring.demo.annotation.AccountRepository;
import org.spring.demo.entity.Account;
import org.spring.demo.util.Encryption;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.UUID;


/**
 * 用户资源的应用服务接口
 *
 * @author bigbangz.github.io
 * @date 2024/4/16 15:45
 **/
@Component
public class AccountApplicationService {

    @Resource
    private AccountRepository repository;

    @Resource
    private Encryption encoder;

    public void createAccount(Account account) {
        account.setPassword(encoder.encode(account.getPassword()));
        UUID uuid = UUID.randomUUID();
        account.setId(uuid.getMostSignificantBits() ^ uuid.getLeastSignificantBits());
        repository.save(account);
    }

    public Account findAccountByUsername(String username) {
        return repository.findByUsername(username);
    }

    public void updateAccount(Account account) {
        repository.updateData(account.getUsername(), account);
    }

}
