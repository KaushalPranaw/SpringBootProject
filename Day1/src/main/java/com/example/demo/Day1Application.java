package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Day1Application {

	public static void main(String[] args) {
	ConfigurableApplicationContext context= SpringApplication.run(Day1Application.class, args);
	
		 Customer c=context.getBean(Customer.class);
		 c.show();
		 
		 
	}

}
