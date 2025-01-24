import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, CanActivateFn, GuardResult, MaybeAsync, Router, RouterStateSnapshot } from '@angular/router';
import { LoginService } from './login.service';




// export const adminGuard: CanActivateFn = (route, state) => {
  
//   return true;
// };


@Injectable({
  providedIn:'root'
})

export class adminGuard implements CanActivate{


  constructor(private login:LoginService,
    private route:Router
  ){}
  
  canActivate(route: ActivatedRouteSnapshot, 
    state: RouterStateSnapshot): 
    MaybeAsync<GuardResult> {
     // Check if the user is logged in and has the ADMIN role . if
     // true hai tbhi access hoga.
     
      if(this.login.isLoggedIn() &&  this.login.getUserRole()=='ADMIN')
      {

          return true;
      }

         // Redirect to the login page if not authorized
        this.route.navigate(['login']);
       return false;
    // throw new Error('Method not implemented.');
    }





  

}
