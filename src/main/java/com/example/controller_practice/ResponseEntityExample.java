package com.example.controller_practice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResponseEntityExample {

	@GetMapping("/getResponse")
	public String responseEntity(){
		return "Hello world";
	}
	
	@GetMapping("/validage/{age}")
	ResponseEntity<String> age(@PathVariable int age){
		if(age<18){
			//List<Integer> list = new ArrayList<>();
			return new ResponseEntity<>(
					"age should be greater than 18",
					HttpStatus.BAD_REQUEST
					);
		}
		return new ResponseEntity<>(
				"eligible",
				HttpStatus.OK);
	}
}
