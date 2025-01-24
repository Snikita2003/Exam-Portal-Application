package com.exam.entity;

import java.util.LinkedHashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String title;
	private String description;

	// one category canstore multiple quizez;
	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
//	@JsonIgnore
	private Set<Quiz> quizzes = new LinkedHashSet<Quiz>();

	public Long getId() {
		return id;
	}

	public Category(Long id, String title, String description, Set<Quiz> quizzes) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.quizzes = quizzes;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Set<Quiz> getQuizzes() {
		return quizzes;
	}

	public void setQuizzes(Set<Quiz> quizzes) {
		this.quizzes = quizzes;
	}

	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

}
