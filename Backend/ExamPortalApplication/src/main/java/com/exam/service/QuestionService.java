package com.exam.service;

import java.util.Set;

import com.exam.entity.Question;
import com.exam.entity.Quiz;

public interface QuestionService {

	public Question addQustion(Question q);
	public void delete(Long id);
	public Question getQuestionById(Long id);
	public Question update(Question q);
	public Set<Question> getAllQuestions();
	
	
	
	
	
}
