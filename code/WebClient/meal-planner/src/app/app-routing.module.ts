import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { LandingPageComponent } from "./landing-page/landing-page.component";
import { PlannerComponent} from "./planner/planner.component";
import {PageNotFoundComponent} from "./page-not-found/page-not-found.component";
import { SearchPageComponent} from "./search-page/search-page.component";
import {LognSigninPageComponent} from "./logn-signin-page/logn-signin-page.component";

const routes: Routes = [
  {path: 'landingPage', component: LandingPageComponent},
  {path: 'planning', component: PlannerComponent},
  {path: 'search', component: SearchPageComponent},
  {path: 'SignLogIn', component: LognSigninPageComponent},
  {path: '', redirectTo: '/landingPage', pathMatch: 'full'},
  {path: '**', component: PageNotFoundComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
