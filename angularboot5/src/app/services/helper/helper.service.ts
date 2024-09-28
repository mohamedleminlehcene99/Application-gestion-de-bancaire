import { Injectable } from '@angular/core';
import {JwtHelperService} from "@auth0/angular-jwt";
import {UserService} from "../services/user.service";
import {Router} from "@angular/router";

@Injectable({
  providedIn: 'root'
})
export class HelperService {

  private jwtHelper : JwtHelperService = new JwtHelperService();
  public token : any;
  private decoderToken : any;

  constructor(private userService:UserService, private router:Router) {
    this.updateToken();
  }

  private updateToken(){
    this.token = localStorage.getItem('token');

    if (this.token){
      this.decoderToken = this.jwtHelper.decodeToken(this.token);
    }
    else
    {
      this.decoderToken=null;
      this.router.navigate(['login']);
    }
  }

  get roleUser(): string{
    return this.decoderToken.authorities[0];
  }

  get tokenUser(): string{
    return this.token;
  }

  get userId(): number{
    return this.decoderToken.userId;
  }

  isTokenValid(){
    return this.jwtHelper.isTokenExpired(this.token);
  }

  get fullName():string{
    return this.decoderToken.fullName;
  }
  refreshToken()
  {
    this.updateToken();
  }

  clearLocalStorageWhenStatusAccountUserInActive()
  {
    //console.log(this.userId);
    this.userService.findUserById({
      user_id:this.userId
    }).subscribe({
      next:(data)=>{
        if (!data.active){
          this.reserLocalStorage();
        }
      }
    });
  }

  reserLocalStorage()
  {
    localStorage.clear();
  }

}
