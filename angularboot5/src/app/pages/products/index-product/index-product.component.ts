import {Component, OnInit} from '@angular/core';
import {Router} from "@angular/router";

@Component({
  selector: 'app-index-product',
  templateUrl: './index-product.component.html',
  styleUrls: ['./index-product.component.css']
})
export class IndexProductComponent  implements OnInit{

  constructor(private router: Router) {
  }
  ngOnInit(): void {

  }
  async navigateToCreateProduct() {
    await this.router.navigate(['user/product/create'])
  }

  async navigateToEditProduct() {
    await this.router.navigate(['user/product/edit']);
  }
}
