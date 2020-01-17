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

import com.yash.pojos.Subject;
import com.yash.pojos.Test;
import com.yash.service.TestService;

@RestController
@RequestMapping("/test")
@CrossOrigin(origins = "http://localhost:4200")
public class TestController {


	@Autowired
	private TestService testService;

	// ------------------------------Test-------------------------------------------------

	@GetMapping("/all/{sid}")
	public List<Test> findAll(@PathVariable("sid") int sid) {
		return testService.findAll(sid);
	}
	
	@GetMapping("/findTest/{tid}")
	public Test findById(@PathVariable("tid") int tid) {
		return testService.findById(tid);
	}

	@PostMapping("/saveTest/{sid}")
	public String saveTest(@RequestBody Test test, @PathVariable("sid") int sid) {
		testService.saveTest(test, sid);
		return "test saved with id " + test.getTestId();
	}

	@PutMapping("/updateTest/{sid}/{tid}")
	public String updateTest(@RequestBody Test test, @PathVariable("sid") int sid, @PathVariable("tid") int tid) {
		test.setTestId(tid);
		System.out.println(test);
		testService.updateTest(test, sid);
		return "test updated with id " + test.getTestId();
	}

	@DeleteMapping("/deleteTest/{sid}/{tid}")
	public String deleteTest(@PathVariable("sid") int sid, @PathVariable("tid") int tid) {
		testService.deleteTest(sid, tid);
		return "test deleted with id " + tid;
	}

}
