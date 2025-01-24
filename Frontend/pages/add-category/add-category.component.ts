import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
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

@Component({
  selector: 'app-add-category',
  imports: [CommonModule,
    MatButtonModule,
    MatCardModule,
    MatListModule,
    MatFormFieldModule,
    MatInputModule,
    FormsModule,
    MatSnackBarModule,


    


  ],
  templateUrl: './add-category.component.html',
  styleUrl: './add-category.component.css'
})
export class AddCategoryComponent {


  cat:any ={
    id:'',
    title:'',
    description:''
  }

  constructor(private service:CategoryService,
    private snak:MatSnackBar
  ){}


  
  public addDataCategory()
  {


    console.log("category function call ts file");

    if( this.cat.title.trim() == '' || this.cat.title ==null)
    {
        this.snak.open('Category Title is Missing','',{duration:2000});
        return;
              
    }

      this.service.addCategoryData(this.cat).subscribe(
        (data:any)=>{

          console.log('category store in db - ', data);
          Swal.fire('Added Category Successfully');
          this.cat = { title: '', description: '' }; // Reset form after submission
        },
        
        (error)=>{
          console.log('error in storing in db');
        }
      )
  };
  

} 
