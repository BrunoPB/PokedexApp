import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class RetrievePokeInfoService {
  constructor() {}

  private getImage(numero: number): string {
    let urlPokemonImage: string =
      'https://assets.pokemon.com/assets/cms2/img/pokedex/full/';
    if (numero < 10) {
      urlPokemonImage += `00${numero}`;
    } else if (numero >= 10 && numero < 100) {
      urlPokemonImage += `0${numero}`;
    } else if (numero >= 100) {
      urlPokemonImage += `${numero}`;
    }
    return urlPokemonImage;
  }

  getPokeImage(numero: number): string {
    return `${this.getImage(numero)}.png`;
  }

  getMegaImage(numero: number) {
    return `${this.getImage(numero)}_f2.png`;
  }
}
