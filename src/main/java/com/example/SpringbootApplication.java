package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootApplication {

	public static void main(String args[]) {
		SpringApplication.run(SpringbootApplication.class, args);
		
		Thread th = new Thread();
		th.start();
	}
}
