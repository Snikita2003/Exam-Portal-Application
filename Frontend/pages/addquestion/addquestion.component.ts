import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MatCardModule } from '@angular/material/card';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatListModule } from '@angular/material/list';
import { CategoryService } from '../../services/category.service';
import { MatInputModule } from '@angular/material/input';
import { CatClass } from '../cat-class';
import { Title } from '@angular/platform-browser';
import Swal from 'sweetalert2';
import { MatSnackBar, MatSnackBarModule } from '@angular/material/snack-bar';
import { CommonModule } from '@angular/common';
import { QuestionService } from '../question.service';
import { MatOptionModule } from '@angular/material/core';
import { MatSelectModule } from '@angular/material/select';


@Component({
  selector: 'app-addquestion',
  imports: [CommonModule,

    MatCardModule,
    MatListModule,
    MatFormFieldModule,
    FormsModule,
    MatSnackBarModule,
    MatInputModule,
    MatButtonModule,
    MatOptionModule,
    MatSelectModule,



  ],
  templateUrl: './addquestion.component.html',
  styleUrl: './addquestion.component.css'
})
export class AddquestionComponent implements OnInit {
  
  qId:number=0;
  qTitle:string=''

  question={
    quiz:{ qId:0},
    content:'',
    option1:'',
    option2:'',
    option3:'',
    option4:'',
    answer:'',

  }
  constructor(private r:ActivatedRoute,
    private serQue:QuestionService
  ){}

  ngOnInit(): void {
    
  this.qId=  this.r.snapshot.params['qid'];
  this.question.quiz['qId']=this.qId;



  }

  addQuestion()
  {
      this.serQue.addQuestions( this.question).subscribe(
        (q)=>{
          console.log('question- ',q);
        },
        (error)=>{
          console.log('error of question');
        }
      )
  }


  
}
