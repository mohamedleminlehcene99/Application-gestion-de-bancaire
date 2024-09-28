import {Component, OnInit} from '@angular/core';
import {UserDto} from "../../../services/models/user-dto";
import {Router} from "@angular/router";
import {AuthenticationService} from "../../../services/services/authentication.service";

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit{

  userDto : UserDto = {firstname: '', lastname: '', email: '', password: ''};

  errorMessage : Array<String> = [];

  constructor(private router:Router, private authService:AuthenticationService) {

  }

  ngOnInit(): void {

  }

  register() {
    this.errorMessage=[];
      this.authService.register({
        body:this.userDto
      }).subscribe({
        next:async (data) => {
          console.log(data['token'])
          localStorage.setItem('token',data['token'] as string)
         await this.router.navigate(['login'] )
          //console.log(data)
        },
        error:(err)=>{
          //console.log(err);
          if (err.error && err.error.errorMessage){
            this.errorMessage.push(err.error.errorMessage);
            //this.userDto={email: "", firstname: "", lastname: "", password: ""};
          }

          if (err.error && err.error.validationErrors) {
            // Ajouter chaque message d'erreur individuellement
            err.error.validationErrors.forEach((errorMsg: string) => {
              this.errorMessage.push(errorMsg);
            });
          }

         // this.userDto={email: "", firstname: "", lastname: "", password: ""};
        }
      });
  }

  async navigateToForgotPassword() {
    await this.router.navigate(['forgot-password'])
  }

  async navigateToLogin() {
    await this.router.navigate(['login'])
  }

  closeAlert2() {
    this.errorMessage=[];
  }
}
