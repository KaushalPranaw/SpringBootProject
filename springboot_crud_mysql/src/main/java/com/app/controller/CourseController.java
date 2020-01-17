package com.app.controller;
 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Course;
import com.app.pojos.Topic;
import com.app.service.CourseService;

@RestController
public class CourseController {
	
	@Autowired  //for DI
	private CourseService service;

	@RequestMapping("/topics/{id}/courses")
	public List<Course> getAllTopics(@PathVariable int id)//List return me apne ap json me convert kr deta h bcz of rest controller
	{
		return  service.getAllCourses(id);
	}
	
	@RequestMapping("/topics/{id1}/courses/{courseid}")
	public Course getCourseById(@PathVariable int courseid)
	{
		return service.getCourseById(courseid);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/topics/{id}/courses")
	public void addCourse(@RequestBody Course course)
	{
		service.addCourse(course);
		 
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/topics/{id}")
	public void updateTopic(@RequestBody Course course,@PathVariable int id)
	{
		service.updateCourse(id,course);
		 
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/topics/{id}")
	public void deleteTopic(@PathVariable int id)
	{
		service.deleteCourse(id);
		 
	}
}
