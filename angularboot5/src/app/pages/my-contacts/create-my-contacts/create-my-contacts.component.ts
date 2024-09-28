import {Component, OnInit} from '@angular/core';
import {ContactDto} from "../../../services/models/contact-dto";
import {ActivatedRoute, Router} from "@angular/router";
import {ContactService} from "../../../services/services/contact.service";
import {HelperService} from "../../../services/helper/helper.service";

@Component({
  selector: 'app-create-my-contacts',
  templateUrl: './create-my-contacts.component.html',
  styleUrls: ['./create-my-contacts.component.css']
})
export class CreateMyContactsComponent implements OnInit{

    contactDto : ContactDto = {email: "", firstname: "", ibn: "", lastname: ""};
    showAlert : boolean = false;
    updateContact : boolean = false;
    errorMessage : Array<String> = [];

    constructor(private router:Router, private contactService:ContactService,
                private helper:HelperService, private activatedRoute:ActivatedRoute) {

    }

    async navigateToContacts() {
        await this.router.navigate(['user/my-contacts']);
    }

    ngOnInit(): void {

        if (this.helper.userId){
            this.helper.clearLocalStorageWhenStatusAccountUserInActive();
            this.helper.refreshToken();
        }


        const contactId = this.activatedRoute.snapshot.params['contactId'];
        if (contactId){
            this.updateContact=true;
            this.contactService.findContactById({
                contact_id:contactId
            }).subscribe({
                next:async (data) => {
                    this.contactDto = data
                },
                error:async (err) => {
                    await this.router.navigate(['not-found']);
                    //console.log(err);
                }
            });
        }
    }

    createContact() {
        this.errorMessage=[];
        this.contactDto.userId=this.helper.userId;
        this.contactService.save2({
            body:this.contactDto
        }).subscribe({
            next:async (data) => {
                this.contactDto= {firstname:'', lastname: '', email: '', ibn : ''};
                this.showAlert=true;
                setTimeout(() => {
                    this.showAlert = false;
                }, 5000);
                //await this.router.navigate(['user/my-contacts']);
            },
            error:(err)=>{
                if (err.error && err.error.validationErrors) {
                    // Ajouter chaque message d'erreur individuellement
                    err.error.validationErrors.forEach((errorMsg: string) => {
                        this.errorMessage.push(errorMsg);
                    });
                }
                console.log(err)
            }
        })
    }

    closeAlter() {
        this.showAlert=false;
    }

    closeAlert2() {
        this.errorMessage=[];
    }
}
