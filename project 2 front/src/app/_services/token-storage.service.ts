import { Injectable } from '@angular/core';

const TOKEN_KEY = 'auth-token';
const USER_KEY = 'auth-user';

@Injectable({
  providedIn: 'root'
})
// Manages token and user information (email, roles?) inside browser’s session storage
export class TokenStorageService {
  constructor() { }
// Clears sessions storage
  signOut(): void {
    window.sessionStorage.clear();
  }
// Save/replace the token in storage
  public saveToken(token: string): void {
    window.sessionStorage.removeItem(TOKEN_KEY);
    window.sessionStorage.setItem(TOKEN_KEY, token);
  }
// Get token for storage
  public getToken(): string | null {
    return window.sessionStorage.getItem(TOKEN_KEY);
  }
// Save/replace the user in storage
  public saveUser(user: any): void {
    window.sessionStorage.removeItem(USER_KEY);
    window.sessionStorage.setItem(USER_KEY, JSON.stringify(user));
  }
// Get user for storage
  public getUser(): any {
    const user = window.sessionStorage.getItem(USER_KEY);
    if (user) {
      return JSON.parse(user);
    }
    // Return nothing if user is non-null?
    return {};
  }
}
