package com.exam.controllers;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.entity.Question;
import com.exam.entity.Quiz;
import com.exam.service.QuestionService;
import com.exam.service.QuizService;


@RestController
@RequestMapping("/question")
@CrossOrigin("*")

public class QuestionController  {
	
	@Autowired
	private QuestionService questionService;
	@Autowired
	private QuizService quizService;
	
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Question> getQuestion(@PathVariable Long id)
	{
		return ResponseEntity.ok( this.questionService.getQuestionById(id)  ) ;
		
	}
	
	
	@GetMapping("/")
	public ResponseEntity<Set<Question>> getAllQuestion()
	{
		Set<Question> categories=new HashSet<Question>();
		
		categories= this.questionService.getAllQuestions();
		
		
		return new ResponseEntity<Set<Question>>(categories,HttpStatus.OK);
		
	}
	
	
	
	@PostMapping("/")
	public ResponseEntity<Question> createQuestion(@RequestBody Question c)
	{
		Question cat=	this.questionService.addQustion(c);
		return ResponseEntity.ok(cat);
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<Question> updateQuestion( @RequestBody Question c)
	{
		Question cat=	this.questionService.update(c);
		return ResponseEntity.ok(cat);
		
	}
	
	@DeleteMapping("/{id}")
	public void  Delete(@PathVariable Long id )
	{
		this.questionService.delete(id);
	}
	
	

	
	
	
	

}
