package com.yash.pojos;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Test {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int testId;

	private String testName;

	@JsonBackReference
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "s_id")
	private Subject subject;

	@JsonManagedReference
	@OneToMany(mappedBy = "test", cascade = CascadeType.ALL)
	private Set<Question> questions;

	public Test() {
		// TODO Auto-generated constructor stub
		System.out.println("In const of " + getClass().getName());
	}

	public Test(int testId, String testName, Subject subject, Set<Question> questions) {
		super();
		this.testId = testId;
		this.testName = testName;
		this.subject = subject;
		this.questions = questions;
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + testId;
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
		Test other = (Test) obj;
		if (testId != other.testId)
			return false;
		return true;
	}

	public int getTestId() {
		return testId;
	}

	public void setTestId(int testId) {
		this.testId = testId;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public Set<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(Set<Question> questions) {
		this.questions = questions;
	}

	@Override
	public String toString() {
		return "Test [testId=" + testId + ", testName=" + testName + ", subject=" + subject + ", questions=" + questions
				+ "]";
	}
	
	public void addQuestion(Question question)
	{
		this.questions.add(question);
		question.setTest(this);
	}
	
	public void deleteQuestion(Question question)
	{
		this.questions.remove(question);
		question.setTest(null);
	}

}
