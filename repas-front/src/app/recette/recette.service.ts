import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../environments/environment';
import { Recette } from '../model';


@Injectable({
  providedIn: 'root'
})
export class RecetteService {
  
  private apiUrl = environment.apiUrl+'/recette'; 

  constructor(private http: HttpClient) { }

  getRecettes(): Observable<Recette[]> {
    return this.http.get<Recette[]>(this.apiUrl);
  }
}
