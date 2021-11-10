import { Injectable } from '@angular/core';
// Have http client and observable again for testing and access
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
// Test endpoint?
const API_URL = 'http://localhost:8080/api/test/';

@Injectable({
  providedIn: 'root'
})
// Gives access based on role -- public < user < moderator < admin
export class UserService {
  constructor(private http: HttpClient) { }

    getPublicContent(): Observable<any> {
      return this.http.get(API_URL + 'all', { responseType: 'text' });
    }

    getUserBoard(): Observable<any> {
      return this.http.get(API_URL + 'user', { responseType: 'text' });
    }

    getAdminBoard(): Observable<any> {
      return this.http.get(API_URL + 'admin', { responseType: 'text' });
    }
}
