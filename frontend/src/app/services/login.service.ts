import { Injectable } from '@angular/core';
import { Usuario } from '../interfaces/usuario.model';
import { UsuarioService } from './usuario.service';

@Injectable({
  providedIn: 'root',
})
export class LoginService {
  user: Usuario;

  constructor(private userService: UsuarioService) {}

  async login(nome: string, senha: string): Promise<string> {
    let msg: string = 'OK';
    this.user = await this.userService.getUsuarioByName(nome).toPromise();
    if (this.user === null) msg = 'Nome de Usuário não encontrado.';
    else {
      if (this.user.senha !== senha) msg = 'Senha errada.';
    }
    if (msg === 'OK') {
      window.localStorage.setItem('token', this.user.id.toString());
    }
    return new Promise<string>((res, rej) => {
      if (msg === 'OK') {
        res(msg);
      } else {
        rej(msg);
      }
    });
  }

  async existUser(nome: string): Promise<void> {
    this.user = await this.userService.getUsuarioByName(nome).toPromise();
    return new Promise<void>((res, rej) => {
      if (this.user !== null) res();
      else rej();
    });
  }
}
