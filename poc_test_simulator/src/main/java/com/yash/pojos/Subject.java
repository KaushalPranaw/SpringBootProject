package com.yash.pojos;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Subject {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int subjectId;
	private String subjectName;

	@JsonManagedReference
	@OneToMany(mappedBy = "subject", cascade = CascadeType.ALL)
	private Set<Test> tests;

	public Subject() {
		// TODO Auto-generated constructor stub
		System.out.println("In const of " + getClass().getName());
	}

	public Subject(int subjectId, String subjectName, Set<Test> tests) {
		super();
		this.subjectId = subjectId;
		this.subjectName = subjectName;
		this.tests = tests;
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + subjectId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Subject other = (Subject) obj;
		if (subjectId != other.subjectId)
			return false;
		return true;
	}

	public int getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public Set<Test> getTests() {
		return tests;
	}

	public void setTests(Set<Test> tests) {
		this.tests = tests;
	}

	@Override
	public String toString() {
		return "Subject [subjectId=" + subjectId + ", subjectName=" + subjectName + "]";
	}
	
	public void addTest(Test test)
	{
		this.getTests().add(test);
		test.setSubject(this);
	}
	
	public void deleteTest(Test test)
	{
		this.getTests().remove(test);
		test.setSubject(null);
	}
	
	

}
