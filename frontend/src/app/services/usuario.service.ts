import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Usuario } from '../interfaces/usuario.model';

@Injectable({
  providedIn: 'root',
})
export class UsuarioService {
  constructor(private http: HttpClient) {}

  readonly url: string = environment.urlBack;

  getUsuarios(): Observable<Usuario[]> {
    return this.http.get<Usuario[]>(`${this.url}/usuarios`);
  }

  getUsuarioByName(nome: string): Observable<Usuario> {
    return this.http.get<Usuario>(`${this.url}/usuarios/nome/${nome}`);
  }

  postUsuario(user: Usuario): Observable<Usuario> {
    return this.http.post<Usuario>(`${this.url}/usuarios`, user);
  }
}
