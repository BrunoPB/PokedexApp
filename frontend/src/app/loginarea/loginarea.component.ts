import { Component, OnInit } from '@angular/core';

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
  constructor() {}

  ngOnInit(): void {}
}
