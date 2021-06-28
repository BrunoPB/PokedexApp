import { Component, OnInit } from '@angular/core';
import { Usuario } from 'src/interfaces/usuario.model';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent implements OnInit {
  usuario: Usuario = {
    id: 0,
    nome: '',
    senha: '',
  };

  constructor() {}

  ngOnInit(): void {}

  onSubmit() {
    console.log(this.usuario);
  }
}
