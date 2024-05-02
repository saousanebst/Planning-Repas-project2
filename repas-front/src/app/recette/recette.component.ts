import { Component, OnInit } from '@angular/core';
import { RecetteService } from './recette.service';
/*import { Recette } from '../model';*/
import { Recette, TypeRecette } from '../model';

/*enum TypeRecette {
  ENTREE = 'ENTREE',
  PLAT = 'PLAT',
  DESSERT = 'DESSERT',
  BOISSON = 'BOISSON'
  }*/

@Component({
  selector: 'recette, [recette]',
  templateUrl: './recette.component.html',
  styleUrl: './recette.component.css'
})
export class RecetteComponent implements OnInit{
  
  recettes?: Recette[];
  TypeRecette = TypeRecette;
  /*type?:TypeRecette;*/
  
  constructor(private recetteService: RecetteService) { 
    
  }

  ngOnInit() {
    this.getRecettes();
  }

  getRecettes(): void {
    this.recetteService.getRecettes()
        .subscribe(
            recettes => {
                this.recettes = recettes;
                console.log(recettes); // Vérifiez si toutes les recettes sont récupérées ici
            },
            error => {
                console.error('Erreur lors de la récupération des recettes :', error);
            }
        );
}

  /*getRecettes(): void {
    this.recetteService.getRecettes()
      .subscribe(recettes => this.recettes = recettes);
      console.log(this.recettes); 
  }*/

  /*ngOnInit(): void {
    this.loadRecettes();
  }

  // Méthode pour charger les recettes depuis le service
  loadRecettes() {
    this.recetteService.getRecettes().subscribe(
      (recettes: Recette[]) => {
        this.recettes = recettes;
      },
      (error) => {
        console.error('Erreur lors du chargement des recettes :', error);
      }
    );


  }*/

}
