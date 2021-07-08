import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { Usuario } from 'src/app/interfaces/usuario.model';
import { LoginService } from 'src/app/services/login.service';

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

  constructor(
    private loginService: LoginService,
    private router: Router,
    private snackBar: MatSnackBar
  ) {}

  ngOnInit(): void {}

  onSubmit() {
    this.loginService
      .login(this.usuario.nome, this.usuario.senha)
      .then((msg) => {
        this.snackBar.open(`Bem-vindo, ${this.usuario.nome}!`, 'X', {
          duration: 2000,
        });
        this.router.navigateByUrl('');
      })
      .catch((err) => {
        this.snackBar.open(err, 'X', {
          duration: 5000,
        });
        this.usuario.senha = '';
      });
  }
}
