package com.alibaba.cloud.nacos;/*
 * Copyright 2013-2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication(scanBasePackages={"com.netflix.client.config.IClientConfig"})
@EnableDiscoveryClient
public class NacosProviderServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(NacosProviderServerApplication.class, args);
	}

//	@RestController
//	public class EchoController {
//		@GetMapping(value = "/echo/{string}")
//		public String echo(@PathVariable String string) {
//			return "Hello Nacos Discovery " + string;
//		}
//	}
}