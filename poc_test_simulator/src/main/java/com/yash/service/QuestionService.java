package com.yash.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.dao.QuestionDao;
import com.yash.dao.TestDao;
import com.yash.pojos.Question;
import com.yash.pojos.Test;

@Transactional
@Service
public class QuestionService {

	@Autowired
	private TestDao testDao;
	
	@Autowired
	private QuestionDao questionDao;
	
	public List<Question> findAll(int tid)
	{
		Test t=testDao.findByTestId(tid);
		return new ArrayList<Question>(t.getQuestions());
	}
	
	public Question findByQId(int qid)
	{
		return questionDao.findByQuestionId(qid);
	}
	

	public void saveQuestion(Question question,int tid) {
		Test test=testDao.findByTestId(tid);
		test.addQuestion(question);
		testDao.save(test);
	}

	public void updateQuestion(Question question,int tid) {
		Test test=testDao.findByTestId(tid);
		
		test.addQuestion(question);
		
		/*Set<Question> qSet=new HashSet<>();
		qSet.addAll(test.getQuestions());
		
		Iterator<Question> itr=qSet.iterator();
		while(itr.hasNext())
		{
			Question q=itr.next();
			if(q.getQuestionId()==question.getQuestionId())
				itr.remove();
		}
		qSet.add(question);*/
		//test.setQuestions(qSet);
		//testDao.save(test);
		questionDao.save(question);
		
		
	}

	public void deleteQuestion(int tid, int qid) {
		Test test=testDao.findByTestId(tid);
		Question question=questionDao.findByQuestionId(qid);
		test.deleteQuestion(question);
		questionDao.delete(question);
		
	}

}
