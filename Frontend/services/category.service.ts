import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import baseUrl from './helper';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CategoryService {

  constructor(private http:HttpClient
  ) {}


  //load data.
  getCategories(): Observable<any> {
    return this.http.get(`${baseUrl}/category/`);
  }


  // add category data in html.
  addCategoryData(data:any):Observable<any>
  {
      return this.http.post(`${baseUrl}/category/`, data);
  }

  







}


