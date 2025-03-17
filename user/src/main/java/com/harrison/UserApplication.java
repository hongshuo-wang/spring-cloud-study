package com.harrison;

/**
 * @description UserApplication
 * @author WangHS
 * @date 2025/3/17 22:45
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.RouterFunctions;
import org.springframework.web.servlet.function.ServerResponse;

/**
 * @author WangHS
 * @date 2025/3/17 22:45
 */
@SpringBootApplication
public class UserApplication {
	@Bean
	public RouterFunction<ServerResponse> user() {
		return RouterFunctions.route().GET("/test", request -> {
			return ServerResponse.ok().body("Hello, User!");
		}).build();
	}

	public static void main(String[] args) {
		SpringApplication.run(UserApplication.class, args);
	}
}
