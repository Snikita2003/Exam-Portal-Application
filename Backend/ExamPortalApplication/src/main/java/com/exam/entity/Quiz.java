package com.exam.entity;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Quiz {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long qid;
	private String title;
	private String description;

	private String maxMarks;
	private String noOfQuestion;
	private boolean active = false;

	// multiple quizez ek category madhe asu shakte.
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JsonIgnore
	//@JoinColumn(name="category_id",nullable = false)
	private Category category;

	// quiz to questio.
	@OneToMany(mappedBy = "quiz", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	// one quiz has many questions;
	@JsonIgnore
	private Set<Question> questions = new HashSet<Question>();

	
	public Quiz() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Quiz(Long qid, String title, String description, String maxMarks, String noOfQuestion, boolean active,
			Category category, Set<Question> questions) {
		super();
		this.qid = qid;
		this.title = title;
		this.description = description;
		this.maxMarks = maxMarks;
		this.noOfQuestion = noOfQuestion;
		this.active = active;
		this.category = category;
		this.questions = questions;
	}
	
	public Quiz(Long qid, String title, String description, String maxMarks, String noOfQuestion, boolean active,
			Category category) {
		super();
		this.qid = qid;
		this.title = title;
		this.description = description;
		this.maxMarks = maxMarks;
		this.noOfQuestion = noOfQuestion;
		this.active = active;
		this.category = category;
		
	}

	public Long getQid() {
		return qid;
	}

	public void setQid(Long qid) {
		this.qid = qid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMaxMarks() {
		return maxMarks;
	}

	public void setMaxMarks(String maxMarks) {
		this.maxMarks = maxMarks;
	}

	public String getNoOfQuestion() {
		return noOfQuestion;
	}

	public void setNoOfQuestion(String noOfQuestion) {
		this.noOfQuestion = noOfQuestion;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Set<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(Set<Question> questions) {
		this.questions = questions;
	}

}
