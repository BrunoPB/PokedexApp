import { Component, OnInit, ViewChild } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MatTable } from '@angular/material/table';
import { Pokemon } from 'src/app/interfaces/pokemon.model';
import { Usuario } from 'src/app/interfaces/usuario.model';
import { BehaviorSubjectService } from 'src/app/services/behavior-subject.service';
import { PokemonService } from 'src/app/services/pokemon.service';
import { RetrievePokeInfoService } from 'src/app/services/retrieve-poke-info.service';
import { UsuarioService } from 'src/app/services/usuario.service';
import { PokemonViewComponent } from './pokemon-view/pokemon-view.component';

@Component({
  selector: 'app-pokedexview',
  templateUrl: './pokedexview.component.html',
  styleUrls: ['./pokedexview.component.css'],
})
export class PokedexViewComponent implements OnInit {
  tablePokes: Pokemon[];
  displayedColumns = ['imagem', 'nome', 'numero', 'regiao', 'edit'];
  nRegiao: number[] = [0, 0, 0, 0, 0, 0, 0, 0];
  nLegendaries: number = 0;
  totalPokemons: number = 0;
  user: Usuario;

  @ViewChild(MatTable) table: MatTable<Pokemon>;

  constructor(
    private pokeService: PokemonService,
    private pokeimages: RetrievePokeInfoService,
    private dialog: MatDialog,
    private bsService: BehaviorSubjectService,
    private userService: UsuarioService
  ) {
    this.pokeService.getUserPokemons().subscribe((pokes) => {
      this.tablePokes = pokes;
      this.countPokes();
    });

    this.bsService.deletePokeObs.subscribe((numero) => {
      if (numero != 0) this.deletePoke(numero);
    });

    this.userService
      .getUsuarioByID(window.localStorage.getItem('token'))
      .subscribe((userP) => {
        this.user = userP;
      });
  }

  ngOnInit(): void {}

  getPokeImage(numero: number): string {
    return this.pokeimages.getPokeImage(numero);
  }

  openDialog(pokemon: Pokemon) {
    this.dialog.open(PokemonViewComponent, {
      panelClass: 'custom-dialog-container',
      data: { pokemon: pokemon },
    });
  }

  deletePoke(numero: number) {
    this.userService.deleteRelacionamento(numero).subscribe();
    for (let i = 0; i < this.tablePokes.length; i++) {
      if (this.tablePokes[i].numero === numero) {
        this.tablePokes.splice(i, 1);
        i = this.tablePokes.length;
        this.table.renderRows();
      }
    }
    this.countPokes();
    if (numero === this.user.pokPerfil) {
      this.user.pokPerfil = null;
      this.userService.putUsuario(this.user).subscribe();
      window.location.reload();
    }
  }

  countPokes() {
    for (let i = 0; i < this.nRegiao.length; i++) {
      this.nRegiao[i] = 0;
    }
    this.nLegendaries = 0;
    for (let i: number = 0; i < this.tablePokes.length; i++) {
      let p: Pokemon = this.tablePokes[i];
      switch (p.regiao) {
        case 'Kanto':
          this.nRegiao[0]++;
          break;
        case 'Johto':
          this.nRegiao[1]++;
          break;
        case 'Hoenn':
          this.nRegiao[2]++;
          break;
        case 'Sinnoh':
          this.nRegiao[3]++;
          break;
        case 'Unova':
          this.nRegiao[4]++;
          break;
        case 'Kalos':
          this.nRegiao[5]++;
          break;
        case 'Alola':
          this.nRegiao[6]++;
          break;
        case 'Galar':
          this.nRegiao[7]++;
          break;
      }
      if (p.lendario) {
        this.nLegendaries++;
      }
    }
    this.totalPokemons = this.tablePokes.length;
  }
}
