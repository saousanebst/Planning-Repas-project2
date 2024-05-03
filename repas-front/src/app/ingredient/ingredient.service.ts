import { Injectable } from '@angular/core';
import { environment } from '../environments/environment';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Ingredient } from '../model';

@Injectable({
  providedIn: 'root'
})
export class IngredientService {

  private apiUrl = environment.apiUrl+'/ingredient';

  constructor(private http: HttpClient) { }

  getRecettes(): Observable<Ingredient[]> {
    return this.http.get<Ingredient[]>(this.apiUrl);
  }
}
