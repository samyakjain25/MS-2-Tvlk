package com.traveloka.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


@SpringBootApplication
@ComponentScan({"com.traveloka"})
@EntityScan("com.traveloka")
public class Start {
	public static void main(String[] args) {
		SpringApplication.run(Start.class, args);
	}
}
