package com.spring.gateway.filter;

import com.alibaba.cloud.nacos.NacosDiscoveryProperties;
import com.alibaba.cloud.nacos.ribbon.NacosServer;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.pojo.Instance;
import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.BaseLoadBalancer;
import com.netflix.loadbalancer.Server;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * @author bigbangz.github.io
 * @date 2024/5/24 17:56
 */
@Slf4j
public class GrayByVersionRule extends AbstractLoadBalancerRule {

    @Autowired
    private NacosDiscoveryProperties nacosProperties;

    private AtomicInteger nextServerCounter;

    public GrayByVersionRule() {
        this.nextServerCounter = new AtomicInteger(0);
    }

    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {

    }

    @Override
    public Server choose(Object o) {
        String clusterName = nacosProperties.getClusterName();
        log.info("当前服务：{}", clusterName);
        try {
            List<Instance> allInstances = getAllInstances(nacosProperties);
            List<Instance> serverList = allInstances.stream().map(service -> {
                String version = service.getMetadata().get("current-version");
                String name = service.getClusterName();
                if (clusterName.equalsIgnoreCase(name) && "V1".equalsIgnoreCase(version)) {
                    return service;
                }
                return null;
            }).filter(Objects::nonNull).collect(Collectors.toList());
            if (!serverList.isEmpty()) {
                // 轮询算法
                int i = incrementAndGetModulo(serverList.size());
                log.info("当前：{}", i);
                return new NacosServer(serverList.get(i));
            }
        } catch (NacosException e) {
            log.error("负载均衡算法选择异常:{}", e);
        }
        return null;
    }

    private int incrementAndGetModulo(int modulo) {
        int current;
        int next;
        do {
            current = this.nextServerCounter.get();
            next = (current + 1) % modulo;
        } while(!this.nextServerCounter.compareAndSet(current, next));

        return next;
    }

    /**
     * 方法实现说明:获取被调用服务的所有实例
     * @param discoveryProperties nacos的配置
     * @return
     * @throws NacosException
     */
    private List<Instance> getAllInstances(NacosDiscoveryProperties discoveryProperties) throws NacosException {

        //第1步:获取一个负载均衡对象
        BaseLoadBalancer baseLoadBalancer = (BaseLoadBalancer) getLoadBalancer();

        //第2步:获取当前调用的微服务的名称
        String invokedSerivceName = baseLoadBalancer.getName();

        //第3步:获取nacos clinet的服务注册发现组件的api
        NamingService namingService = discoveryProperties.namingServiceInstance();

        //第4步:获取所有的服务实例
        List<Instance> allInstance = namingService.getAllInstances(invokedSerivceName);

        return allInstance;
    }

}
