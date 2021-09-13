package com.daillycodebuffer.cloadgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CloadGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloadGatewayApplication.class, args);
	}

}
