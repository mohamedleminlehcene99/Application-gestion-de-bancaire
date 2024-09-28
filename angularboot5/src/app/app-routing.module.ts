import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {MainUserPageComponent} from "./pages/main-user-page/main-user-page.component";
import {NewUserComponent} from "./pages/new-user/new-user.component";
import {LoginComponent} from "./pages/auth/login/login.component";
import {RegisterComponent} from "./pages/auth/register/register.component";
import {ForgetPasswordComponent} from "./pages/auth/forgot-password/forget-password.component";
import {NotFoundComponent} from "./pages/not-found/not-found.component";
import {IndexProductComponent} from "./pages/products/index-product/index-product.component";
import {CreateProductComponent} from "./pages/products/create-product/create-product.component";
import {EditProductComponent} from "./pages/products/edit-product/edit-product.component";
import {MainAdminPageComponent} from "./admin/main-admin-page/main-admin-page.component";
import {IndexCustomerComponent} from "./admin/customers/index-customer/index-customer.component";
import {CreateCustomerComponent} from "./admin/customers/create-customer/create-customer.component";
import {ShowCustomerComponent} from "./admin/customers/show-customer/show-customer.component";
import {TokenGuardService} from "./services/guard/token-guard/token-guard.service";
import {AdminGuardService} from "./services/guard/admin-guard/admin-guard.service";
import {AccessDeniedComponent} from "./pages/access-denied/access-denied.component";
import {ProfileComponent} from "./pages/profile/profile.component";
import {
  BackToLoginRegisterGuardService
} from "./services/guard/back-to-login-register-guard/back-to-login-register-guard.service";
import {IndexMyTransactionComponent} from "./pages/my-transactions/index-my-transaction/index-my-transaction.component";
import {
  CreateMyTransactionComponent
} from "./pages/my-transactions/create-my-transaction/create-my-transaction.component";
import {IndexMyContactsComponent} from "./pages/my-contacts/index-my-contacts/index-my-contacts.component";
import {CreateMyContactsComponent} from "./pages/my-contacts/create-my-contacts/create-my-contacts.component";
import {UserGuardService} from "./services/guard/user-guard/user-guard.service";
import {StatusAccountUserService} from "./services/guard/status-account-user/status-account-user.service";

const routes: Routes = [
  {
    path:'login',
    component:LoginComponent,
    canActivate: [BackToLoginRegisterGuardService]
  },
  {
    path:'register',
    component:RegisterComponent,
    canActivate: [BackToLoginRegisterGuardService]
  },
  {
    path: 'forgot-password',
    component: ForgetPasswordComponent
  },
  {
    path:'not-found',
    component: NotFoundComponent
  },
  {
    path:'access-denied',
    component: AccessDeniedComponent
  },
  {
    path: '',
    redirectTo:'login', pathMatch: "full",
  },
  {
    path:'user',
    component: MainUserPageComponent,
    canActivate:[TokenGuardService, UserGuardService],
    children:[
      {
        path: 'profile',
        component: ProfileComponent
      },
      {
        path: 'my-transactions',
        component: IndexMyTransactionComponent
      },
      {
       path: 'create-transaction',
       component: CreateMyTransactionComponent
      },
      {
        path: 'my-contacts',
        component: IndexMyContactsComponent
      },
      {
        path: 'create-contact',
        component: CreateMyContactsComponent
      },
      {
        path: 'update/my-contact/:contactId',
        component: CreateMyContactsComponent
      },
      {
        path:'new',
        component: NewUserComponent
      },
      {
        path:'product/index',
        component: IndexProductComponent
      },
      {
        path:'product/create',
        component: CreateProductComponent
      },
      {
        path: 'product/edit',
        component: EditProductComponent
      }

    ]
  },
  {
    path:'admin',
    component: MainAdminPageComponent,
    canActivate: [TokenGuardService, AdminGuardService],
    children:[
      {
        path: 'customers',
        component: IndexCustomerComponent
      },
      {
        path: 'create/user/role/admin',
        component: CreateCustomerComponent
      },
      {
        path: 'show/user/:user_id',
        component: ShowCustomerComponent
      }

    ]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {

}
