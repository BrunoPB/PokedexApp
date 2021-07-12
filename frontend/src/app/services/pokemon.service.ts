import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Pokemon } from '../interfaces/pokemon.model';

@Injectable({
  providedIn: 'root',
})
export class PokemonService {
  username = window.localStorage.getItem('token');

  constructor(private http: HttpClient) {}

  readonly urlPokes: string = `${environment.urlBack}/pokemons`;
  readonly urlRelac: string = `${environment.urlBack}/usuarios/relacionamento`;

  getPokemons(): Observable<Pokemon[]> {
    return this.http.get<Pokemon[]>(this.urlPokes);
  }

  getUserPokemons(): Observable<Pokemon[]> {
    return this.http.get<Pokemon[]>(
      `${this.urlRelac}/usuario/nome/${this.username}`
    );
  }

  getPokemonByNumber(numero: number): Observable<Pokemon> {
    return this.http.get<Pokemon>(`${this.urlPokes}/number/${numero}`);
  }

  getPokemonByName(nome: string): Observable<Pokemon> {
    return this.http.get<Pokemon>(`${this.urlPokes}/name/${nome}`);
  }
}
