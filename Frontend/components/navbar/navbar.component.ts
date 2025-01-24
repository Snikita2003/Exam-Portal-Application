import { CommonModule } from '@angular/common';
import { Component, OnChanges, OnInit, SimpleChanges } from '@angular/core';
import { MatIconModule } from '@angular/material/icon';
import { MatToolbarModule } from '@angular/material/toolbar';
import { RouterModule } from '@angular/router';
import { LoginService } from '../../services/login.service';

@Component({
  selector: 'app-navbar',
  imports: [ CommonModule , RouterModule ,
  MatToolbarModule,
  MatIconModule




  ],
  templateUrl: './navbar.component.html',
  styleUrl: './navbar.component.css'
})
export class NavbarComponent implements OnInit  {
 
  constructor(public login:LoginService)
  {

  }


  ngOnInit(): void { }

  public logout()
  {
      this.login.logout();
      window.location.reload();
  }
 
  
  
}
