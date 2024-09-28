import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomePageComponent } from './pages/home-page/home-page.component';
import { MenuComponent } from './components/menu/menu.component';
import { MainUserPageComponent } from './pages/main-user-page/main-user-page.component';
import { NewUserComponent } from './pages/new-user/new-user.component';
import { FooterComponent } from './components/layout/footer/footer.component';
import { SideBarComponent } from './components/layout/side-bar/side-bar.component';
import { TopBarComponent } from './components/layout/top-bar/top-bar.component';
import { ContentDashbordComponent } from './components/layout/content-dashbord/content-dashbord.component';
import { LoginComponent } from './pages/auth/login/login.component';
import { RegisterComponent } from './pages/auth/register/register.component';
import { ForgetPasswordComponent } from './pages/auth/forgot-password/forget-password.component';
import { NotFoundComponent } from './pages/not-found/not-found.component';
import { CreateProductComponent } from './pages/products/create-product/create-product.component';
import { EditProductComponent } from './pages/products/edit-product/edit-product.component';
import {FormsModule} from "@angular/forms";
import {HTTP_INTERCEPTORS, HttpClient, HttpClientModule} from "@angular/common/http";
import { MainAdminPageComponent } from './admin/main-admin-page/main-admin-page.component';
import { IndexCustomerComponent } from './admin/customers/index-customer/index-customer.component';
import {HttpInterceptorService} from "./services/http-interceptor/http-interceptor.service";
import { CreateCustomerComponent } from './admin/customers/create-customer/create-customer.component';
import { ShowCustomerComponent } from './admin/customers/show-customer/show-customer.component';
import { AccessDeniedComponent } from './pages/access-denied/access-denied.component';
import { ProfileComponent } from './pages/profile/profile.component';
import { IndexMyTransactionComponent } from './pages/my-transactions/index-my-transaction/index-my-transaction.component';
import { CreateMyTransactionComponent } from './pages/my-transactions/create-my-transaction/create-my-transaction.component';
import { IndexMyContactsComponent } from './pages/my-contacts/index-my-contacts/index-my-contacts.component';
import { CreateMyContactsComponent } from './pages/my-contacts/create-my-contacts/create-my-contacts.component';

@NgModule({
  declarations: [
    AppComponent,
    HomePageComponent,
    MenuComponent,
    MainUserPageComponent,
    NewUserComponent,
    FooterComponent,
    SideBarComponent,
    TopBarComponent,
    ContentDashbordComponent,
    LoginComponent,
    RegisterComponent,
    ForgetPasswordComponent,
    NotFoundComponent,
    CreateProductComponent,
    EditProductComponent,
    MainAdminPageComponent,
    IndexCustomerComponent,
    CreateCustomerComponent,
    ShowCustomerComponent,
    AccessDeniedComponent,
    ProfileComponent,
    IndexMyTransactionComponent,
    CreateMyTransactionComponent,
    IndexMyContactsComponent,
    CreateMyContactsComponent,
  ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        FormsModule,
      HttpClientModule
    ],
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: HttpInterceptorService,
      multi: true
    },
    HttpClient
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
