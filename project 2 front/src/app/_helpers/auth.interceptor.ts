// Helps handle and transform requests
import { HTTP_INTERCEPTORS, HttpEvent } from '@angular/common/http';
// Decorator that marks a class as available to be provided and injected
import { Injectable } from '@angular/core';
// HTTP requests again
import { HttpInterceptor, HttpHandler, HttpRequest } from '@angular/common/http';
// Going to use our token storage
import { TokenStorageService } from '../_services/token-storage.service';
import { Observable } from 'rxjs';
// For Spring Boot back-end
const TOKEN_HEADER_KEY = 'Authorization';       

@Injectable()
// Handles HTTP authentication requests and responses
export class AuthInterceptor implements HttpInterceptor {
  constructor(private token: TokenStorageService) { }
// Getts HTTP request, changes it and sends it to the handler. That transforms it into an observable event
    intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
        let authReq = req;
        const token = this.token.getToken();
        if (token != null) {
            authReq = req.clone({ headers: req.headers.set(TOKEN_HEADER_KEY, 'Bearer ' + token) });
        }
        return next.handle(authReq);
    }
}

export const authInterceptorProviders = [
    { provide: HTTP_INTERCEPTORS, useClass: AuthInterceptor, multi: true }
];
