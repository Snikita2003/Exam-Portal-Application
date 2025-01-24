import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import {MatButtonModule} from '@angular/material/button';
import { FormsModule } from '@angular/forms';


import { UserService } from '../../services/user.service';
import { HttpClientModule } from '@angular/common/http';
import { MatSnackBar } from '@angular/material/snack-bar';
import Swal from 'sweetalert2';
import { MatCardModule } from '@angular/material/card';

@Component({
  selector: 'app-signup',
  imports: [CommonModule,MatFormFieldModule
    ,MatInputModule ,
    MatButtonModule,
    FormsModule,
    HttpClientModule,
    MatCardModule
  


  ],
  
  
  templateUrl: './signup.component.html',
  styleUrl: './signup.component.css'
})

export class SignupComponent {

constructor( private u:UserService,
  private snakbar: MatSnackBar

) {}


  public user={
    
    username:'',
    password:'',
    lastName:'',
    firstName:'',
    email:'',
    phone:''


  };




  //  form submit signup.
  formSubmitSignup()
  {
       // add user data.
       if( this.user.username== '' || this.user.email==null)
       {
           this.snakbar.open('Username is Missing','',{
            duration:3000,
            verticalPosition:'top',
            horizontalPosition:'right'
          })
          return;  
       }

       // check password
       if( this.user.password=='' || this.user.password==null)
       {
         this.snakbar.open('Password is missing','',{
          duration:2000
         })
         return;

        }

       // check firstname;
       if( (this.user.firstName=='' || this.user.firstName==null)||
            (this.user.email==''|| this.user.email==null) ||
              ( this.user.phone=='' || this.user.phone==null))
       {
          this.snakbar.open( 'Something is missing ','',{
            duration:2000
          })

          this.user.username='';
          
          return;
      }

      // comleting check all filed should not be missing . done.





      

       this.u.addUser( this.user ).subscribe(
        (data:any )=> 
        { //success
          this.snakbar.open('!! Registred !!','',
            { duration:3000 }
          );
            console.log("Your Data is - ", data);
            Swal.fire('Success Done','Registered Successfully with Id :'+data.id , 'success');

        },
        (error)=>
        {
            //error.
            this.snakbar.open('Something Went Wrong ','',{
              duration:3000
            });

            //Swal.fire('Failed','Not Registered');
                  
          }
       )
}



}
