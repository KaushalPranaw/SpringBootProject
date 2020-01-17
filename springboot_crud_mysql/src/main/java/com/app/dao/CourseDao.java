package com.app.dao;

import org.springframework.data.repository.CrudRepository;

import com.app.pojos.Course;

public interface CourseDao extends CrudRepository<Course, Integer> {

}
