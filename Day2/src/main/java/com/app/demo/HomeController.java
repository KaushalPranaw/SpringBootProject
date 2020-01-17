package com.app.demo;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	/*@RequestMapping("home")
	public String home(HttpServletRequest req,HttpServletResponse res) {
		String name=req.getParameter("name");
		System.out.println("Hi "+name);
		HttpSession hs=req.getSession();
		hs.setAttribute("name", name);
		
		return "home";

	}*/
	
	@RequestMapping("home")
	public ModelAndView home(Customer c, HttpSession hs) {
		 
		ModelAndView mw=new ModelAndView();
		mw.addObject("c",c);
		mw.setViewName("home");
		 
		
		return mw;

	}
	
	
}
