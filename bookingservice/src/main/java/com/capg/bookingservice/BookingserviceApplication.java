package com.capg.bookingservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@SuppressWarnings("deprecation")
@SpringBootApplication
@EnableEurekaClient
@ComponentScan(basePackages = "com.capg.controller")
@ComponentScan(basePackages ="com.capg.service")
@ComponentScan(basePackages ="com.capg.transformer")
@ComponentScan(basePackages ="com.capg.entity")
@EnableMongoRepositories("com.capg.repository")
@ComponentScan(basePackages ="com.capg.dto")
public class BookingserviceApplication {

	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate() {
		HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory();
		clientHttpRequestFactory.setConnectTimeout(3000);
		return new RestTemplate(clientHttpRequestFactory);
	}
	public static void main(String[] args) {
		SpringApplication.run(BookingserviceApplication.class, args);
	}

}