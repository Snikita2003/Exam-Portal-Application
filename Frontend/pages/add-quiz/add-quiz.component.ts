import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MatCardModule } from '@angular/material/card';
import { MatFormField, MatFormFieldControl, MatFormFieldModule } from '@angular/material/form-field';
import { MatListModule } from '@angular/material/list';
import { QuizService } from '../../services/quiz.service';
import { Title } from '@angular/platform-browser';
import { QuizClass } from '../quiz-class';
import { MatInputModule } from '@angular/material/input';
import { MatSelectModule } from '@angular/material/select';
import { ViewCategoryComponent } from '../view-category/view-category.component';
import { CatClass } from '../cat-class';
import { CategoryService } from '../../services/category.service';

@Component({
  selector: 'app-add-quiz',
  imports: [
    CommonModule,
    MatButtonModule,
    MatCardModule,
    MatListModule,
    MatFormFieldModule,
    FormsModule,
    MatInputModule,
    MatSelectModule,






  ],
  templateUrl: './add-quiz.component.html',
  styleUrl: './add-quiz.component.css'
})
export class AddQuizComponent implements OnInit {
  


  constructor(private serQuiz:QuizService,
    private categoryService:CategoryService

  ){}

  // Initialize the category list and selected quiz data.
  categoryies: CatClass[] = [];
  // two way binding.
  quizData = {
    title: '',
    description: '',
    maxMarks: '',
    noOfQuestion: '',
    active: '',
    category: {
        id: null, // Use a default value such as `null` or a placeholder ID
    },
};


  
  

  //add data in html.
  public addDataQuiz() {

    console.log(this.quizData);

    if (!this.quizData.category.id) {
      console.log("Category ID is required.");
      return;
  }

    console.log("Quiz Data to be sent:", this.quizData);
    this.serQuiz.addQuiz(this.quizData).subscribe(
      (data: any) => {

         //this.quizData=data;
        console.log("Data stored in DB: ", data);
      },
      (error) => {
        console.log("Error while storing in DB: ", error);
      }
    );
  }
  



  
   // Load categories dynamically on component initialization.
  // select option category load dunamically.
  // when component will load that time this ngOnInit() will call automaticallly.
  ngOnInit(): void {

    console.log("Initial quizData:", this.quizData);
    console.log("Loaded categories:", this.categoryies);

    this.categoryService.getCategories().subscribe(
      (data:any )=>{

        console.log("Fetched categories: ", data);
        this.categoryies=data;

      },
      (error)=>{
        console.log("not loaded category in quiz select option ");
      }
    )
  }
  };

  



  

