import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddPokemonComponent } from './addpokemon/addpokemon.component';
import { PagesComponent } from './pages.component';
import { PokedexViewComponent } from './pokedexview/pokedexview.component';
import { PokemonViewComponent } from './pokemonview/pokemonview.component';
import { ProfileComponent } from './profile/profile.component';

const routes: Routes = [
  {
    path: '',
    component: PagesComponent,
    children: [
      {
        path: '',
        redirectTo: 'pokedex',
        pathMatch: 'full',
      },
      {
        path: 'pokedex',
        component: PokedexViewComponent,
      },
      {
        path: 'profile',
        component: ProfileComponent,
      },
      {
        path: 'pokemon/:id',
        component: PokemonViewComponent,
      },
      {
        path: 'add',
        component: AddPokemonComponent,
      },
    ],
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class PagesRoutingModule {}
