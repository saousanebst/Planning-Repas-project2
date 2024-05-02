import { Component } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { AuthService } from '../auth.service';

@Component({
  selector: 'login, [login]',
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {

  loginForm!: FormGroup;

  emailCtrl!: FormControl;
  passwordCtrl!: FormControl;

  constructor(private formBuilder: FormBuilder, private authService: AuthService) {
    this.emailCtrl = this.formBuilder.control("", Validators.required);
    this.passwordCtrl = this.formBuilder.control("", [Validators.required, Validators.minLength(5)]);

    this.loginForm = this.formBuilder.group({
      email: this.emailCtrl ,
      password: this.passwordCtrl
    });

  }

  connexion() {

    this.authService.login(this.emailCtrl.value, this.passwordCtrl.value);
  }

  

  /*connexion() {
  this.authService.login(this.emailCtrl.value, this.passwordCtrl.value).subscribe(
    response => {
      // Gérer la réponse de l'API backend (par exemple, rediriger vers la page d'accueil si la connexion réussit)
      console.log('Connexion réussie:', response);
    },
    error => {
      // Gérer les erreurs de connexion (par exemple, afficher un message d'erreur à l'utilisateur)
      console.error('Erreur de connexion:', error);
    }
  );
}*/

}
