import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Administrateur, Compte, Utilisateur } from './model';
import { environment } from './environments/environment';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private compte?: Compte = undefined;
  

  constructor(private http: HttpClient, private router: Router) { }

  
  login(login: string, password: string) {
      
    this.http.post<Compte>(environment.apiUrl + "/compte/login", { "login": login, "password": password }).subscribe(resp => {
      this.compte = resp;
      
      if (this.compte.type_compte === "user") {
        this.router.navigate(["/home"]);
      } else if (this.compte.type_compte === "admin"){
        this.router.navigate(["/home"]);//version 2 pages a creer
      } else{
        console.log("erreur");
      }
    });
    
  }



  logout() {
    this.compte = undefined;
  }

  signUp(nom: string, prenom: string, email: string, password: string, passwordConf:string){
    this.http.post<Utilisateur>(environment.apiUrl + "/utilisateur/signup", { "nom": nom,"prenom": prenom,"login": email, "password": password, "passwordConf":passwordConf}).subscribe(resp => {
      this.compte = resp;

      this.router.navigate(["/login"]);
    });
  }

  isLogged(): boolean {
    return this.compte != undefined;
  }

  getUtilisateur() : Utilisateur | undefined{
    if(this.compte) {
      return this.compte;
    }

    return undefined;
  }
}
