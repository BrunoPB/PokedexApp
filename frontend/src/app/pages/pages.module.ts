import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { PagesRoutingModule } from './pages-routing.module';
import { PokedexViewComponent } from './pokedexview/pokedexview.component';
import { ProfileComponent } from './profile/profile.component';
import { AddPokemonComponent } from './addpokemon/addpokemon.component';
import { PagesComponent } from './pages.component';
import { MaterialModule } from '../material.module';
import { PokemonViewComponent } from './pokedexview/pokemon-view/pokemon-view.component';

@NgModule({
  declarations: [
    PokedexViewComponent,
    ProfileComponent,
    AddPokemonComponent,
    PagesComponent,
    PokemonViewComponent,
  ],
  imports: [CommonModule, PagesRoutingModule, MaterialModule],
})
export class PagesModule {}
