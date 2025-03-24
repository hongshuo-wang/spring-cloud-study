package com.harrison;

/**
 * @description GatewayApplication
 * @author WangHS
 * @date 2025/3/8 20:18
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.reactive.ReactorLoadBalancerExchangeFilterFunction;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * @author WangHS
 * @date 2025/3/8 20:18
 */
@SpringBootApplication
public class GatewayApplication {
	@Bean
	public WebClient webClient(ReactorLoadBalancerExchangeFilterFunction lb) {
		return WebClient.builder()
				.filter(lb)
				.build();
	}
	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}
}
