import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-loginarea',
  template: `
    <div class="backgroundImage">
      <router-outlet></router-outlet>
    </div>
  `,
  styles: [
    `
      .backgroundImage {
        background-image: url('./assets/imgs/pokeball-background.jpg');
        background-repeat: no-repeat;
        background-size: cover;
        background-position: center;
        height: 100%;
      }
    `,
  ],
})
export class LoginareaComponent implements OnInit {
  constructor(private router: Router) {}

  ngOnInit(): void {
    if (window.localStorage.getItem('token')) {
      this.router.navigateByUrl('');
    }
  }
}
