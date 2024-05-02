import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { HttpClientModule } from '@angular/common/http';
import { HomeComponent } from './home/home.component';
import { UtilisateurComponent } from './utilisateur/utilisateur.component';
import { LoginComponent } from './login/login.component';
import { ContactComponent } from './contact/contact.component';
import { InscriptionComponent } from './inscription/inscription.component';
import { DessertComponent } from './dessert/dessert.component';
import { BoissonComponent } from './boisson/boisson.component';
import { EntreeComponent } from './entree/entree.component';
import { AboutComponent } from './about/about.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { PlatComponent } from './plat/plat.component';
import { AdministrateurComponent } from './administrateur/administrateur.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    UtilisateurComponent,
    LoginComponent,
    ContactComponent,
    InscriptionComponent,
    DessertComponent,
    BoissonComponent,
    EntreeComponent,
    AboutComponent,
    PlatComponent,
    AdministrateurComponent
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
