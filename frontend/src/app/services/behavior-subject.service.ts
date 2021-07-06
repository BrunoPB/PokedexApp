import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class BehaviorSubjectService {
  deletePokeBS = new BehaviorSubject(0);
  deletePokeObs = this.deletePokeBS.asObservable();

  constructor() {}
}
