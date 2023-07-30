import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { HomeComponent } from './home/home.component';
import { AdminLoginComponent } from './admin-login/admin-login.component';
import { UserLoginComponent } from './user-login/user-login.component';
import { NewAccountComponent } from './new-account/new-account.component';

import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';
import { UserDashboardComponent } from './user-dashboard/user-dashboard.component';
import { AdminChequeBookRequestComponent } from './admin-cheque-book-request/admin-cheque-book-request.component';
import { AccountInfoComponent } from './account-info/account-info.component';
import { UserChequeBookRequestComponent } from './user-cheque-book-request/user-cheque-book-request.component';
import { UserMoneyTransferComponent } from './user-money-transfer/user-money-transfer.component';
import { TransactionsComponent } from './transactions/transactions.component';
import { AboutComponent } from './about/about.component';
import { ContactComponent } from './contact/contact.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    HomeComponent,
    AdminLoginComponent,
    UserLoginComponent,
    NewAccountComponent,
    AdminDashboardComponent,
    UserDashboardComponent,
    AdminChequeBookRequestComponent,
    AccountInfoComponent,
    UserChequeBookRequestComponent,
    UserMoneyTransferComponent,
    TransactionsComponent,
    AboutComponent,
    ContactComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
