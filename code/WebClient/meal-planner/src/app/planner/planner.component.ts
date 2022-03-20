import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-planner',
  templateUrl: './planner.component.html',
  styleUrls: ['./planner.component.scss']
})
export class PlannerComponent implements OnInit {
  sidebar_icon:string[] = ["search", "close"];
  sidebar_icon_state:number = 0;

  constructor() { }

  ngOnInit(): void {
  }

  sidebar_closed() {
    this.sidebar_icon_state = 0;
  }

  sidebar_opened() {
    this.sidebar_icon_state = 1;
  }
}
