import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Utilisateur } from './utilisateur/model';
import { environment } from './environments/environment';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private utilisateur?: Utilisateur = undefined;

  constructor(private http: HttpClient, private router: Router) { }

  
  login(login: string, password: string) {
    this.http.post<Utilisateur>(environment.apiUrl + "/utilisateur/login", { "login": login, "password": password }).subscribe(resp => {
      this.utilisateur = resp;

      this.router.navigate(["/home"]);
    });
  }

  /*login(login:string , password: string): Observable<any> {
    return this.http.post<any>(environment.apiUrl + '/utilisateur/login', { login, password });
  }*/

  logout() {
    this.utilisateur = undefined;
  }

  signUp(nom: string, prenom: string, email: string, password: string, passwordConf:string){
    this.http.post<Utilisateur>(environment.apiUrl + "/utilisateur/signup", { "nom": nom,"prenom": prenom,"login": email, "password": password, "passwordConf":passwordConf}).subscribe(resp => {
      this.utilisateur = resp;

      this.router.navigate(["/login"]);
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
