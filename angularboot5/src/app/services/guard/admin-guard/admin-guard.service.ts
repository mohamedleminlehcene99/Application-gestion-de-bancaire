import { Injectable } from '@angular/core';
import {ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree} from "@angular/router";
import {Observable} from "rxjs";
import {HelperService} from "../../helper/helper.service";

@Injectable({
  providedIn: 'root'
})
export class AdminGuardService implements CanActivate{


  constructor(private router:Router, private helper:HelperService) { }

   canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {

       const token = this.helper.tokenUser;

       if (token) {
           if (this.helper.roleUser !== 'ROLE_ADMIN') {
           this.router.navigate(['access-denied']);
               return false;
           }
           return true;
       }

       return false;
   }

}
