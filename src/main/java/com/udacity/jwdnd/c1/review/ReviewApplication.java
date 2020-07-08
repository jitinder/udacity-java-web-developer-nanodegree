package com.udacity.jwdnd.c1.review;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ReviewApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReviewApplication.class, args);
	}

	@Bean
	public String message(){
		return "Hello, Spring!";
	}

//	@Bean
//	public String upperCase(MessageService messageService){
//		System.out.println("Created upperCase");
//		return messageService.toUpperCase();
//	}
//
//	@Bean
//	public String lowerCase(MessageService messageService){
//		System.out.println("Created lowerCase");
//		return messageService.toLowerCase();
//	}
}
