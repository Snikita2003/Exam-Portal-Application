package com.exam.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exam.entity.Category;
import com.exam.entity.Quiz;

@Repository
public interface QuizRepo extends JpaRepository<Quiz, Long>{

	
	public List<Quiz> findByCategory(Category category);
//	public Optional<Category> findCById(Long i);
	
	
}
