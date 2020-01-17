package com.yash.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yash.pojos.Subject;
import com.yash.service.SubjectService;

@RestController
@RequestMapping("/subject")
@CrossOrigin(origins = "http://localhost:4200")
public class SubjectController {

	@Autowired
	private SubjectService subjectService;

	@GetMapping("/all")
	public List<Subject> findAll() {
		return subjectService.findAll();
	}
	
	@GetMapping("/{sid}")
	public Subject findBySubjectId(@PathVariable("sid") int sid)
	{
		return subjectService.findBySubjectId(sid);
	}
}
