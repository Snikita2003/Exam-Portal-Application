import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { MatCardModule } from '@angular/material/card';
import { RouterModule } from '@angular/router';
import {MatTableModule} from '@angular/material/table';
import { MatButtonModule } from '@angular/material/button';
import { LoginService } from '../../services/login.service';
@Component({
  selector: 'app-profile',
  imports: [CommonModule,
    MatCardModule,
    RouterModule,
    MatTableModule,
    MatButtonModule,
    
    
    
  ],
  templateUrl: './profile.component.html',
  styleUrl: './profile.component.css'
})
export class ProfileComponent implements OnInit {
  constructor(private login:LoginService){}

// get user from server(server se data aayega).

  user:any =null;
  ngOnInit(): void {


    

    this.login.getCurrentUser().subscribe(
      // get currect user1 from Observable(server).
      (user1:any)=>{
          this.user= user1 ;
      },
      (error)=>{
        console.log(" Error fetching currect user --- ",error);

      }
    )


    this.user = this.login.getUser();



  
    





    

  }

  
}
