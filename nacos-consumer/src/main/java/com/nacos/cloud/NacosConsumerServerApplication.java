package com.nacos.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class NacosConsumerServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(NacosConsumerServerApplication.class, args);
	}

}