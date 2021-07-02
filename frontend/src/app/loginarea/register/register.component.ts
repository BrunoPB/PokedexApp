import { Component, OnInit } from '@angular/core';
import { Usuario } from 'src/app/interfaces/usuario.model';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css'],
})
export class RegisterComponent implements OnInit {
  usuario: Usuario = {
    id: 1,
    nome: '',
    senha: '',
  };
  confirmSenha: string = '';

  constructor() {}

  ngOnInit(): void {}

  onSubmit() {
    console.log(this.usuario);
  }
}
