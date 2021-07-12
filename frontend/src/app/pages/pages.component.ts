import { Component, OnInit } from '@angular/core';
import { RetrievePokeInfoService } from '../services/retrieve-poke-info.service';
import { UsuarioService } from '../services/usuario.service';

@Component({
  selector: 'app-pages',
  templateUrl: './pages.component.html',
  styleUrls: ['./pages.component.css'],
})
export class PagesComponent implements OnInit {
  pokeBackground: string =
    "background-image: url('../../assets/imgs/neutral-background.jpg');";

  constructor(
    private userService: UsuarioService,
    private pokeinfo: RetrievePokeInfoService
  ) {
    this.setPokeBackground();
  }

  ngOnInit(): void {}

  setPokeBackground() {
    this.userService
      .getUsuarioByName(window.localStorage.getItem('token'))
      .subscribe((user) => {
        if (user.pokPerfil !== null) {
          this.pokeBackground = `background-image: url('${this.pokeinfo.getPokeImage(
            user.pokPerfil
          )}');`;
        }
      });
  }
}
