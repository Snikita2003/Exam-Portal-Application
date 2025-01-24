package com.exam.controllers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.entity.Category;
import com.exam.entity.Quiz;
import com.exam.service.CategoryService;

import jakarta.annotation.Resource;
import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/category")
@CrossOrigin("*")
public class CategoryController {

	
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("/{id}")
	public ResponseEntity<Category> getCategory(@PathVariable Long id)
	{
		return ResponseEntity.ok( this.categoryService.getCategory(id) );
		
	}
	
	
	@GetMapping("/")
	public List<Category> getAllCategories()
	{
		List<Category> categories = new ArrayList<>(this.categoryService.getAllCategories());
	    return categories;
		
	}
	
	
	
	@PostMapping("/")
    public ResponseEntity<Category> createCategory(@RequestBody Category c) {
        Category cat = this.categoryService.createCategory(c);
        return ResponseEntity.ok(cat);
    }
	
	
	@PutMapping("/{id}")
	public ResponseEntity<Category> updateCategory(@PathVariable Long id, @RequestBody Category c)
	{
		Category cat=	this.categoryService.updateCategory(id, c);
		return ResponseEntity.ok( cat );

	}
	
	@DeleteMapping("/{id}")
	public void  updateCategory(@PathVariable Long id )
	{
		this.categoryService.deleteCategory(id);
	}
	
	
	
	//  category/{id}/quizzes
	@GetMapping("/{id}/quizzes")
	public Set<Quiz> getQuizzesByCategory(@PathVariable Long id )
	{
		return this.categoryService.getQuizzesByCategoryId(id);
	}
	
	
	
	
	
	
	
	
	
	
	
}






















