package com.exam.service;

import java.util.List;
import java.util.Set;

import com.exam.entity.Category;
import com.exam.entity.Question;
import com.exam.entity.Quiz;

public interface QuizService {
	
	
	public Quiz addQuiz(Quiz q);
	public void deleteQuiz(Long id);
	public Quiz getQuizById(Long id);
	public Quiz update(Quiz q);
	public Set<Quiz> getAllQuizez();
	public Set<Question> getQuestionsByQuizId(Long quizId);
	public List<Quiz> getQuizzesByCategory(Category c);
	
	
	
	
	
	
	
	

}
