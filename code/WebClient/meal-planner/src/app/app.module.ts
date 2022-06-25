import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatNativeDateModule } from '@angular/material/core'


import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { LayoutModule } from '@angular/cdk/layout';
import {MatToolbarModule} from "@angular/material/toolbar";
import {MatButtonModule} from "@angular/material/button";
import { LandingPageComponent } from './landing-page/landing-page.component';
import { PlannerComponent } from './planner/planner.component';
import { SearchComponent } from './components/search/search.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { SearchPageComponent } from './search-page/search-page.component';
import {MatIconModule} from "@angular/material/icon";
import {MatPaginatorModule} from "@angular/material/paginator";
import { MealComponent } from './components/meal/meal.component';
import { FooterComponent } from './components/footer/footer.component';
import {MatSidenavModule} from "@angular/material/sidenav";
import { MealsComponent } from './components/meals/meals.component';
import { MealKalenderComponent } from './components/meal-kalender/meal-kalender.component';
import {MatInputModule} from "@angular/material/input";
import { LognSigninPageComponent } from './logn-signin-page/logn-signin-page.component';
import {ReactiveFormsModule} from "@angular/forms";

@NgModule({
  declarations: [
    AppComponent,
    LandingPageComponent,
    PlannerComponent,
    SearchComponent,
    PageNotFoundComponent,
    SearchPageComponent,
    MealComponent,
    FooterComponent,
    MealsComponent,
    MealKalenderComponent,
    LognSigninPageComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    ReactiveFormsModule,
    LayoutModule,
    MatToolbarModule,
    MatButtonModule,
    MatIconModule,
    MatPaginatorModule,
    MatSidenavModule,
    MatDatepickerModule,
    MatNativeDateModule,
    MatInputModule
  ],
  providers: [
    MatDatepickerModule
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
