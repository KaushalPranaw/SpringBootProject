package com.yash.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yash.pojos.Question;
import com.yash.pojos.Subject;
import com.yash.service.QuestionService;


@RestController
@RequestMapping("/question")
@CrossOrigin(origins = "http://localhost:4200")
public class QuestionController {
	
	@Autowired
	private QuestionService questionService;
	
	@GetMapping("/hello")
	public String hello() {
		return "Hello User";
		
	}
	//------------------------------Question-------------------------------------------------
	@GetMapping("/all/{tid}")
	public List<Question> findAll(@PathVariable("tid") int tid) {
		return questionService.findAll(tid);
	}
	
	@GetMapping("/findQuestion/{qid}")
	public Question findByQId(@PathVariable("qid") int qid)
	{
		return questionService.findByQId(qid);
	}
	
	@PostMapping("/saveQuestion/{tid}")
	public String save(@RequestBody Question question,@PathVariable("tid") int tid)
	{
		System.out.println("AAAAAAAAAAAAAAAAAAAAAAAA");
		questionService.saveQuestion(question,tid);
		return "saved with id "+question.getQuestionId();
	}
	
	@PutMapping("/updateQuestion/{tid}/{qid}")
	public String updateQuestion(@RequestBody Question question,@PathVariable("tid") int tid,@PathVariable("qid") int qid)
	{
		System.out.println("tid*"+tid);
		System.out.println(question);
		System.out.println(qid);
		question.setQuestionId(qid);
		System.out.println(question);
		questionService.updateQuestion(question, tid);
		return "question updated with id "+question.getQuestionId();
	}
	
	@DeleteMapping("/deleteQuestion/{tid}/{qid}")
	public String deleteQuestion(@PathVariable("tid") int tid,@PathVariable("qid") int qid)
	{
		questionService.deleteQuestion(tid, qid);
		return "question deleted with id "+qid;
	}
}
