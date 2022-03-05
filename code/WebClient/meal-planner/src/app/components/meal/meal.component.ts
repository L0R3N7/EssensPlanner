import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-meal',
  templateUrl: './meal.component.html',
  styleUrls: ['./meal.component.scss']
})

export class MealComponent implements OnInit {

  image_url: string = "https://www.horizont.net/news/media/32/Junk-Food-312269-detailnp.jpeg";
  name: string = "Burger mit Steakpommes";
  rating: number = 4.9;
  expanded: boolean = true;


  constructor() { }

  ngOnInit(): void {

  }

  toggleExpand():void{
    this.expanded = !this.expanded;
  }

}

