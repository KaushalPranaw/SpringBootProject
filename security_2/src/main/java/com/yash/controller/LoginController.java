package com.yash.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

	@GetMapping("/")
	public String get()
	{
		System.out.println("in login page");
		return "hello";
	}
	
	@GetMapping("/welcome")
	public String getLogin()
	{
		System.out.println("in login page");
		return "login";
	}
}
