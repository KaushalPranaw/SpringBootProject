package com.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.CourseDao;
import com.app.pojos.Course; 

@Service
public class CourseService {

	
	@Autowired
	private CourseDao dao;
	
	 
	
	public List<Course> getAllCourses(int id)//List return me apne ap json me convert kr deta h bcz of rest controller
	{
		
		//return (ArrayList<Topic>)dao.findAll();
		
		//or
		
		List<Course> courses=new ArrayList<>();
		dao.findAll().forEach(courses::add);
		return courses;
	}
	
	public Course getCourseById(int id)
	{
		 return dao.findById(id).orElse(null);
		
	}
	
	public void addCourse(Course course)
	{
		dao.save(course);
	}

	public void updateCourse(int id, Course course) {
		dao.save(course);
		
	}

	public void deleteCourse(int id) {
		dao.deleteById(id);
	}
}
