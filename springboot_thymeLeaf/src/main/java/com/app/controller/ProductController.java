package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.app.pojos.Product;
import com.app.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	private ProductService service;
	
	@RequestMapping("/")
	public String viewHomePage(Model map)
	{
		System.out.println("in home page");
		List<Product> listProducts=service.listAll();
		map.addAttribute("listProducts", listProducts);
		return "index";
	}
	@RequestMapping("/thymeleaf")
	public String viewthymeleafPage(Model map)
	{
		System.out.println("in thyme page");
		 
		return "test_thymeleaf";
	}
	@RequestMapping("/new")
	public String showNewProductForm(Model map)
	{
		System.out.println("in new product");
		Product product=new Product();
		map.addAttribute("product", product);
		return "new_product";
	}
	
	@PostMapping("/save")
	public String saveProduct(@ModelAttribute("product") Product product )
	{
		service.save(product);
		return "redirect:/";
	}
	
	@RequestMapping("/edit/{id}")
	public ModelAndView showEditProductForm(@PathVariable(name="id") Long id)
	{
		System.out.println("in edit product with id = "+id);
		ModelAndView mv=new ModelAndView("edit_product");
		Product product=service.get(id);
		mv.addObject("product", product);
		return mv;
	}
	
	@RequestMapping("/delete/{id}")
	public String sdeleteForm(@PathVariable(name="id") Long id)
	{
		System.out.println("in delete product with id = "+id);
		service.delete(id);
		return "redirect:/";
	}
}
