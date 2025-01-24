import { Component, OnInit } from '@angular/core';
import { QuizService } from '../../../services/quiz.service';
import { ActivatedRoute, RouterLink } from '@angular/router';
import { CommonModule } from '@angular/common';
import { MatCardModule } from '@angular/material/card';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatButtonModule } from '@angular/material/button';
import Swal from 'sweetalert2';
import { QuestionService } from '../../question.service';

@Component({
  selector: 'app-read-instruction',
  imports: [CommonModule,
    RouterLink,
    MatCardModule,
    MatFormFieldModule,
    MatButtonModule,
    

  ],
  templateUrl: './read-instruction.component.html',
  styleUrl: './read-instruction.component.css'
})
export class ReadInstructionComponent implements OnInit {
 
  constructor(private quizser:QuizService,
    private r:ActivatedRoute,
    private q:QuestionService,

  ){}
  



  qid: string = ''; // URL parameter will populate this.
  quiz:any;

ngOnInit(): void {
  // Ensure 'quiz-id' matches your route parameter
  this.qid = this.r.snapshot.params['quiz-id']; 

  this.quizser.getQuizById(this.qid).subscribe(
    (data: any) => {
      
      this.quiz = data; // Save the quiz data if needed
      console.log('Get quiz by ID: ', data);
    },
    (error) => {
      console.error('Error fetching quiz by ID:', error);
    }
  );
}




  
}
