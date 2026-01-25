package com.registery.eurekaServiceRegistery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServiceRegisteryApplication {
	public static void main(String[] args) {
		SpringApplication.run(EurekaServiceRegisteryApplication.class, args);
	}

}
