package com.app.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.demo.dao.CustomerDao;
import com.app.demo.model.Customer;

@Controller
public class CustomerController {

	@Autowired
	CustomerDao dao;
	
	@RequestMapping("/")
	public String home()
	{
		System.out.println("home");
		return "home.jsp";
	}
	
	@RequestMapping("/addCustomer")
	public String addCustomer(Customer c)
	{
		dao.save(c);
		return "home.jsp";
	}
	
	@RequestMapping("/getCustomer")
	public ModelAndView getCustomer(@RequestParam int id)
	{
		ModelAndView mv=new ModelAndView("showCustomer.jsp");
		Customer c=dao.findById(id).orElse(new Customer());
		mv.addObject(c);
		return mv;
	}
	@RequestMapping("/showCustomer")
	public String showCustomer()
	{
		System.out.println("show");
		return "showCustomer.jsp";
	}
}
