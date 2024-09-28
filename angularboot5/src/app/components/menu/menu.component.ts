import {Component, Input, OnInit} from '@angular/core';
import * as $ from 'jquery'; // Ajoutez cette ligne
@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit{


  @Input()
  isAdmin : boolean = false;

  role : string = 'user';

  constructor() { }

  ngOnInit(): void {

    if (this.isAdmin){
      this.role='admin';
    }


  }


}
