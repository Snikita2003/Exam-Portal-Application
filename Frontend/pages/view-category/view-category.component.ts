import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MatCardModule } from '@angular/material/card';
import { MatIconModule } from '@angular/material/icon';
import { MatListModule } from '@angular/material/list';
import { CategoryService } from '../../services/category.service';
import { CatClass } from '../cat-class';
import { RouterLink, RouterModule } from '@angular/router';

@Component({
  selector: 'app-view-category',
  imports: [

    CommonModule,
    MatCardModule,
    MatListModule,
    FormsModule,
    MatButtonModule,
    MatIconModule,
    RouterLink,
    RouterModule,
    
   



  ],
  templateUrl: './view-category.component.html',
  styleUrl: './view-category.component.css'
})
export class ViewCategoryComponent implements OnInit {
  
  public categories:CatClass[] = []; // is this way, id will also come with CategoryClass crate add car- (id,title,description) good u did it.


  constructor(private cat:CategoryService){}

  ngOnInit(): void {

    this.cat.getCategories().subscribe(
      (data: any) => {
        console.log('API Response:', data); // Check API response structure
        this.categories = data;
      },
      (error) => {
        console.error('Error loading category data:', error);
      }
    );

    

  }


  








}
