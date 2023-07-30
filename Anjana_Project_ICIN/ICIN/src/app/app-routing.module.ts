import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { AdminLoginComponent } from './admin-login/admin-login.component';
import { UserLoginComponent } from './user-login/user-login.component';
import { NewAccountComponent } from './new-account/new-account.component';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';
import { UserDashboardComponent } from './user-dashboard/user-dashboard.component';
import { AdminChequeBookRequestComponent } from './admin-cheque-book-request/admin-cheque-book-request.component';
import { AccountInfoComponent } from './account-info/account-info.component';
import { UserChequeBookRequestComponent } from './user-cheque-book-request/user-cheque-book-request.component';
import { UserMoneyTransferComponent } from './user-money-transfer/user-money-transfer.component';
import { TransactionsComponent } from './transactions/transactions.component';
import { AboutComponent } from './about/about.component';
import { ContactComponent } from './contact/contact.component';

const routes: Routes = [
  { path: "", redirectTo: "home", pathMatch: "full" },
  { path: "home", component: HomeComponent },
  { path: "about", component: AboutComponent },
  { path: "contact", component: ContactComponent },
  { path: "admin-login", component: AdminLoginComponent },
  { path: "dashboardAdmin", component: AdminDashboardComponent },
  { path: "allCustomers", component: AdminDashboardComponent },
  { path: "all-cheque-book-requests", component: AdminChequeBookRequestComponent },
  { path: "user-login", component: UserLoginComponent },
  { path: "dashboardCustomer", component: UserDashboardComponent },
  { path: "account-info", component: AccountInfoComponent },
  { path: "my-cheque-book", component: UserChequeBookRequestComponent },
  { path: "money-transfer", component: UserMoneyTransferComponent },
  { path: "transactions", component: TransactionsComponent },
  { path: "new-account", component: NewAccountComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
