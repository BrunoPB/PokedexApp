import { Component, OnInit } from '@angular/core';
import { Pokemon } from 'src/app/interfaces/pokemon.model';
import { PokemonService } from 'src/app/services/pokemon.service';
import { RetrievePokeInfoService } from 'src/app/services/retrieve-poke-info.service';
import { UsuarioService } from 'src/app/services/usuario.service';

@Component({
  selector: 'app-addpokemon',
  templateUrl: './addpokemon.component.html',
  styleUrls: ['./addpokemon.component.css'],
})
export class AddPokemonComponent implements OnInit {
  pokemon: Pokemon;
  pokeDatabase: Pokemon[];
  userPokemons: Pokemon[];
  existsPokemon: boolean = false;
  image: string = '';
  innerSearch: string = '';
  alreadyHave: boolean;
  haveAll: boolean;

  constructor(
    private pokeService: PokemonService,
    private pokeImage: RetrievePokeInfoService,
    private userService: UsuarioService
  ) {
    pokeService.getPokemons().subscribe((pokes) => {
      this.pokeDatabase = pokes;
      pokeService.getUserPokemons().subscribe((pokes) => {
        this.userPokemons = pokes;
        if (this.userPokemons.length == this.pokeDatabase.length) {
          this.haveAll = true;
        } else {
          this.haveAll = false;
        }
      });
    });
  }

  ngOnInit(): void {}

  private tryAlreadyHave(numero: number): boolean {
    const have = this.userPokemons.find((poke) => {
      return poke.numero === numero;
    });
    return (this.alreadyHave = have !== undefined);
  }

  private testExistance(nome: string): boolean {
    const exists = this.pokeDatabase.find((poke) => {
      return poke.nome === nome;
    });
    return (this.existsPokemon = exists !== undefined);
  }

  findPokemonByName() {
    if (this.testExistance(this.innerSearch)) {
      this.pokeService.getPokemonByName(this.innerSearch).subscribe((poke) => {
        this.pokemon = poke;
        this.image = this.pokeImage.getPokeImage(this.pokemon.numero);
        this.existsPokemon = true;
        this.tryAlreadyHave(this.pokemon.numero);
      });
    }
  }

  findRandomPokemon() {
    let quit = false;
    let n;
    while (!quit) {
      n = Math.floor(Math.random() * (890 - 1)) + 1;
      if (!this.tryAlreadyHave(n)) {
        quit = true;
      }
    }
    this.pokeService.getPokemonByNumber(n).subscribe((poke) => {
      this.pokemon = poke;
      this.image = this.pokeImage.getPokeImage(this.pokemon.numero);
      this.existsPokemon = true;
    });
  }

  addPokemon() {
    this.userService.postRelacionamento(this.pokemon.numero).subscribe();
    window.location.reload();
  }
}
