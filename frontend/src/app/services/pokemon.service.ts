import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Pokemon } from '../interfaces/pokemon.model';

@Injectable({
  providedIn: 'root',
})
export class PokemonService {
  constructor(private http: HttpClient) {}

  readonly url: string = 'http://localhost:8080';

  getPokemons(): Observable<Pokemon[]> {
    return this.http.get<Pokemon[]>(`${this.url}/pokemons`);
  }
}
