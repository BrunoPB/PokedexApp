import { Pokemon } from './pokemon.model';

export interface Usuario {
  id: number;
  nome: string;
  senha: string;
  pokperfil?: number;
  pokemons?: Pokemon[];
}
