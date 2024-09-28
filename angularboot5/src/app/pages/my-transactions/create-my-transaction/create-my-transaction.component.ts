import {Component, OnInit} from '@angular/core';
import {Router} from "@angular/router";
import {TransactionDto} from "../../../services/models/transaction-dto";
import {ContactService} from "../../../services/services/contact.service";
import {HelperService} from "../../../services/helper/helper.service";
import {TransactionService} from "../../../services/services/transaction.service";
import {ContactDto} from "../../../services/models/contact-dto";

@Component({
  selector: 'app-create-my-transaction',
  templateUrl: './create-my-transaction.component.html',
  styleUrls: ['./create-my-transaction.component.css']
})
export class CreateMyTransactionComponent implements OnInit{



    transactionDto : TransactionDto = {};
    contacts : Array<ContactDto> = [];

    errorMessage : Array<String> = [];

    showAlert : boolean = false;


    constructor(private router:Router,
                private contactService: ContactService,
                private helper:HelperService,
                private transactionService:TransactionService) {

    }

    ngOnInit(): void {
        this.findAllContacts();

        this.helper.clearLocalStorageWhenStatusAccountUserInActive();
        this.helper.refreshToken();

    }

    findAllContacts(){
        this.contactService.findAll3().subscribe({
            next:(data)=>{
                this.contacts=data
            }
        });
    }

    async navigateToMyTransactions() {
        await this.router.navigate(['user/my-transactions']);
    }

    createTransaction() {
        this.transactionDto.userId=this.helper.userId;
        this.transactionService.save1({
            body:this.transactionDto
        }).subscribe({
            next:async (data) => {
                this.transactionDto= {};
                this.showAlert=true;
                setTimeout(() => {
                    this.showAlert = false;
                }, 5000);
               // await this.router.navigate(['user/my-transactions']);
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
        });
        console.log(this.transactionDto)
    }

    closeAlter(){
        this.showAlert=false;
    }

    closeAlert2() {

    }
}
