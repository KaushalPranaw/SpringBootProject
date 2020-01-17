package com.yash.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.dao.SubjectDao;
import com.yash.dao.TestDao;
import com.yash.pojos.Subject;

@Transactional
@Service
public class SubjectService {

	@Autowired
	SubjectDao subjectDao;
	
	@Autowired
	TestDao testDao;
	
	public List<Subject> findAll() {
		
		List<Subject> subjects=subjectDao.findAll();
		return subjects;
	}
	
	public Subject findBySubjectId(int sid)
	{
		return subjectDao.findBySubjectId(sid);
	}
	
}
