package com.yash;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(value="com.yash")
@SpringBootApplication/*(exclude= {SecurityAutoConfiguration.class})*/
public class Demo2SpringSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(Demo2SpringSecurityApplication.class, args);
		System.out.println("sb security app start................");
	}

}
