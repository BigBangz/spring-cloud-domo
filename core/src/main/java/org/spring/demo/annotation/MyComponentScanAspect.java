package org.spring.demo.annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.spring.demo.iocSource.ResourceResolver;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author bigbangz.github.io
 * @date 2024/4/3 16:23
 */
@Aspect
@Component
public class MyComponentScanAspect {

    // 定义切点，拦截所有Controller类的所有方法
    @Pointcut("execution(* org.spring.demo.controller.*.*(..))")
    public void controllerMethods() {}

    // 定义前置通知，在目标方法执行前执行
    @Before("controllerMethods()")
    public void beforeControllerMethod() {
        System.out.println("Before controller method execution");

    }

    // TODO 自定义注解扫描待完成
    @Around("@annotation(myComponentScan)")
    public Object componentScan(ProceedingJoinPoint joinPoint, MyComponentScan myComponentScan) throws Throwable {
        String[] values = myComponentScan.value();
        try {
            for (String value : values) {
                System.err.println("[MyComponentScan:] " + value);
                ResourceResolver rr = new ResourceResolver(value);
                List<String> classList = rr.scan(res -> {
                    String name = res.getName(); // 资源名称"org/example/Hello.class"
                    if (name.endsWith(".class")) { // 如果以.class结尾
                        // 把"org/example/Hello.class"变为"org.example.Hello":
                        return name.substring(0, name.length() - 6).replace("/", ".").replace("\\", ".");
                    }
                    // 否则返回null表示不是有效的Class Name:
                    return null;
                });
            }
            return joinPoint.proceed();
        } finally {
            System.err.println("[MyComponentScan] " + values);
        }
    }
}
