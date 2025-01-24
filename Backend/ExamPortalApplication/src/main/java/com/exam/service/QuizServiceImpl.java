package com.exam.service;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.entity.Category;
import com.exam.entity.Question;
import com.exam.entity.Quiz;
import com.exam.repo.CategoryRepo;
import com.exam.repo.QuizRepo;

import io.jsonwebtoken.lang.Collections;

@Service
public class QuizServiceImpl implements QuizService {

	@Autowired
	private QuizRepo quizRepo;
	@Autowired
	private CategoryRepo categoryRepo;
	
	

	@Override
	public Quiz addQuiz(Quiz quiz) {
        // Ensure the category is linked
        if (quiz.getCategory() == null || quiz.getCategory().getId() == null) {
            throw new IllegalArgumentException("Category is required");
        }

        return this.quizRepo.save(quiz);
    }


	@Override
	public void deleteQuiz(Long id) {

//		Optional<Quiz> ans = this.quizRepo.findById(id);
//		if (ans.isPresent()) {
//			this.quizRepo.delete(ans.get());
//		}
		
		this.quizRepo.deleteById(id);
		

	}

	@Override
	public Quiz update(Quiz q) {

//		Optional<Quiz> ans = this.quizRepo.findById(id);
//		Quiz q1 = ans.get();
//		q1.setCategory(q.getCategory());
//		q1.setActive(q.isActive());
//		q1.setDescription(q.getDescription());
//		q1.setMaxMarks(q.getMaxMarks());
//		q1.setNoOfQuestion(q.getNoOfQuestion());
//		q1.setTitle(q.getTitle());
//		return this.quizRepo.save(q1);
		return this.quizRepo.save(q);

	}

	@Override
	public Quiz getQuizById(Long id) {
		Optional<Quiz> ans = this.quizRepo.findById(id);
		return ans.get();

	}

	@Override
	public Set<Quiz> getAllQuizez() {
		return new LinkedHashSet<Quiz>( this.quizRepo.findAll() );
	}
	
	
	// This method retrieves questions by the quiz ID
    public Set<Question> getQuestionsByQuizId(Long quizId) {
        // Fetch the quiz by ID
        Optional<Quiz> quizOptional = this.quizRepo.findById(quizId);
        
        if (quizOptional.isPresent()) {
            // If the quiz exists, get the questions
            Quiz quiz = quizOptional.get();
            return new HashSet<>(quiz.getQuestions());  // Returning the questions of the quiz
        } else {
        	
        	 Set<Question> ans=new HashSet<Question>();
        	return ans;
            
        }
    }


	@Override
	public List<Quiz> getQuizzesByCategory(Category c) {
		
	List<Quiz> ans=this.quizRepo.findByCategory(c);
		return ans ;
	}


	


    
	

}
