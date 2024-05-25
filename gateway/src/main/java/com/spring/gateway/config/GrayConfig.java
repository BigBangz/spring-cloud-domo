package com.spring.gateway.config;

import com.netflix.loadbalancer.IRule;
import com.spring.gateway.filter.GrayByVersionRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 灰度全局配置
 * @author bigbangz.github.io
 * @date 2024/5/25 11:54
 */
@Configuration
public class GrayConfig {
    @Bean
    public IRule globalConfig() {
        // 根据权重的规则
        // return new ArtisanWeightedRule();

        // 同集群优先调用规则
        // return new SameClusterPriorityRule();

        // 金丝雀版本权重负载均衡策略
        return new GrayByVersionRule();
    }
}
