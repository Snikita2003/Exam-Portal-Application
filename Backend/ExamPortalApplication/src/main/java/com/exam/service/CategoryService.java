package com.exam.service;

import java.util.List;
import java.util.Set;

import com.exam.entity.Category;
import com.exam.entity.Quiz;

public interface CategoryService {

	
	public Category createCategory(Category c);
	public Category getCategory(Long id);
	public void deleteCategory(Long id);
	public Set<Category> getAllCategories();
	public Category updateCategory(Long id,Category c);
	// get all quizez by category id;
	//category/{id}/quiz
	public Set<Quiz>  getQuizzesByCategoryId(Long lid);
	
	
	
}
