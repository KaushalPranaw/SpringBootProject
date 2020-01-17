package com.yash.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.yash.pojos.Test;

@Repository
public interface TestDao extends JpaRepository<Test, Integer> {

	
//	@Query(value="select t from Test t inner join fetch Subject s where t.subject.subjectId=:sid")
	//List<Test> findAllBySubjectId(int sid);
	
	Test findByTestId(int id);
}
