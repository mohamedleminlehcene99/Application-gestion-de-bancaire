import {Component, OnInit} from '@angular/core';
import {Router} from "@angular/router";
import {AuthenticationRequest} from "../../../services/models/authentication-request";
import {AuthenticationService} from "../../../services/services/authentication.service";
import {HelperService} from "../../../services/helper/helper.service";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit{

  token : any;
  showAlert: boolean = false;
  errorMessage : Array<String> = [];

  authRequest : AuthenticationRequest = {email: '', password: ''};

  constructor(private router:Router, private authService:AuthenticationService,
              private helper:HelperService) {
    this.token = localStorage.getItem('token');
  }

  ngOnInit(): void {

    if(this.token){
      this.showAlert=true;

      setTimeout(() => {
        this.showAlert = false;
        localStorage.removeItem('token');
      }, 5000);
    }
    else {
      this.showAlert = false;  // Ne pas afficher l'alerte si token est null ou vide
    }

  }

  closeAlert(): void {
    this.showAlert = false;
    localStorage.removeItem('token');
  }

  async navigateToRegister() {
    await this.router.navigate(['register'])
  }

  async navigateToForgotPassword() {
    await this.router.navigate(['forgot-password'])
  }

  login() {
    this.errorMessage=[];
    console.log(this.authRequest)
    this.authService.authenticate({
      body:this.authRequest
    }).subscribe({
      next:async (data) => {
        if (typeof data.token === 'string'){
          localStorage.setItem('token', data.token  as string);

          this.helper.refreshToken();

          if (this.helper.roleUser === 'ROLE_ADMIN'){
            await this.router.navigate(['admin/customers']);
          }
          else
          {
            await this.router.navigate(['user'])
          }
        }

       /*
        localStorage.setItem('token', data['token'] as string);
        await this.router.navigate(['admin/customers']);
        console.log(data)
        */
      },
      error:(err)=>{
        this.errorMessage.push(err.error.errorMessage)
        this.authRequest={};
      }
    })
  }

  closeAlert2() {
    this.errorMessage=[];
  }
}

