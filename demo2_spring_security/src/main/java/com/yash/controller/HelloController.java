package com.yash.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@GetMapping("/hello")
	public String greeting()
	{
		System.out.println("After Login");
		return "Hello Raj";
	}
}
