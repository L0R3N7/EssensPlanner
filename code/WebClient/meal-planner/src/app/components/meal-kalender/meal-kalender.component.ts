import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-meal-kalender',
  templateUrl: './meal-kalender.component.html',
  styleUrls: ['./meal-kalender.component.scss']
})
export class MealKalenderComponent implements OnInit {
  @Input() selectedDate : Date = new Date();

  constructor() { }

  ngOnInit(): void {
  }

}
