import {Component, OnInit} from '@angular/core';
import {TransactionDto} from "../../../services/models/transaction-dto";
import {Router} from "@angular/router";
import {TransactionService} from "../../../services/services/transaction.service";
import {HelperService} from "../../../services/helper/helper.service";

@Component({
  selector: 'app-index-my-transaction',
  templateUrl: './index-my-transaction.component.html',
  styleUrls: ['./index-my-transaction.component.css']
})
export class IndexMyTransactionComponent implements OnInit{

    transactions : Array<TransactionDto> = [];

    constructor(private router:Router, private transactionService:TransactionService,
                private helper:HelperService) {

    }

    ngOnInit(): void {
            this.findAllTransactionsByUserId();

            this.helper.clearLocalStorageWhenStatusAccountUserInActive();
            this.helper.refreshToken();

    }

    findAllTransactionsByUserId(){
            this.transactionService.findAllTransactionByUserId(
                {
                    user_id:this.helper.userId
                }
            ).subscribe({
                next:(data)=>{
                    this.transactions=data
                },
                error:(err)=>{
                    console.log(err)
                }
            });
    }

    async navigateToCreateTransactions() {
        await this.router.navigate(['user/create-transaction']);
    }
}
