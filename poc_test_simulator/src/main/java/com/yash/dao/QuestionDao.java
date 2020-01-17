package com.yash.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yash.pojos.Question;

public interface QuestionDao extends JpaRepository<Question, Integer>{

	Question findByQuestionId(int id);
}
