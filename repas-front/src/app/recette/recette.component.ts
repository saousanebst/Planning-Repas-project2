import { Component, OnInit } from '@angular/core';
import { RecetteService } from './recette.service';
import { Recette, TypeRecette } from '../model';



@Component({
  selector: 'recette, [recette]',
  templateUrl: './recette.component.html',
  styleUrl: './recette.component.css'
})
export class RecetteComponent implements OnInit{
  
  recettes?: Recette[];
  TypeRecette = TypeRecette;
  
  days: { name: string, date: Date }[] = [];
  meals: string[] = ['PETIT-DÉJEUNER', 'DÉJEUNER', 'GOÛTER', 'DÎNER'];
  
  
  
  constructor(private recetteService: RecetteService) { 
    }


  ngOnInit() {
    this.getRecettes();
    this.initDays();
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


initDays(): void {
  const today = new Date();
  this.days.push({ name: this.getDayName(today.getDay()), date: today }); // Ajoute le jour actuel
  
  // Initialise les 6 jours suivants
  for (let i = 1; i < 7; i++) {
    const nextDay = new Date(today);
    nextDay.setDate(today.getDate() + i);
    this.days.push({ name: this.getDayName(nextDay.getDay()), date: nextDay });
  }
}

getDayName(dayIndex: number): string {
  const days = ['Dimanche', 'Lundi', 'Mardi', 'Mercredi', 'Jeudi', 'Vendredi', 'Samedi'];
  return days[dayIndex];
}

}
