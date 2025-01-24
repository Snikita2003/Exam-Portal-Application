import { Component, OnInit } from '@angular/core';
import { QuestionService } from '../question.service';
import { ActivatedRoute, RouterLink, RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';
import { MatCard, MatCardModule } from '@angular/material/card';
import { FormsModule } from '@angular/forms';
import { MatDividerModule } from '@angular/material/divider';
import { MatButtonModule } from '@angular/material/button';

@Component({
  selector: 'app-view-quiz-question',
  imports: [CommonModule,
    FormsModule,
    MatDividerModule,
    MatCardModule,
    MatButtonModule,
    RouterModule,
    RouterLink,
    





  ],
  templateUrl: './view-quiz-question.component.html',
  styleUrl: './view-quiz-question.component.css'
})
export class ViewQuizQuestionComponent implements OnInit {
  
  constructor(private ser:QuestionService,
    private r:ActivatedRoute

  ){}

  qId:number=0;
  qtitle:string='';
  i:number=0;
  questions=[{
    content:'',
    option1:'',
    option2:'',
    option3:'',
    option4:'',
    answer:'',

  }]

  
  ngOnInit(): void {
    
    this.qId= this.r.snapshot.params['qid']; // yeh same hona chahiye from app.route.ts file.variable.
    this.qtitle= this.r.snapshot.params['title'] ;
    

    
    console.log(this.qId)
    console.log(this.qtitle);

    this.ser.getQuestionsofQuiz( this.qId).subscribe(
      (data:any)=>{
        this.questions=data;

        console.log('all questions by quizz - ', this.questions  );
      },
      (error)=>{
        console.log('No questions loaded');
      }
    )

    
  }


  
}
