package com.example.restful.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestfulServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestfulServerApplication.class, args);
		System.out.println("http://localhost:8080");
	}
}
