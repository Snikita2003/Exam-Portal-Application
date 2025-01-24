import { CommonModule } from '@angular/common';
import { Component, Input, input } from '@angular/core';
import { MatCardModule } from '@angular/material/card';
import { MatIconModule } from '@angular/material/icon';
import { MatListModule } from '@angular/material/list';
import { RouterLink, RouterModule } from '@angular/router';

@Component({
  selector: 'app-sidebar',
  imports: [ CommonModule,MatCardModule,
    MatListModule,
    MatIconModule,
    RouterModule,
    RouterLink
    
    


    
  ],
  templateUrl: './sidebar.component.html',
  styleUrl: './sidebar.component.css'
})
export class SidebarComponent {

  @Input() isAdmin: boolean = true;

}
