import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { RouterLink, RouterModule } from '@angular/router';
import { HelloComponent } from '../hello/hello.component';
import { HomeComponent } from "../../../components/home/home.component";

@Component({
  selector: 'app-udashboard',
  standalone:true ,
  imports: [
    CommonModule,
    RouterModule,
    HelloComponent,
    HomeComponent,
    
],
  templateUrl: './udashboard.component.html',
  styleUrl: './udashboard.component.css'
})
export class UdashboardComponent {


  

}
