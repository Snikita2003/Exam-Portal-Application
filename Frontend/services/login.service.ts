import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import baseUrl from './helper';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor( private http:HttpClient ) { }

  // jo user login hoga uska detailfetch krenge.
  // get courrent/ login user
  public getCurrentUser():Observable<any> {
    const token = localStorage.getItem('token');
    return this.http.get(`${baseUrl}/currentuser`, {
      
      headers: { Authorization: `Bearer ${token}` },
    });
  }


  //generate token.
  public genereteToken( loginData :any )
  {
     return this.http.post(`${baseUrl}/generate-token`,loginData);
  }

  //login user- set token in local storage from jwt server.
  public loginUser(token:string )
  {
      localStorage.setItem('token',token);
      return true;
  }

  // check isLogin user or not.
  public isLoggedIn()
  {
     let tokenStr=localStorage.getItem("token");
     if( tokenStr == undefined || tokenStr=='' || tokenStr==null)
     {
          return false;
     }
     else
     {
        return true;
     }
  }

  //logout - remove token from localstorage.
  public logout()
  {
      localStorage.removeItem('token');
      localStorage.removeItem('user');
      return true;

  }
  // get token.
  public getToken()
  {
    console.log("Token from local - "+ localStorage.getItem('token') );

    
      return localStorage.getItem('token');
  }

  //set userdetail
  public setUser(user:any ):void
  {
    localStorage.setItem('user', JSON.stringify(user));
  }

   // Store the token in localStorage
   public setToken(token: string) {
    localStorage.setItem('token', token);
  }

  //getuser.
  public getUser()
  {
    let userstr =localStorage.getItem("user");
    if(userstr !=null)
    {
      return JSON.parse(userstr );
    }
    else{
      this.logout();
      return null;
    }
  }


  // get user role(authoriy) admin or normal
  public getUserRole()
  {
     let user=this.getUser();
     return user.authorities[0].authority;
  }




}
