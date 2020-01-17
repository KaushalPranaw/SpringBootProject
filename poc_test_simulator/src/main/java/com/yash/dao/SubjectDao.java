package com.yash.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yash.pojos.Subject;

@Repository
public interface SubjectDao extends JpaRepository<Subject, Integer> {

	Subject findBySubjectId(int id);
}
