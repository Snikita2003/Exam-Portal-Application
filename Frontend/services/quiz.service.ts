import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import baseUrl from './helper';

@Injectable({
  providedIn: 'root'
})
export class QuizService {

  constructor(private http:HttpClient) { }

  //get all quiz
  public getQuizzez()
  {
     return this.http.get(`${baseUrl}/quiz/`);
  }

  // add new quiz
  public addQuiz(quiz:any)
  {
      return this.http.post(`${baseUrl}/quiz/`,quiz);
  }

  //delete quiz by id.
  public deleteQuiz(qid:number)
  {
      return this.http.delete(`${baseUrl}/quiz/${qid}`);
  }
  
  //get quizzes by category
  public getQuizzesBycategory(id:any)
  {
    return this.http.get(`${baseUrl}/quiz/category/${id}`);
  }

  // get quiz by quiz-id
  public getQuizById(qid:any)
  {
    return this.http.get(`${baseUrl}/quiz/${qid}`);
  }

  
  
  

}
