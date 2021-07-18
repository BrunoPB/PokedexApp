import { Component, OnInit } from '@angular/core';
import { Usuario } from '../interfaces/usuario.model';
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
  userID = window.localStorage.getItem('token');
  username: string;
  user: Usuario;

  constructor(
    private userService: UsuarioService,
    private pokeinfo: RetrievePokeInfoService
  ) {
    this.userService.getUsuarioByID(this.userID).subscribe((user) => {
      this.user = user;
      this.username = this.user.nome;
      this.setPokeBackground();
    });
  }

  ngOnInit(): void {}

  setPokeBackground() {
    if (this.user.pokPerfil !== null) {
      if (this.user.pokPerfil > 1000) {
        this.pokeBackground = `background-image: url('${this.pokeinfo.getMegaImage(
          this.user.pokPerfil - 1000
        )}');`;
      } else {
        this.pokeBackground = `background-image: url('${this.pokeinfo.getPokeImage(
          this.user.pokPerfil
        )}');`;
      }
    }
  }
}
