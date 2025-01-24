package com.exam.service;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.entity.Category;
import com.exam.entity.Quiz;
import com.exam.repo.CategoryRepo;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepo categoryRepo;

	@Override
	public Category createCategory(Category c) {

		return this.categoryRepo.save(c);

	}

	@Override
	public Category getCategory(Long id) {
		Optional<Category> caOptional = this.categoryRepo.findById(id);

		if (caOptional.isPresent()) {
			return caOptional.get();
		}
		return null;

	}

	@Override
	public void deleteCategory(Long id) {

//		Optional<Category> caOptional = this.categoryRepo.findById(id);
//		if (caOptional.isPresent()) {
//			this.categoryRepo.delete(caOptional.get());
//		}
		Category c=new Category();
		c.setId(id);
		this.categoryRepo.delete(c);
		

	}

	@Override
	public Set<Category> getAllCategories() {

		return new LinkedHashSet<>(categoryRepo.findAll());
	}

	@Override
	public Category updateCategory(Long id, Category c) {

//		Optional<Category> caOptional = this.categoryRepo.findById(id);
//
//		Category ans = caOptional.get();
//		ans.setTitle(c.getTitle());
//		ans.setDescription(c.getDescription());
		
		return this.categoryRepo.save(c);
		
	}

	@Override
	// get quizzes by categoryId
	public Set<Quiz> getQuizzesByCategoryId(Long lid) {
		
	Optional<Category> c=	this.categoryRepo.findById(lid);
	if( c.isPresent())
	{
		Category cat= c.get();//all categories.
		Set<Quiz> ans=	cat.getQuizzes();
		return new HashSet<>(ans );
		
		
	}
		Set<Quiz> ans=new HashSet<Quiz>();
		return ans;
	}

	

}
