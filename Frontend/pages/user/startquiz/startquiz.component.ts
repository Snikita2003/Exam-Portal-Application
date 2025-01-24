import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, PreloadAllModules, Route, Router, RouterLink } from '@angular/router';
import { QuizService } from '../../../services/quiz.service';
import Swal from 'sweetalert2';
import { QuestionService } from '../../question.service';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { MatCardModule } from '@angular/material/card';
import { MatDividerModule } from '@angular/material/divider';
import { MatButtonModule } from '@angular/material/button';
import { MatProgressSpinner } from '@angular/material/progress-spinner';

@Component({
  selector: 'app-startquiz',
  imports: [CommonModule,
    FormsModule,
    MatCardModule,
    MatDividerModule,
    MatButtonModule,
    MatProgressSpinner,
    RouterLink,


    



  ],
  templateUrl: './startquiz.component.html',
  styleUrl: './startquiz.component.css'
})
export class StartquizComponent implements OnInit {
  
  //get question by quizid

  
  //variables.
  qid:string=''
  questions:any[]=[];
  marksGot:number=0;
  correctAnswers:number=0;
  attempted:number=0;
  timer:any;
  





  constructor(private r:ActivatedRoute,
    private q:QuestionService,
    private quiz:QuizService,
    private router:Router

  ){}

 
  ngOnInit(): void {

     // GET QUESSIONS BY QUIZID.
     // Get the quiz ID from the route parameters
    this.qid=this.r.snapshot.params['quiz-id'];


    this.q.getQuestionsByQuizId(this.qid).subscribe(
      (data: any) => {

        this.questions = data; // Assign data to the questions variable
        
        //timer.
        this.timer= this.questions.length*2*60 ;

        // Ensure questions is an array and iterate over it
        
        this.questions.forEach((q:any) => {
          q['givenans'] = ''; // Add the 'givenans' property to each question
          //console.log( q['givenans']);

        });


        // start krr do startwuiz.component load hoga.
        this.startTimer();


        console.log('All questions by quiz ID:',  data);
      
      },
      (error) => 
      {
        console.error('Error fetching questions:', error);
      }
    );
  }



  perQuestionMarks:number=0;
  totalQuestions:number=0;
  totalMarks:number=0

  submitQuiz()
  {
      
      // 
      this.totalMarks= 0;

      this.questions.forEach((q:any)=>{

        if( q.givenans != '')
            this.attempted++;
        
        // if answer is correct.
        if( q.answer == q.givenans )
        {
          this.correctAnswers++;
          let marksingle= this.questions[0].quiz.maxMarks/this.questions.length;

          this.marksGot += marksingle ; 

          console.log('yes correct', q,' ',this.correctAnswers );
        }

        // if answer is not correct.
        else
        {
          console.log('not correct', q );
          

        }

      
    
      
  });

      console.log(' Total marks - ', this.questions[0].maxMarks );
      console.log('Attenpted- ', this.attempted );
      console.log('Marks Got - ', this.marksGot );
     
  }



  // start-timer function.
  startTimer()
  {
      let t:any=window.setInterval(()=>{

        if(this.timer<=0)
        {
          this.submitQuiz();
          clearInterval(t);// clear interval.

        }
        else{
          this.timer--;
        }

      },1000)
  }


  // format timer
    getFormattedTime()
    {
      let m=Math.floor(this.timer/60);
      let s=this.timer - m*60;
      return `${m} min:${s}sec`;
    }
}