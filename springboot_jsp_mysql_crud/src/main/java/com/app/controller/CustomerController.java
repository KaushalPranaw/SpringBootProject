package com.app.controller;

import javax.persistence.NoResultException; 
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.pojos.Customer;
import com.app.service.CustomerService;

@Controller
@RequestMapping("/cust")
public class CustomerController {

	@Autowired
	CustomerService service;
	
	@GetMapping(value= {"/","/cust/"})
	public String index()
	{
		return "/index";
	}
	@GetMapping("/login")
	public String showLoginForm()
	{
		System.out.println("in login form");
		 
		return "/customer/login";
	}
	 
	
	@PostMapping("/login")
	// req param name MUST match with method arg name
	public String processLoginForm(@RequestParam String email, @RequestParam String pass, Model map, HttpSession hs) {
		System.out.println("in process login form");
		 Customer c =null;
		try {
			c = service.login(email,pass);
		} catch (NoResultException e) {
			System.out.println("err in customer controller " + e);
			map.addAttribute("status", "Invalid Login , pls retry");
			return "/customer/login";
		}

		// successful login
		// save validated user dtls under session scope
		hs.setAttribute("user_dtls", c);
		// add status in session scope
		hs.setAttribute("status", "Successful Login for " + c.getName());
		// role based authorization
		 
		return "redirect:/cust/list";
	}


	@GetMapping("/register")
	public String showRegistrationForm(Customer c)
	{
		System.out.println("in register form"+c);
		 
		return "/customer/register";
	}
	@PostMapping("/register")
	public String processRegistrationForm(Customer c,RedirectAttributes flashMap)
	{
		System.out.println("in process register form");
		System.out.println(c);
		service.register(c);
		flashMap.addAttribute("status", "registered successfully");
		 
		return "redirect:/cust/login";
	
	}
	
	@GetMapping("/list")
	public String getAllCust(Model map) {
		System.out.println("in list customer...." + service);
		map.addAttribute("allUser", service.getAllCust());
		return "/customer/list";
	}

	// req handling method for deleting vendor dtls
	@GetMapping("/delete")
	public String unsubscribe(@RequestParam int cid, RedirectAttributes flashMap) {
		System.out.println("in delete");
		service.deleteCust(cid);
		flashMap.addFlashAttribute("status","deleted" );
		System.out.println("in un-subscribe");
		return "redirect:/cust/list";
	}
 

	@GetMapping("/update")
	public String showUpdateForm(@RequestParam int cid, Model map) {
		 
		Customer c= service.getCustDetail(cid);
		System.out.println("in show update form " + c);
		 
		map.addAttribute("customer", c);
		return "/customer/update";
	}

	@PostMapping("/update")
	public String processUpdateForm(Customer c, RedirectAttributes flashMap) {
		System.out.println("in process update " + c);
		flashMap.addFlashAttribute("status", service.updateCustomer(c));
		return "redirect:/cust/list";
	}
	
	
	
}
