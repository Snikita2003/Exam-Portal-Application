import { ActivatedRouteSnapshot, CanActivate, CanActivateFn, GuardResult, MaybeAsync, Router, RouterStateSnapshot } from '@angular/router';
import { LoginService } from './login.service';
import { Injectable } from '@angular/core';



@Injectable({
  providedIn:'root'
})

export class normalGuard implements CanActivate
{

  constructor(private login:LoginService,
    private r:Router){}
  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): MaybeAsync<GuardResult> {
    
    if(this.login.isLoggedIn() && this.login.getUserRole()=='NORMAL')
    {
      return true;
    }    
   else{

      this.r.navigate(['login']);

      return false;

    }
  }
  


    

}