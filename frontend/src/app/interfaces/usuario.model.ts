import { Pokemon } from './pokemon.model';

export interface Usuario {
  id?: number;
  nome: string;
  senha: string;
  pokPerfil?: number;
  pokemons?: Pokemon[];
}
