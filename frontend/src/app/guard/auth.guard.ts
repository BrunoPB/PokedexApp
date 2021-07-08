import { Injectable } from '@angular/core';
import {
  ActivatedRouteSnapshot,
  CanActivate,
  Router,
  RouterStateSnapshot,
} from '@angular/router';

@Injectable({
  providedIn: 'root',
})
export class AuthGuard implements CanActivate {
  constructor(private router: Router) {}

  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot
  ): boolean {
    let auth: boolean = true;
    const storage = window.localStorage;
    if (storage.length < 1 || !storage.getItem('token')) {
      auth = false;
      this.router.navigateByUrl('/loginarea');
    }
    return auth;
  }
}
