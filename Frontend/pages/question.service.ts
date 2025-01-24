import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import baseUrl from '../services/helper';

@Injectable({
  providedIn: 'root'
})
export class QuestionService {

  constructor(private h:HttpClient) { }


  // get questions according to id,title of quiz.
  public getQuestionsofQuiz( id1:any)
  {
    return this.h.get(`${baseUrl}/quiz/${id1}/questions`);
  }


  //add question
  public addQuestions(question:any)
  {
    return this.h.post(`${baseUrl}/question/`,question);
  }

  //get questions by quiz-id from quiz;
  public getQuestionsByQuizId(qid:any)
  {
      return this.h.get(`${baseUrl}/quiz/${qid}/questions`);
  }


}
