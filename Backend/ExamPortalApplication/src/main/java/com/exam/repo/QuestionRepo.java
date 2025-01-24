package com.exam.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exam.entity.Question;
import com.exam.entity.Quiz;

@Repository
public interface QuestionRepo extends JpaRepository<Question, Long> {

	public List<Question> findByQuiz(Quiz q);
	
	
}
