package com.harrison.factory;

/**
 * @description HarrisonRoutePredicateFactory
 * @author WangHS
 * @date 2025/3/17 23:30
 */

import org.springframework.cloud.gateway.handler.predicate.GatewayPredicate;
import org.springframework.cloud.gateway.handler.predicate.RoutePredicateFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import java.util.List;

/**
 * @author WangHS
 * @date 2025/3/17 23:30
 */
@Component
public class HarrisonRoutePredicateFactory implements RoutePredicateFactory<HarrisonRoutePredicateFactory.Config> {

	@Override
	public List<String> shortcutFieldOrder() {
		return List.of("method");
	}

	@Override
	public Class<Config> getConfigClass() {
		return Config.class;
	}

	@Override
	public GatewayPredicate apply(Config config) {
		return new GatewayPredicate() {
			@Override
			public boolean test(ServerWebExchange serverWebExchange) {
				String method = serverWebExchange.getRequest().getMethod().toString();
				return method.equals(config.getMethod());
			}
		};
	}

	public static class Config{
		private String method;

		public String getMethod() {
			return method;
		}

		public void setMethod(String method) {
			this.method = method;
		}
	}
}
