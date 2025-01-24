import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import baseUrl from '../services/helper';

@Injectable({
  providedIn: 'root'
})
export class QuizserviceService {

  constructor(private htttp:HttpClient) { }

  // get/load all quiz from backend/server.
  public getQuizzes():Observable<any>{
    return this.htttp.get(`${baseUrl}/quiz/`);
  }

  

}
