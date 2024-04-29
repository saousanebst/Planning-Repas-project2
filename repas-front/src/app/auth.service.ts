import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Utilisateur } from './utilisateur/model';
import { environment } from './environments/environment';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private utilisateur?: Utilisateur = undefined;

  constructor(private http: HttpClient, private router: Router) { }

  login(username: string, password: string) {
    this.http.post<Utilisateur>(environment.apiUrl + "/utilisateur/connexion", { "login": username, "password": password }).subscribe(resp => {
      this.utilisateur = resp;

      this.router.navigate(["/home"]);
    });
  }

  logout() {
    this.utilisateur = undefined;
  }

  signUp(nom: string, prenom: string, username: string, password: string, passwordConf:string){
    this.http.post<Utilisateur>(environment.apiUrl + "/utilisateur/signup", { "nom": nom,"prenom": prenom,"login": username, "password": password, "passwordConf":passwordConf}).subscribe(resp => {
      this.utilisateur = resp;

      this.router.navigate(["/utilisateur/connexion"]);
    });
  }

  isLogged(): boolean {
    return this.utilisateur != undefined;
  }

  getUtilisateur() : Utilisateur | undefined{
    if(this.utilisateur) {
      return this.utilisateur;
    }

    return undefined;
  }
}
