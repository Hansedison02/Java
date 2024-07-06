package com.cvct.cvctwebsite;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@ComponentScan("com.cvct.cvctwebsite")
@EnableMongoRepositories(basePackages = "com.cvct.cvctwebsite.data")
public class CvctwebsiteApplication {

	public static void main(String[] args) {
		SpringApplication.run(CvctwebsiteApplication.class, args);
	}
	
}
