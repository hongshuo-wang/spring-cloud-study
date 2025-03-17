package com.harrison.factory;

/**
 * @description HarrisonGatewayFilterFactory
 * @author WangHS
 * @date 2025/3/17 23:15
 */

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.GatewayFilterFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * @author WangHS
 * @date 2025/3/17 23:15
 */
@Component
public class HarrisonGatewayFilterFactory implements GatewayFilterFactory<HarrisonGatewayFilterFactory.Config> {
	@Override
	public GatewayFilter apply(Config config) {
		return (exchange, chain) -> {
			System.out.println("config: " + config.getPrefix());
			System.out.println("HarrisonGatewayFilterFactory");
			return chain.filter(exchange);
		};
	}

	@Override
	public List<String> shortcutFieldOrder() {
		return List.of("prefix");
	}

	@Override
	public Class getConfigClass() {
		return Config.class;
	}

	public static class Config {
		private String prefix;

		public String getPrefix() {
			return prefix;
		}

		public void setPrefix(String prefix) {
			this.prefix = prefix;
		}
	}
}
