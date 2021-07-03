export interface Pokemon {
  numero: number;
  nome: string;
  tipo1: string;
  tipo2?: string;
  hp: number;
  attack: number;
  defense: number;
  spAtk: number;
  spDef: number;
  speed: number;
  mega: boolean;
  lendario: boolean;
  regiao: string;
}
