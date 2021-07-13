import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Relacionamento } from '../interfaces/relacionamento.model';
import { Usuario } from '../interfaces/usuario.model';

@Injectable({
  providedIn: 'root',
})
export class UsuarioService {
  constructor(private http: HttpClient) {}

  idUser = window.localStorage.getItem('token');

  readonly url: string = `${environment.urlBack}/usuarios`;
  readonly urlRelac: string = `${this.url}/relacionamento`;

  getUsuarios(): Observable<Usuario[]> {
    return this.http.get<Usuario[]>(this.url);
  }

  getUsuarioByName(nome: string): Observable<Usuario> {
    return this.http.get<Usuario>(`${this.url}/nome/${nome}`);
  }

  getUsuarioByID(id: string): Observable<Usuario> {
    return this.http.get<Usuario>(`${this.url}/id/${id}`);
  }

  postUsuario(user: Usuario): Observable<Usuario> {
    return this.http.post<Usuario>(this.url, user);
  }

  putUsuario(user: Usuario): Observable<Usuario> {
    return this.http.put<Usuario>(this.url, user);
  }

  postRelacionamento(nPokemon: number): Observable<Usuario> {
    return this.http.post<Usuario>(
      `${this.urlRelac}?idUser=${this.idUser}&nPoke=${nPokemon}`,
      { idUser: this.idUser, nPoke: nPokemon }
    );
  }

  deleteRelacionamento(nPoke: number): Observable<Usuario> {
    return this.http.delete<Usuario>(
      `${this.urlRelac}/deletepokemon/${nPoke}/from/${this.idUser}`
    );
  }
}
