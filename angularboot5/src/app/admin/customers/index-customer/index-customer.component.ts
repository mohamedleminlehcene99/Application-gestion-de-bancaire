import {Component, OnInit} from '@angular/core';
import {Router} from "@angular/router";
import {UserDto} from "../../../services/models/user-dto";
import {UserService} from "../../../services/services/user.service";
import {HelperService} from "../../../services/helper/helper.service";

@Component({
  selector: 'app-index-customer',
  templateUrl: './index-customer.component.html',
  styleUrls: ['./index-customer.component.css']
})
export class IndexCustomerComponent implements OnInit{


  customers : Array<UserDto> = [];

  constructor(private router:Router, private userService:UserService,
              private helper:HelperService) {

  }

  ngOnInit(): void {

    this.findAllCustomers();

    if (this.helper.userId){
      this.helper.clearLocalStorageWhenStatusAccountUserInActive();
      this.helper.refreshToken();
    }


  }

  findAllCustomers(){
    this.userService.findAll().subscribe({
      next:(data)=>{
        this.customers = data
      },
      error:(err)=>{
        console.log(err)
      }
    })
  }

  async navigateToCreateCustomers() {
    await this.router.navigate(['admin/create/user/role/admin'])
  }

  async navigateToShwoCustomer(user_id: number | undefined) {
    //console.log(user_id)
    await this.router.navigate(['admin/show/user', user_id]);
  }

  activeAccount(user_id: number | undefined){

   if (user_id){
     this.userService.validateAccount({
       user_id:user_id
     }).subscribe({
       next:(data)=>{
         this.findAllCustomers();
         //console.log(data)
       },
       error:(err)=>{
         console.log(err)
       }
     })
   }
  }


  inActiveAccount(user_id: number | undefined){
        this.userService.invalidateAccount({
      user_id:user_id as number
        }).subscribe({
          next:(data)=>{
            this.findAllCustomers();
          },
          error:(err)=>{
            console.log(err)
          }
        });
  }

}
