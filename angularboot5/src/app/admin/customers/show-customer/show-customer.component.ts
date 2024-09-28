import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {UserDto} from "../../../services/models/user-dto";
import {UserService} from "../../../services/services/user.service";
import {RoleService} from "../../../services/services/role.service";
import {RoleResponse} from "../../../services/models/role-response";
import {ChangeRoleUserRequest} from "../../../services/models/change-role-user-request";
import {HelperService} from "../../../services/helper/helper.service";

@Component({
  selector: 'app-show-customer',
  templateUrl: './show-customer.component.html',
  styleUrls: ['./show-customer.component.css']
})
export class ShowCustomerComponent implements OnInit{

    showAlert: boolean= false;
    userId : any;
    roleId: any;
    // @ts-ignore
    changeRoleUserRequest : ChangeRoleUserRequest= {role_id:'', user_id: ''};

    // @ts-ignore
    userDto : UserDto = {};
    roles : Array<RoleResponse> = [];

    constructor(private router:Router, private userService: UserService,
                private activatedRoute: ActivatedRoute,
                private roleService:RoleService,
                private helper:HelperService) {
    }

    ngOnInit(): void {

        if (this.helper.userId){
            this.helper.clearLocalStorageWhenStatusAccountUserInActive();
            this.helper.refreshToken();
        }


        this.userId = this.activatedRoute.snapshot.params['user_id'] as number;

         if (this.userId){
             this.findAllRoles();
             this.userService.findUserById({
                 user_id: this.userId
             }).subscribe({
                 next:(data)=>{
                     this.userDto=data
                    // console.log(this.userDto)
                 },
                 error:(err)=>{
                     console.log(err)
                 }
             });
         }

    }

    findAllRoles(){
        this.roleService.findAll2().subscribe({
            next:(data)=>{
                this.roles=data
            },
            error:(err)=>{
                console.log(err)
            }
        })
    }
    navigateToCustomers() {

    }


    closeAlter() {
        this.showAlert=false;
    }

    changeRoleUser() {
            if (this.roleId){
                this.changeRoleUserRequest.user_id=this.userId,
                    this.changeRoleUserRequest.role_id=this.roleId
                this.userService.changerRoleUser({
                    body:this.changeRoleUserRequest
                }).subscribe({
                    next:async (data) => {
                        await this.router.navigate(['admin/customers'])
                    },
                    error:(err)=>{
                        console.log(err)
                    }
                })
            }
    }

    getRoleId() {
        this.roleId=this.userDto.roleId;
    }

}
