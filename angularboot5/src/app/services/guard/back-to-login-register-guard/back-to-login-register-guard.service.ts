import { Injectable } from '@angular/core';
import {ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree} from "@angular/router";
import {Observable} from "rxjs";
import {HelperService} from "../../helper/helper.service";

@Injectable({
  providedIn: 'root'
})
export class BackToLoginRegisterGuardService  implements CanActivate{

  constructor(private router:Router, private helper:HelperService) {

  }

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
    const  token = this.helper.tokenUser;


    if (token !== null && !this.helper.isTokenValid())
    {

      if (this.helper.roleUser === 'ROLE_USER'){

        // Si déjà sur la page 'user/profile', éviter la redirection
        if (state.url !== '/user/profile'){
          this.router.navigate(['user/profile']);
        }
        return false;  // Empêcher la navigation ultérieure
      }
      else
      {
        if(state.url !== '/admin/customers'){
          this.router.navigate(['admin/customers']);
        }
        return false; // Empêcher la navigation ultérieure
      }
    }


    // Autoriser l'accès aux pages de connexion/enregistrement s'il n'y a pas de token valide
    return true;

  }


}
