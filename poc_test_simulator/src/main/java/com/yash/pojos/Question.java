package com.yash.pojos;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Question {

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + questionId;
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
		Question other = (Question) obj;
		if (questionId != other.questionId)
			return false;
		return true;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int questionId;
	private String questionName;
	private String option_1;
	private String option_2;
	private String option_3;
	private String option_4;
	private String correct_answer;

	@JsonBackReference
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "t_id")
	private Test test;

	public Question() {
		// TODO Auto-generated constructor stub
		System.out.println("In const of " + getClass().getName());
	}

	public Question(int questionId, String questionName, String option_1, String option_2, String option_3,
			String option_4, String correct_answer, Test test) {
		super();
		this.questionId = questionId;
		this.questionName = questionName;
		this.option_1 = option_1;
		this.option_2 = option_2;
		this.option_3 = option_3;
		this.option_4 = option_4;
		this.correct_answer = correct_answer;
		this.test = test;
	}

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public String getQuestionName() {
		return questionName;
	}

	public void setQuestionName(String questionName) {
		this.questionName = questionName;
	}

	public String getOption_1() {
		return option_1;
	}

	public void setOption_1(String option_1) {
		this.option_1 = option_1;
	}

	public String getOption_2() {
		return option_2;
	}

	public void setOption_2(String option_2) {
		this.option_2 = option_2;
	}

	public String getOption_3() {
		return option_3;
	}

	public void setOption_3(String option_3) {
		this.option_3 = option_3;
	}

	public String getOption_4() {
		return option_4;
	}

	public void setOption_4(String option_4) {
		this.option_4 = option_4;
	}

	public String getCorrect_answer() {
		return correct_answer;
	}

	public void setCorrect_answer(String correct_answer) {
		this.correct_answer = correct_answer;
	}

	public Test getTest() {
		return test;
	}

	public void setTest(Test test) {
		this.test = test;
	}

	@Override
	public String toString() {
		return "Question [questionId=" + questionId + ", questionName=" + questionName + ", option_1=" + option_1
				+ ", option_2=" + option_2 + ", option_3=" + option_3 + ", option_4=" + option_4 + ", correct_answer="
				+ correct_answer + "]";
	}

}
