import { Component } from '@angular/core';
import { AuthService } from './auth.service';

@Component({
  selector: 'app-root, [app-root]',
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'repas-front';

  constructor(private authService: AuthService) {

  }
  
  isLogged(): boolean {
    return this.authService.isLogged();
  }

  logout() {
    this.authService.logout();
  }
  
}
