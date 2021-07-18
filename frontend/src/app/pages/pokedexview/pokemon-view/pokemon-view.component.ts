import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { Pokemon } from 'src/app/interfaces/pokemon.model';
import { Usuario } from 'src/app/interfaces/usuario.model';
import { BehaviorSubjectService } from 'src/app/services/behavior-subject.service';
import { RetrievePokeInfoService } from 'src/app/services/retrieve-poke-info.service';
import { UsuarioService } from 'src/app/services/usuario.service';

@Component({
  selector: 'app-pokemon-view',
  templateUrl: './pokemon-view.component.html',
  styleUrls: ['./pokemon-view.component.css'],
})
export class PokemonViewComponent implements OnInit {
  pokemon: Pokemon = this.data.pokemon;
  user: Usuario;
  userID: string = window.localStorage.getItem('token');

  constructor(
    private dialogRef: MatDialogRef<PokemonViewComponent>,
    @Inject(MAT_DIALOG_DATA) private data: { pokemon: Pokemon },
    private pokeinfo: RetrievePokeInfoService,
    private bsService: BehaviorSubjectService,
    private userService: UsuarioService
  ) {}

  ngOnInit(): void {}

  out() {
    this.dialogRef.close();
  }

  getPokeImage(numero: number): string {
    return this.pokeinfo.getPokeImage(numero);
  }

  getMegaImage(numero: number): string {
    return this.pokeinfo.getMegaImage(numero);
  }

  progressBarCalculation(q: number, stat: string): number {
    let n: number = q;
    switch (stat) {
      case 'hp':
        n = (99 / (255 - 1)) * q;
        break;
      case 'atk':
        n = (99 / (181 - 5)) * q;
        break;
      case 'def':
        n = (99 / (230 - 5)) * q;
        break;
      case 'spa':
        n = (99 / (173 - 10)) * q;
        break;
      case 'spd':
        n = (99 / (230 - 20)) * q;
        break;
      case 'spe':
        n = (99 / (200 - 5)) * q;
        break;
      default:
        break;
    }
    return n;
  }

  typeColor(type: string): string {
    let color: string = 'background-color: ';
    switch (type) {
      case 'Normal':
        color += '#A8A878';
        break;
      case 'Fire':
        color += '#F08030';
        break;
      case 'Fighting':
        color += '#C03028';
        break;
      case 'Water':
        color += '#6890F0';
        break;
      case 'Flying':
        color += '#A890F0';
        break;
      case 'Grass':
        color += '#78C850';
        break;
      case 'Poison':
        color += '#A040A0';
        break;
      case 'Electric':
        color += '#D8B010';
        break;
      case 'Ground':
        color += '#D0B058';
        break;
      case 'Psychic':
        color += '#F85888';
        break;
      case 'Rock':
        color += '#B8A038';
        break;
      case 'Ice':
        color += '#98D8D8';
        break;
      case 'Bug':
        color += '#A8B820';
        break;
      case 'Dragon':
        color += '#7038F8';
        break;
      case 'Ghost':
        color += '#705898';
        break;
      case 'Dark':
        color += '#705848';
        break;
      case 'Steel':
        color += '#9898B0';
        break;
      case 'Fairy':
        color += '#EE99AC';
        break;
      default:
        break;
    }
    return `${color};`;
  }

  changePokPerfil(mega: boolean) {
    this.userService.getUsuarioByID(this.userID).subscribe((user) => {
      this.user = user;
      mega
        ? (user.pokPerfil = this.pokemon.numero + 1000)
        : (this.user.pokPerfil = this.pokemon.numero);
      this.userService.putUsuario(this.user).subscribe();
      window.location.reload();
    });
  }

  deletePokemon(numero: number) {
    this.bsService.deletePokeBS.next(numero);
    this.out();
  }
}
