export interface Pokemon {
  id: number;
  numero: number;
  nome: string;
  tipo1: string;
  tipo2?: string;
  hp: number;
  attack: number;
  defense: number;
  spatk: number;
  spdef: number;
  speed: number;
  mega: boolean;
  lendario: boolean;
  regiao: string;
}
