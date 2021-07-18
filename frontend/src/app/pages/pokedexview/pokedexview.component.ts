import { Component, ViewChild } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MatSort } from '@angular/material/sort';
import { MatTable, MatTableDataSource } from '@angular/material/table';
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
export class PokedexViewComponent {
  tableSource;
  fullTablePokes: Pokemon[];
  filteredTablePokes: Pokemon[];
  displayedColumns = ['imagem', 'nome', 'numero', 'regiao', 'edit'];
  nRegiao: number[] = [0, 0, 0, 0, 0, 0, 0, 0];
  nLegendaries: number = 0;
  totalPokemons: number = 0;
  user: Usuario;
  innerRegion: string = 'Any';
  innerType: string = 'Any';
  innerMega: boolean = false;
  innerLegendary: boolean = false;

  @ViewChild(MatTable) table: MatTable<Pokemon>;

  constructor(
    private pokeService: PokemonService,
    private pokeimages: RetrievePokeInfoService,
    private dialog: MatDialog,
    private bsService: BehaviorSubjectService,
    private userService: UsuarioService
  ) {
    this.pokeService.getUserPokemons().subscribe((pokes) => {
      this.fullTablePokes = pokes;
      this.filteredTablePokes = this.fullTablePokes;
      this.filteredTablePokes.sort((n1: Pokemon, n2: Pokemon) => {
        return n1.numero - n2.numero;
      });
      this.countPokes();
      this.tableSource = new MatTableDataSource(this.filteredTablePokes);
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
    for (let i = 0; i < this.filteredTablePokes.length; i++) {
      if (this.filteredTablePokes[i].numero === numero) {
        this.filteredTablePokes.splice(i, 1);
        i = this.filteredTablePokes.length;
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
    for (let i: number = 0; i < this.fullTablePokes.length; i++) {
      let p: Pokemon = this.fullTablePokes[i];
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
    this.totalPokemons = this.fullTablePokes.length;
  }

  searchPokemon(event: Event) {
    const filtro = (event.target as HTMLInputElement).value;
    this.tableSource.filter = filtro.trim().toLowerCase();
  }

  filter() {
    this.filteredTablePokes = this.regionFilter(
      this.typeFilter(
        this.megaFilter(this.legendaryFilter(this.fullTablePokes))
      )
    );
    this.filteredTablePokes.sort((n1: Pokemon, n2: Pokemon) => {
      return n1.numero - n2.numero;
    });
    this.tableSource = new MatTableDataSource(this.filteredTablePokes);
  }

  regionFilter(table: Pokemon[]): Pokemon[] {
    if (this.innerRegion == 'Any') {
      return table;
    } else {
      let newTable: Pokemon[] = [];
      for (let i = 0; i < table.length; i++) {
        if (table[i].regiao === this.innerRegion) {
          newTable.push(table[i]);
        }
      }
      return newTable;
    }
  }

  typeFilter(table: Pokemon[]): Pokemon[] {
    if (this.innerType == 'Any') {
      return table;
    } else {
      let newTable: Pokemon[] = [];
      for (let i = 0; i < table.length; i++) {
        if (
          table[i].tipo1 === this.innerType ||
          table[i].tipo2 === this.innerType
        ) {
          newTable.push(table[i]);
        }
      }
      return newTable;
    }
  }

  megaFilter(table: Pokemon[]): Pokemon[] {
    if (this.innerMega) {
      let newTable: Pokemon[] = [];
      for (let i = 0; i < table.length; i++) {
        if (table[i].mega) {
          newTable.push(table[i]);
        }
      }
      return newTable;
    } else {
      return table;
    }
  }

  legendaryFilter(table: Pokemon[]): Pokemon[] {
    if (this.innerLegendary) {
      let newTable: Pokemon[] = [];
      for (let i = 0; i < table.length; i++) {
        if (table[i].lendario) {
          newTable.push(table[i]);
        }
      }
      return newTable;
    } else {
      return table;
    }
  }
}
