import { Component } from '@angular/core';
import { Ingredient } from '../model';
import { IngredientService } from './ingredient.service';


@Component({
  selector: 'ingredient, [ingredient]',
  templateUrl: './ingredient.component.html',
  styleUrl: './ingredient.component.css'
})
export class IngredientComponent {

  ingredients: Ingredient[] = [];
  

  constructor(private ingredientService: IngredientService) {}

  ngOnInit() {
    this.getIngredient();
  }

  getIngredient(): void {
    this.ingredientService.getRecettes().subscribe(
      ingredients => {
        this.ingredients = ingredients || [];
      },
      error => {
        console.error('Erreur lors de la récupération des ingredients :', error);
      }
    );
  }


}
