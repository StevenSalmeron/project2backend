import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
// Imported Forms module for login/register form
import { FormsModule } from '@angular/forms';
import { ReactiveFormsModule } from '@angular/forms';
// Imported HTTP Client module to fetch external data
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
// Importing created components to bundle them
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { HomeComponent } from './home/home.component';
import { ProfileComponent } from './profile/profile.component';
import { TheaterComponent } from './theater/theater.component';


@NgModule({
  declarations: [
    AppComponent,
    // Add components to declarations
    LoginComponent,
    RegisterComponent,
    HomeComponent,
    ProfileComponent,
    TheaterComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    // Add modules to declarations
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
