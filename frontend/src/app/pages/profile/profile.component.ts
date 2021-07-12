import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { Pokemon } from 'src/app/interfaces/pokemon.model';
import { Usuario } from 'src/app/interfaces/usuario.model';
import { PokemonService } from 'src/app/services/pokemon.service';
import { RetrievePokeInfoService } from 'src/app/services/retrieve-poke-info.service';
import { UsuarioService } from 'src/app/services/usuario.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css'],
})
export class ProfileComponent implements OnInit {
  user: Usuario;
  pokPerfilExists: boolean = false;
  pokPerfilImage: string;
  pokPerfilName: string;
  innerPokPerfil: string = '';
  userPokemons: Pokemon[];

  constructor(
    private router: Router,
    private userService: UsuarioService,
    private pokeinfo: RetrievePokeInfoService,
    private pokeService: PokemonService,
    private snackBar: MatSnackBar
  ) {
    this.userService
      .getUsuarioByName(window.localStorage.getItem('token'))
      .subscribe((user) => {
        this.user = user;
        this.setPokPerfilImage();
        this.setPokPerfilName();
      });
    this.pokeService.getUserPokemons().subscribe((pokes) => {
      this.userPokemons = pokes;
    });
  }

  ngOnInit(): void {}

  setPokPerfilImage() {
    if (this.user.pokPerfil !== null) {
      this.pokPerfilImage = this.pokeinfo.getPokeImage(this.user.pokPerfil);
      this.pokPerfilExists = true;
    }
  }

  setPokPerfilName() {
    if (this.user.pokPerfil !== null) {
      this.pokeService
        .getPokemonByNumber(this.user.pokPerfil)
        .subscribe((poke) => {
          this.pokPerfilName = poke.nome;
        });
    }
  }

  changePokperfil() {
    let hasPoke: boolean = true;
    let pokemon: Pokemon;
    if (this.innerPokPerfil === '') {
      this.user.pokPerfil = null;
    } else {
      pokemon = this.user.pokemons.find((poke) => {
        return poke.nome === this.innerPokPerfil;
      });
      if (pokemon !== undefined) {
        this.user.pokPerfil = pokemon.numero;
      } else {
        hasPoke = false;
      }
    }
    if (hasPoke) {
      this.userService.putUsuario(this.user).subscribe();
      window.location.reload();
    } else {
      this.snackBar.open("You don't have this Pokemon.", 'X', {
        duration: 3000,
      });
    }
  }

  logout() {
    window.localStorage.clear();
    this.router.navigateByUrl('/loginarea');
  }
}
