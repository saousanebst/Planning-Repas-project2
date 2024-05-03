import { Component, OnInit } from '@angular/core';
import { RecetteService } from './recette.service';
import { Recette, TypeRecette } from '../model';
import { CdkDragDrop, moveItemInArray } from '@angular/cdk/drag-drop';

@Component({
  selector: 'app-recette',
  templateUrl: './recette.component.html',
  styleUrls: ['./recette.component.css']
})
export class RecetteComponent implements OnInit {

  recettes: Recette[] = [];
  TypeRecette = TypeRecette;

  days: { name: string, date: Date }[] = [];
  meals: string[] = ['PETIT-DÉJEUNER', 'DÉJEUNER', 'GOÛTER', 'DÎNER'];

  done: { [meal: string]: { [day: string]: Recette[] } } = {};

  constructor(private recetteService: RecetteService) { }

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
    this.days.push({ name: this.getDayName(today.getDay()), date: today }); // Ajoute le jour actuel

    // Initialise les 6 jours suivants
    for (let i = 1; i < 7; i++) {
      const nextDay = new Date(today);
      nextDay.setDate(today.getDate() + i);
      this.days.push({ name: this.getDayName(nextDay.getDay()), date: nextDay });
    }

    // Initialiser les données de done
    this.meals.forEach(meal => {
      this.done[meal] = {};
      this.days.forEach(day => {
        this.done[meal][day.name] = [];
      });
    });
  }

  getDayName(dayIndex: number): string {
    const days = ['Dimanche', 'Lundi', 'Mardi', 'Mercredi', 'Jeudi', 'Vendredi', 'Samedi'];
    return days[dayIndex];
  }

  dropRecetteDansCase(event: CdkDragDrop<Recette[]>): void {
    if (event.previousContainer === event.container) {
      // Reorder items within the same list
      moveItemInArray(event.container.data, event.previousIndex, event.currentIndex);
    } else {
      // Move item between lists
      const recette: Recette = event.item.data;
      const meal = this.meals[event.currentIndex];
      const dayName = this.days[event.previousIndex].name;
      this.done[meal][dayName].push(recette);
      
    }
  }

  getRecettesForDayAndMeal(day: { name: string, date: Date }, meal: string): Recette[] {
    return this.done[meal]?.[day.name] ?? [];
  }
}
