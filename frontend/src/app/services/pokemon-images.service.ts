import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class PokemonImagesService {
  constructor() {}

  getPokeImage(numero: number): string {
    let urlPokemonImage: string =
      'https://assets.pokemon.com/assets/cms2/img/pokedex/full/';
    if (numero < 10) {
      urlPokemonImage += `00${numero}.png`;
    } else if (numero >= 10 && numero < 100) {
      urlPokemonImage += `0${numero}.png`;
    } else if (numero >= 100) {
      urlPokemonImage += `${numero}.png`;
    }
    return urlPokemonImage;
  }
}
