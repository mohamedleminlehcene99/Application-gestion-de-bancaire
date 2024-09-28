import {Component, Input, OnInit} from '@angular/core';
import {Router} from "@angular/router";

@Component({
  selector: 'app-side-bar',
  templateUrl: './side-bar.component.html',
  styleUrls: ['./side-bar.component.css']
})
export class SideBarComponent implements  OnInit{

  @Input()
  isAdmin : boolean = false;

  constructor(private router:Router) {

  }


  ngOnInit(): void {

  }

  async navigateToCustomers() {
    await this.router.navigate(['admin/customers']);
  }

    async navigateToMyTransactions() {
      await this.router.navigate(['user/my-transactions']);
    }

    async navigateToMyContacts() {
      await this.router.navigate(['user/my-contacts'])
    }
}
