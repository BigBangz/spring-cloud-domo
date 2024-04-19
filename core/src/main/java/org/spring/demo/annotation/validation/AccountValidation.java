package org.spring.demo.annotation.validation;
import org.spring.demo.annotation.AccountRepository;
import org.spring.demo.entity.Account;

import javax.annotation.Resource;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.annotation.Annotation;
import java.util.function.Predicate;

/**
 * 用户对象校验器
 * <p>
 * 如，新增用户时，判断该用户对象是否允许唯一，在修改用户时，判断该用户是否存在
 *
 * @author bigbangz.github.io
 * @date 2024/4/3 16:17
 **/
public class AccountValidation<T extends Annotation> implements ConstraintValidator<T, Account> {

    @Resource
    protected AccountRepository repository;

    protected Predicate<Account> predicate = c -> true;

    @Override
    public boolean isValid(Account value, ConstraintValidatorContext context) {
        return repository == null || predicate.test(value);
    }

    public static class ExistsAccountValidator extends AccountValidation<ExistsAccount> {
        public void initialize(ExistsAccount constraintAnnotation) {
            predicate = c -> repository.existsById(c.getId());
        }
    }

    public static class UniqueAccountValidator extends AccountValidation<UniqueAccount> {
        public void initialize(UniqueAccount constraintAnnotation) {
            System.out.println("初始化");
            predicate = c -> !repository.existsByUsernameOrEmailOrTelephone(c);
        }
    }
}
