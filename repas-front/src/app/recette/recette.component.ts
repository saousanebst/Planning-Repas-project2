import { Component, OnInit } from '@angular/core';
import { RecetteService } from './recette.service';
import { Recette } from '../model';

enum TypeRecette {
  ENTREE = 'ENTREE',
  PLAT = 'PLAT',
  DESSERT = 'DESSERT',
  BOISSON = 'BOISSON'
  }

@Component({
  selector: 'recette, [recette]',
  templateUrl: './recette.component.html',
  styleUrl: './recette.component.css'
})
export class RecetteComponent implements OnInit{
  
  recettes?: Recette[];
  TypeRecette = TypeRecette;
  type?:TypeRecette;
  
  constructor(private recetteService: RecetteService) { 
    
  }

  ngOnInit() {
    this.getRecettes();
  }

  getRecettes(): void {
    this.recetteService.getRecettes()
      .subscribe(recettes => this.recettes = recettes);
  }

}
