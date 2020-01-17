package com.yash.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.yash.pojos.Employee;
import com.yash.service.EmployeeServiceImpl;

@Controller
@RequestMapping("/emp")
public class EmployeeController {

	@Autowired
	private EmployeeServiceImpl service;

	@GetMapping("/list")
	public ModelAndView getAll() {
		ModelAndView mv = new ModelAndView();
		System.out.println(service.findAll());
		mv.addObject("emplist", service.findAll());
		mv.setViewName("/employee/list");
		return mv;
		// return "/employee/list";
	}

	@GetMapping("/add")
	public ModelAndView showAddEmployee() {
		Employee e = new Employee();
		ModelAndView mv = new ModelAndView();
		mv.addObject("employee", e);
		mv.setViewName("/employee/add");
		return mv;
	}

	@PostMapping("/add")
	public String processEmployee(Employee e, RedirectAttributes flashMap) {
		// System.out.println(e);
		flashMap.addFlashAttribute("status", service.addEmployee(e));
		return "redirect:/emp/list";
	}

	@GetMapping("/delete")
	public String deleteEmp(@RequestParam("id") int id, RedirectAttributes flashMap) {
		System.out.println(id);
		flashMap.addFlashAttribute("status", service.deleteEmp(id));
		return "redirect:/emp/list";
	}

	@GetMapping("/update")
	public String showupdateEmp(@RequestParam("id") int id, Model map) {
		Employee e = service.getById(id);
		map.addAttribute("employee", e);
		return "/employee/update";
	}

	@PostMapping("/update")
	public String processupdate(Employee e, RedirectAttributes flashMap) {
		flashMap.addFlashAttribute("status", service.updateEmp(e));
		return "redirect:/emp/list";
	}
}
