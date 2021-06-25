import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { LoginareaRoutingModule } from './loginarea-routing.module';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { LoginareaComponent } from './loginarea.component';
import { MaterialModule } from '../material.module';

@NgModule({
  declarations: [LoginComponent, RegisterComponent, LoginareaComponent],
  imports: [CommonModule, LoginareaRoutingModule, MaterialModule],
})
export class LoginareaModule {}
