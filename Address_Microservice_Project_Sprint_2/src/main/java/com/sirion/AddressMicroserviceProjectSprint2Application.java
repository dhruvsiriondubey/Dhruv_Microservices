package com.sirion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
public class AddressMicroserviceProjectSprint2Application {

	public static void main(String[] args) {
		SpringApplication.run(AddressMicroserviceProjectSprint2Application.class, args);
	}

}
