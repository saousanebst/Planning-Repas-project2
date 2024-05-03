import { Component, OnInit } from '@angular/core';
import { RecetteService } from './recette.service';
import { Recette, TypeRecette } from '../model';
import { CdkDragDrop } from '@angular/cdk/drag-drop';

@Component({
  selector: 'recette',
  templateUrl: './recette.component.html',
  styleUrls: ['./recette.component.css']
})
export class RecetteComponent implements OnInit {
  recettes?: Recette[];
  TypeRecette = TypeRecette;
  //days: { name: string, date: Date, recette?: Recette }[] = [];
  meals: string[] = ['PETIT-DÉJEUNER', 'DÉJEUNER', 'GOÛTER', 'DÎNER'];
  done: Recette[] = [];
// Définissez le type de l'objet days avec recette comme un tableau vide de Recette
  days: { name: string, date: Date, recette: Recette[] }[] = [];



  constructor(private recetteService: RecetteService) {}

  ngOnInit() {
    this.getRecettes();
    this.initDays();
  }

  getRecettes(): void {
    this.recetteService.getRecettes().subscribe(
      recettes => {
        this.recettes = recettes || [];
      },
      error => {
        console.error('Erreur lors de la récupération des recettes :', error);
      }
    );
  }

  initDays(): void {
    const today = new Date();
    this.days.push({ name: this.getDayName(today.getDay()), date: today, recette: [] });
  
    for (let i = 1; i < 7; i++) {
      const nextDay = new Date(today);
      nextDay.setDate(today.getDate() + i);
      this.days.push({ name: this.getDayName(nextDay.getDay()), date: nextDay, recette: [] });
    }
  }
  
  

  getDayName(dayIndex: number): string {
    const days = ['Dimanche', 'Lundi', 'Mardi', 'Mercredi', 'Jeudi', 'Vendredi', 'Samedi'];
    return days[dayIndex];
  }

  drop(event: CdkDragDrop<Recette[]>, day: any, destination: string) {
    // Vérifiez si l'élément est déplacé du conteneur précédent (liste de recettes) au conteneur de destination (tableau de planification)
    if (event.previousContainer !== event.container && destination === 'PLANNING') {
      const recette: Recette = event.previousContainer.data[event.previousIndex];
      day.recette = recette; // Affectez la recette à ce jour dans le tableau de planification
  
      // Ajoutez la recette à la liste représentant le menu de la semaine
      this.done.push(recette);
  
      event.previousContainer.data.splice(event.previousIndex, 1); // Supprimez la recette de la liste de recettes
    }
  }
  
  


}
