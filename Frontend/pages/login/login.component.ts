import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MatCardModule } from '@angular/material/card';
import { MatFormField, MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatSnackBar, MatSnackBarModule } from '@angular/material/snack-bar';
import { LoginService } from '../../services/login.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-login',
  imports: [CommonModule,
    MatFormFieldModule,
    MatButtonModule,
    MatInputModule,
    FormsModule,
    MatCardModule,
    MatSnackBarModule


  ],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {

  constructor(  private snak:MatSnackBar,
    private login:LoginService
   ){}


  loginData={
    username:'',
    password:''
  }

  formSubmitLogin()
  {

      console.log("Log in : ", this.loginData );
    //validation
    if( this.loginData.username.trim()==''|| this.loginData.username
    ==null)
    {
        this.snak.open('Invalid ','',{
          duration:3000
        });

        return;
    }
    if( this.loginData.password.trim()==''|| this.loginData.password==null)
    {
        this.snak.open(' Invalid','',{
          duration:3000
        });

        return;
    }


      // request to server to generate token.

      this.login.genereteToken( this.loginData  ).subscribe
      (
        (data:any)=>{
          console.log("token- ", data);

          //login.
          this.login.loginUser( data.token );
          this.login.getCurrentUser().subscribe(

            (user:any)=>{
              this.login.setUser(user);
              console.log("User Username : " + ( user.username )  );
              console.log("User password : "+ user.password)

              // this.snak.open('Successfully Login!!','',{
              //   duration:1000
              // })

              Swal.fire("Succesfully Login");
              // check user is admin or normal.
              if(this.login.getUserRole()=="ADMIN")
              {

                // admin dashboard
                window.location.href='/admin'
              }
              else if(this.login.getUserRole() =="NORMAL")
              {
                  // user dashboard.
                  window.location.href='/user-dashboard/0';
              }
              else
              {
                  this.login.logout();

              }

            },
            (usererror)=>{
              console.log(" UserError ",usererror);

            }
          )
        }
        ,
        (error)=>{   // invalid username or password.
          console.log("ERROR------ ",error);
          this.snak.open('Invalid Username or Password','',{
            duration:1000
          });
        }
      )
    

  }

}
