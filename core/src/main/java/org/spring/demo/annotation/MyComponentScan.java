package org.spring.demo.annotation;

import java.lang.annotation.*;

/**
 * 自定义包扫描器
 * @author bigbangz.github.io
 * @date 2024/4/3 16:17
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
public @interface MyComponentScan {
    /**
     * 包路径名称
     * @return
     */
    String[] value() default {};
}
