import { Component, OnInit } from '@angular/core';
import { Pokemon } from 'src/app/interfaces/pokemon.model';
import { PokemonImagesService } from 'src/app/services/pokemon-images.service';
import { PokemonService } from 'src/app/services/pokemon.service';

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
    private pokeimages: PokemonImagesService
  ) {}

  ngOnInit(): void {
    this.pokeService.getPokemons().subscribe((pokes) => {
      this.tablePokes = pokes;
    });
  }

  getPokeImage(numero: number): string {
    return this.pokeimages.getPokeImage(numero);
  }

  testclickrow(nome: string) {
    console.log(`Coluna pokemon: ${nome}`);
  }
}
