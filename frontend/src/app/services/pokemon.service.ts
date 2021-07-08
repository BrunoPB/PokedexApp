import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Pokemon } from '../interfaces/pokemon.model';

@Injectable({
  providedIn: 'root',
})
export class PokemonService {
  constructor(private http: HttpClient) {}

  readonly url: string = environment.urlBack;

  getPokemons(): Observable<Pokemon[]> {
    return this.http.get<Pokemon[]>(`${this.url}/pokemons`);
  }
}
