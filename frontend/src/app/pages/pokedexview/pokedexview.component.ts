import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { Pokemon } from 'src/app/interfaces/pokemon.model';
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

  constructor(
    private pokeService: PokemonService,
    private pokeimages: RetrievePokeInfoService,
    private dialog: MatDialog
  ) {}

  ngOnInit(): void {
    this.pokeService.getPokemons().subscribe((pokes) => {
      this.tablePokes = pokes;
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
}
