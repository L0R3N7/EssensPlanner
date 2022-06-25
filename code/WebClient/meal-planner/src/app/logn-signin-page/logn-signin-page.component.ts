import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup} from "@angular/forms";

@Component({
  selector: 'app-logn-signin-page',
  templateUrl: './logn-signin-page.component.html',
  styleUrls: ['./logn-signin-page.component.scss']
})
export class LognSigninPageComponent implements OnInit {
  isLog : boolean = true;

  loginForm = new FormGroup({
    username : new FormControl(''),
    password : new FormControl(''),
  });

  constructor() {
  }

  ngOnInit(): void {
  }

  login() {
    alert("success")
    console.log(this.loginForm.value)
  }
}
