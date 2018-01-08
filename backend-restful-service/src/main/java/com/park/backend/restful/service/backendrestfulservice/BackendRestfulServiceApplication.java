package com.park.backend.restful.service.backendrestfulservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class BackendRestfulServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendRestfulServiceApplication.class, args);
	}
}
