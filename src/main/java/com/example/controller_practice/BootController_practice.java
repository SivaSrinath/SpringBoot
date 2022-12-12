package com.example.controller_practice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BootController_practice {
	
	//======================================================
	//http://localhost:9090/sub?num1=100&number2=10&number3=5
	
	@GetMapping("sub")
	public int sub (@RequestParam(name = "num1") int number1, @RequestParam int number2,
			@RequestParam(required = false) Integer number3) {
		
		if (number3 != null) {
			return number1 - number2 - number3;
		}
		
		return number1 - number2;
	}
	
	//=============================================================
	// http://localhost:9090/sub/30
	
	@GetMapping("sub/{number}")
	public int addPath(@PathVariable Integer number) {
		return number;
	}
	
	//===========================================================
}
