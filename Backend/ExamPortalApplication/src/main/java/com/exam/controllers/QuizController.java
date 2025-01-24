package com.exam.controllers;

import java.util.HashSet;
import java.util.List;
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

import com.exam.entity.Category;
import com.exam.entity.Question;
import com.exam.entity.Quiz;
import com.exam.service.CategoryService;
import com.exam.service.QuizService;

@RestController
@RequestMapping("/quiz")
@CrossOrigin("*")
public class QuizController {

    @Autowired
    private QuizService quizService;
    @Autowired
    private CategoryService categoryService;
    
    
    
    @GetMapping("/category/{id}" )
    public ResponseEntity<List<Quiz>> getQuizzezByCategory(@PathVariable Long id)
    {
    	Category c=new Category();
    	c.setId(id);
    	return ResponseEntity.ok( this.quizService.getQuizzesByCategory(c));
    	
    }
    

    @GetMapping("/{id}")
    public ResponseEntity<Quiz> getQuiz(@PathVariable Long id) {
        Quiz quiz = quizService.getQuizById(id);
        
        		return ResponseEntity.ok(quiz);
    }

    @GetMapping("/")
    public ResponseEntity<Set<Quiz>> getAllQuizzes() {
        return ResponseEntity.ok(quizService.getAllQuizez());
    }

    @PostMapping("/")
    public ResponseEntity<?> createQuiz(@RequestBody Quiz quiz) {
        return ResponseEntity.ok(quizService.addQuiz(quiz));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Quiz> updateQuiz(@RequestBody Quiz quiz) {
        return ResponseEntity.ok(quizService.update(quiz));
    }

    @DeleteMapping("/{qid}")
    public void deleteQuiz(@PathVariable Long qid) {
        quizService.deleteQuiz( qid);
        
    }

    
    
    //localhost:8080/quiz/1/questions
    @GetMapping("/{id}/questions")
    public ResponseEntity<Set<Question>> getQuestionsByQuizId(@PathVariable Long id) {
        Set<Question> questions = quizService.getQuestionsByQuizId(id);
        return ResponseEntity.ok(questions);
    }
}
