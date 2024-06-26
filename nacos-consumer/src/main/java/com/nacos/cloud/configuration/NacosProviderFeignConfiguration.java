package com.nacos.cloud.configuration;

import feign.Logger;
import org.springframework.context.annotation.Bean;

//这里不能增加@Configuration，如果添加了就会变为全局配置文件。
//@Configuration
public class NacosProviderFeignConfiguration {
/**
 * 日志级别
 * 通过源码可以看到日志等级有 4 种，分别是：
 * NONE：不输出日志。
 * BASIC：只输出请求方法的 URL 和响应的状态码以及接口执行的时间。
 * HEADERS：将 BASIC 信息和请求头信息输出。
 * FULL：输出完整的请求信息。
 */
    @Bean
    public Logger.Level level(){
        return Logger.Level.BASIC;
    }

}
