import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { PagesRoutingModule } from './pages-routing.module';
import { PokedexViewComponent } from './pokedexview/pokedexview.component';
import { ProfileComponent } from './profile/profile.component';
import { AddPokemonComponent } from './addpokemon/addpokemon.component';
import { PokemonViewComponent } from './pokemonview/pokemonview.component';
import { PagesComponent } from './pages.component';

@NgModule({
  declarations: [
    PokedexViewComponent,
    ProfileComponent,
    AddPokemonComponent,
    PokemonViewComponent,
    PagesComponent,
  ],
  imports: [CommonModule, PagesRoutingModule],
})
export class PagesModule {}
