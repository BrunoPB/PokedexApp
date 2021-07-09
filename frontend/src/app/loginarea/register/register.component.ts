import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { Usuario } from 'src/app/interfaces/usuario.model';
import { LoginService } from 'src/app/services/login.service';
import { UsuarioService } from 'src/app/services/usuario.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css'],
})
export class RegisterComponent implements OnInit {
  nome: string = '';
  senha: string = '';
  confirmSenha: string = '';

  constructor(
    private snackBar: MatSnackBar,
    private loginService: LoginService,
    private userService: UsuarioService,
    private router: Router
  ) {}

  ngOnInit(): void {}

  onSubmit() {
    this.validRegister().then(() => {
      let user: Usuario = {
        nome: this.nome,
        senha: this.senha,
      };
      this.userService.postUsuario(user).subscribe();
      this.router.navigateByUrl('/loginarea');
    });
  }

  async validRegister(): Promise<void> {
    let valid: boolean = true;
    await this.loginService
      .existUser(this.nome)
      .then(() => {
        valid = false;
        this.snackBar.open('Este usuário já existe.', 'X', {
          duration: 2000,
        });
        this.senha = this.confirmSenha = '';
      })
      .catch(() => {
        if (this.senha !== this.confirmSenha) {
          valid = false;
          this.snackBar.open('As senhas não coincidem.', 'X', {
            duration: 2000,
          });
          this.senha = this.confirmSenha = '';
        }
      });
    return new Promise<void>((res, rej) => {
      if (valid) res();
    });
  }
}
