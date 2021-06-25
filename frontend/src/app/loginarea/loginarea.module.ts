import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { LoginareaRoutingModule } from './loginarea-routing.module';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { LoginareaComponent } from './loginarea.component';

@NgModule({
  declarations: [LoginComponent, RegisterComponent, LoginareaComponent],
  imports: [CommonModule, LoginareaRoutingModule],
})
export class LoginareaModule {}
