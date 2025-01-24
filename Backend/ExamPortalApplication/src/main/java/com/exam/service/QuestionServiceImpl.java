package com.exam.service;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.entity.Question;
import com.exam.entity.Quiz;
import com.exam.repo.QuestionRepo;
import com.exam.repo.QuizRepo;

@Service
public class QuestionServiceImpl implements QuestionService {

	
	@Autowired
	private QuestionRepo questionRepo;
	
	
	
	@Override
	public Question addQustion(Question q) {
		return this.questionRepo.save(q);
	}
	

	@Override
	public void delete(Long id) {
		
		Question q=new Question();
		q.setQueid(id);
		this.questionRepo.delete(q);
		
	}

	@Override
	public Question getQuestionById(Long id) {
		
		Optional<Question> ans=	this.questionRepo.findById(id);
		return ans.get();
	}

	
	@Override
	public Question update(Question q) {
		
//		Optional<Question> ans=	this.questionRepo.findById(id);
//		Question que= ans.get();
//		
//		que.setAnswer(q.getAnswer());
//		que.setContent(q.getContent());
//		que.setImage(q.getImage());
//		que.setOption1(q.getOption1());
//		que.setOption2(q.getOption2());
//		que.setOption3(q.getOption3());
//		que.setOption4(q.getOption4());
//		que.setQuiz(q.getQuiz());
		
		return this.questionRepo.save(q);
	}




	


	@Override
	public Set<Question> getAllQuestions() {
		
		return new LinkedHashSet<Question>(this.questionRepo.findAll() );
        
	}



	

	
}








