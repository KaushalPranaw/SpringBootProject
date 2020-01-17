package com.yash.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.dao.SubjectDao;
import com.yash.dao.TestDao;
import com.yash.pojos.Subject;
import com.yash.pojos.Test;

@Transactional
@Service
public class TestService {

	@Autowired
	SubjectDao subjectDao;

	@Autowired
	TestDao testDao;
	
	public List<Test> findAll(int sid)
	{
		Subject subject = subjectDao.findBySubjectId(sid);
		return new ArrayList<Test>(subject.getTests());
		
	}

	public Test findById(int tid) {
		return testDao.findByTestId(tid);
	}

	public void saveTest(Test test, int sid) {
		Subject subject = subjectDao.findBySubjectId(sid);
		subject.addTest(test);
		subjectDao.save(subject);
	}

	public void updateTest(Test test, int sid) {
		Subject subject = subjectDao.findBySubjectId(sid);

		Set<Test> testSet = new HashSet<>();
		testSet.addAll(subject.getTests());
		Iterator<Test> itr = testSet.iterator();
		while (itr.hasNext()) {
			Test t = itr.next();
			if (t.getTestId() == test.getTestId()) {
				itr.remove();
			}
		}
		testSet.add(test);
		test.setSubject(subject);

		subject.setTests(testSet);

		subjectDao.save(subject);

	}

	public void deleteTest(int sid, int tid) {
		Subject subject = subjectDao.findBySubjectId(sid);
		Test test = testDao.findOne(tid);
		subject.deleteTest(test);
		testDao.delete(test);
	}

}
