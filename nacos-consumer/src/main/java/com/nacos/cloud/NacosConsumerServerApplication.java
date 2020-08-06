package com.nacos.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
//
//@SpringBootApplication(scanBasePackages={"com.netflix.client.config.IClientConfig"})
@SpringBootApplication()
@EnableDiscoveryClient
@EnableFeignClients
public class NacosConsumerServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(NacosConsumerServerApplication.class, args);
	}

}