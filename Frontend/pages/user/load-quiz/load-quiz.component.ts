import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, RouterLink, RouterModule } from '@angular/router';
import { QuizService } from '../../../services/quiz.service';
import { animate } from '@angular/animations';
import { CommonModule } from '@angular/common';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatCardActions, MatCardMdImage, MatCardModule } from '@angular/material/card';
import { MatIconModule } from '@angular/material/icon';
import { MatButtonModule } from '@angular/material/button';
import { MatActionList, MatListModule } from '@angular/material/list';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-load-quiz',
  imports: [CommonModule,
    MatFormFieldModule,
    MatCardModule,
    MatIconModule,
    MatButtonModule,
    MatListModule,
    RouterModule,
    RouterLink,
    FormsModule,
    



  ],
  templateUrl: './load-quiz.component.html',
  styleUrl: './load-quiz.component.css'
})
export class LoadQuizComponent implements OnInit {
  
  
  catId:number=0;
  getAllQuizzes:any;

  constructor(private r:ActivatedRoute,
    private quizser:QuizService

  ){}

  ngOnInit(): void {
    // url madhe var send kru sjkto. mg var chach data get karnar.
    
    
    this.r.params.subscribe(
      (data:any)=>{
        this.catId= data['catId'];
        if( this.catId==0)
          {
            //load all quiz if 0
            this.quizser.getQuizzez().subscribe(
              (data:any)=>{
      
                  this.getAllQuizzes=data;
      
                  console.log(data);
              },
              (error)=>{
                console.log('quizzez not loaded all ', error );
      
              }
            )
          }
          else{

            // quizzez filter hoga according to category.
            //load specific quiz acccording to categoryId.
            this.getAllQuizzes=[];
            this.quizser.getQuizzesBycategory(this.catId).subscribe(
              (data:any)=>{
    
                this.getAllQuizzes=data;
                
                if( this.getAllQuizzes.length==0)
                {
                    
                }
                console.log('By category specific data- ',data);
              },
              (error)=>{
                console.log('Error in getting specific quizzez by category');
              }
            );

      
          }
      }
    )

    
    
    

  }

  


}
