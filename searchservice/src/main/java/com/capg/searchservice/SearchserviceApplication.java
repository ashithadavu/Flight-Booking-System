package com.capg.searchservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableEurekaClient

@ComponentScan(basePackages = "com.capg.controller")
@ComponentScan(basePackages = "com.capg.service")
@ComponentScan(basePackages ="com.capg.transformer")
@ComponentScan(basePackages ="com.capg.entity")
@EnableMongoRepositories("com.capg.repository")
@ComponentScan(basePackages ="com.capg.dto")
public class SearchserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SearchserviceApplication.class, args);
	}
	
}
