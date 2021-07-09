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
  nome: string = '';
  senha: string = '';

  constructor(
    private loginService: LoginService,
    private router: Router,
    private snackBar: MatSnackBar
  ) {}

  ngOnInit(): void {}

  onSubmit() {
    this.loginService
      .login(this.nome, this.senha)
      .then((msg) => {
        this.snackBar.open(`Bem-vindo, ${this.nome}!`, 'X', {
          duration: 2000,
        });
        this.router.navigateByUrl('');
      })
      .catch((err) => {
        this.snackBar.open(err, 'X', {
          duration: 5000,
        });
        this.senha = '';
      });
  }
}
