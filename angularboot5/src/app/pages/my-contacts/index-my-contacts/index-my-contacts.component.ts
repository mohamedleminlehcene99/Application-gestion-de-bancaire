import {Component, OnInit} from '@angular/core';
import {ContactDto} from "../../../services/models/contact-dto";
import {Router} from "@angular/router";
import {ContactService} from "../../../services/services/contact.service";
import {HelperService} from "../../../services/helper/helper.service";
import {UserService} from "../../../services/services/user.service";

@Component({
  selector: 'app-index-my-contacts',
  templateUrl: './index-my-contacts.component.html',
  styleUrls: ['./index-my-contacts.component.css']
})
export class IndexMyContactsComponent implements OnInit{

    contacts : Array<ContactDto> = [];

    userIdToDelete2 : any = -1;


    constructor(private router:Router, private contactService:ContactService,
                private helper:HelperService,
                private userService:UserService) {

    }

    ngOnInit(): void {
        this.findAllContatsByUserId();

        if (this.helper.userId){
            this.helper.clearLocalStorageWhenStatusAccountUserInActive();
            this.helper.refreshToken();
        }

    }

    findAllContatsByUserId(){
        this.contactService.findAllContactsByUserId({
            user_id:this.helper.userId
        }).subscribe({
            next:(data)=>{
                this.contacts=data
            }
        })
    }

    async navigateToCreateContact() {
        await this.router.navigate(['user/create-contact'])
    }

    async navigateToEditComponent(id: number | undefined) {
        await this.router.navigate(['user/update/my-contact/', id]);
    }

  deleteContact2() {
    if (this.userIdToDelete2){
      this.contactService.delete2({
        contact_id:this.userIdToDelete2
      }).subscribe({
        next:(data)=>{
          this.findAllContatsByUserId()
        },
        error:(err)=>{
          //console.log(err)
        }
      })
    }
  }
}
