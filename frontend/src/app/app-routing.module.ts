import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginareaComponent } from './loginarea/loginarea.component';

const routes: Routes = [
  {
    path: '',
    redirectTo: 'loginarea',
    pathMatch: 'full',
  },
  {
    path: 'loginarea',
    loadChildren: () =>
      import('./loginarea/loginarea.module').then((m) => m.LoginareaModule),
  },
  {
    path: 'pages',
    loadChildren: () =>
      import('./pages/pages.module').then((m) => m.PagesModule),
  },
  {
    path: '**',
    redirectTo: 'loginarea',
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
