import {Component, OnInit} from '@angular/core';
import {HelperService} from "../../../services/helper/helper.service";
import {Router} from "@angular/router";
import {UserDto} from "../../../services/models/user-dto";
import {UserService} from "../../../services/services/user.service";

@Component({
  selector: 'app-top-bar',
  templateUrl: './top-bar.component.html',
  styleUrls: ['./top-bar.component.css']
})
export class TopBarComponent implements OnInit{

  fullName : any;
  statusLogout : any = -1;
  userDto : UserDto = {email: "", firstname: "", lastname: "", password: ""};

  constructor(private helper:HelperService, private router:Router,
              private userService: UserService) {

  }

  ngOnInit(): void {
    this.fullName = this.helper.fullName;
    this.userService.findUserById({
      user_id:this.helper.userId
    }).subscribe({
      next:(data)=>{
        this.userDto=data
      }
    })
  }

  logout() {
   // console.log(this.statusLogout)
    if (this.statusLogout) {
      localStorage.clear();
      // Remettre à jour la variable contenant le token
      this.helper.token = null; // Ou une valeur par défaut si nécessaire
      //console.log(this.helper.tokenUser); // Vérifier que le token est bien null ou vide
      if (this.helper.tokenUser === null){
        this.router.navigate(['login']);
      }
    }
  }

}

