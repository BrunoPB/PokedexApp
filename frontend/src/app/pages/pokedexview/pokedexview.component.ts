import { Component, OnInit, ViewChild } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MatTable } from '@angular/material/table';
import { Pokemon } from 'src/app/interfaces/pokemon.model';
import { DeletePokemonService } from 'src/app/services/delete-pokemon.service';
import { PokemonService } from 'src/app/services/pokemon.service';
import { RetrievePokeInfoService } from 'src/app/services/retrieve-poke-info.service';
import { PokemonViewComponent } from './pokemon-view/pokemon-view.component';

@Component({
  selector: 'app-pokedexview',
  templateUrl: './pokedexview.component.html',
  styleUrls: ['./pokedexview.component.css'],
})
export class PokedexViewComponent implements OnInit {
  tablePokes: Pokemon[];
  displayedColumns = ['imagem', 'nome', 'numero', 'regiao', 'edit'];

  @ViewChild(MatTable) table: MatTable<Pokemon>;

  constructor(
    private pokeService: PokemonService,
    private pokeimages: RetrievePokeInfoService,
    private dialog: MatDialog,
    private deletepoke: DeletePokemonService
  ) {}

  ngOnInit(): void {
    this.pokeService.getPokemons().subscribe((pokes) => {
      this.tablePokes = pokes;
    });

    this.deletepoke.deletePokeObs.subscribe((numero) => {
      if (numero != 0) this.deletePoke(numero);
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
    for (let i = 0; i < this.tablePokes.length; i++) {
      if (this.tablePokes[i].numero === numero) {
        this.tablePokes.splice(i, 1);
        i = this.tablePokes.length;
        this.table.renderRows();
      }
    }
  }
}
