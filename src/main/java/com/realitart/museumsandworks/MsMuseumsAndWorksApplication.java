package com.realitart.museumsandworks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MsMuseumsAndWorksApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsMuseumsAndWorksApplication.class, args);
	}

}
