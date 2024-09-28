import {Component, OnInit} from '@angular/core';
import {UserDto} from "../../../services/models/user-dto";
import {Router} from "@angular/router";
import {AuthenticationService} from "../../../services/services/authentication.service";
import {HelperService} from "../../../services/helper/helper.service";

@Component({
  selector: 'app-create-customer',
  templateUrl: './create-customer.component.html',
  styleUrls: ['./create-customer.component.css']
})
export class CreateCustomerComponent implements OnInit{

  userDto : UserDto = {firstname: '', lastname: '', email: '', password: ''};
  showAlert: boolean = false;
  errorMessage : Array<String> = [];

  constructor(private router:Router, private authService:AuthenticationService,
              private helper:HelperService) {

  }

  ngOnInit(): void {

    if (this.helper.userId){
      this.helper.clearLocalStorageWhenStatusAccountUserInActive();
      this.helper.refreshToken();
    }


  }

  createUserWithRoleAdmin() {
    this.errorMessage=[];
    this.authService.createNewAdmin({
      body:this.userDto
    }).subscribe({
      next:async (data) => {
        if (data['token'] != null){
          this.userDto= {firstname:'', lastname: '', email: '', password: ''};
          this.showAlert=true;
          setTimeout(() => {
            this.showAlert = false;
          }, 5000);
        }
        else {
          this.showAlert = false;  // Ne pas afficher l'alerte si token est null ou vide
        }
        //await this.router.navigate(['admin/customers'])
       // console.log(data)
      },
      error:(err)=>{
        if (err.error && err.error.validationErrors) {
          // Ajouter chaque message d'erreur individuellement
          err.error.validationErrors.forEach((errorMsg: string) => {
            this.errorMessage.push(errorMsg);
          });
        }
      }
    })
  }

  closeAlter() {
      this.showAlert=false;
  }

  async navigateToCustomers() {
    await this.router.navigate(['admin/customers'])
  }

  closeAlert2() {
    this.errorMessage=[];
  }
}
