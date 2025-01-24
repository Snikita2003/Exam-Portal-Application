import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { MatButtonModule } from '@angular/material/button';
import { MatCardModule } from '@angular/material/card';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatIconModule } from '@angular/material/icon';
import { MatListModule } from '@angular/material/list';
import { CategoryService } from '../../../services/category.service';
import { MatSnackBar, MatSnackBarModule } from '@angular/material/snack-bar';
import { RouterLink, RouterModule } from '@angular/router';

@Component({
  selector: 'app-hello',
  imports: [CommonModule,
    MatCardModule,
    MatFormFieldModule,
    MatIconModule,
    MatButtonModule,
    MatListModule,
    MatSnackBarModule,
    RouterLink,
    RouterModule,
    


  ],
  templateUrl: './hello.component.html',
  styleUrl: './hello.component.css'
})
export class HelloComponent implements OnInit{
  
  categories:any;
  constructor(private catService:CategoryService,
    private snak:MatSnackBar

  ){}
  
  
  ngOnInit(): void {
      this.catService.getCategories().subscribe(
        (data:any)=>{
          this.categories=data;
        },
        (error)=>{

            this.snak.open('something bad');
        }
      );
    
  }

  
}
