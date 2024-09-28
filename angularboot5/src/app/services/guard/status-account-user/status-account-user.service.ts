import { Injectable } from '@angular/core';
import {ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree} from "@angular/router";
import {Observable} from "rxjs";
import {HelperService} from "../../helper/helper.service";
import {UserService} from "../../services/user.service";

@Injectable({
  providedIn: 'root'
})
export class StatusAccountUserService implements CanActivate{


  constructor(private router:Router, private helper:HelperService, private userService:UserService) {

  }

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {



    return true;
  }

}
