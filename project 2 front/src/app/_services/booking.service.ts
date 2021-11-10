import { Injectable } from '@angular/core';
import { retry, catchError } from 'rxjs/operators';
import { Observable, throwError } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Theater } from '../theater';
import { Showing } from '../showing';
import { Ticket } from '../ticket';

@Injectable({
  providedIn: 'root'
})
export class BookingService {

  endpoint = 'http://localhost:3000';

  constructor(private httpClient: HttpClient) { }

  httpHeader = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  }

  getTheaters(): Observable<Theater>{
    return this.httpClient.get<Theater>(this.endpoint + '/theaters').pipe(
      retry(1),
      catchError(this.processError)
    )
  }
// If we want to change showings though. Probably won't be used.
  updateTheater(theaterId: number, data: any): Observable<Theater>{
    return this.httpClient.put<Theater>(this.endpoint + '/theater/' + theaterId, JSON.stringify(data)).pipe(
      retry(1),
      catchError(this.processError)
    )
  } 

  getShowingsbyId(theaterId: number): Observable<Showing>{
    return this.httpClient.get<Showing>(this.endpoint + '/showings/' + theaterId).pipe(
      retry(1),
      catchError(this.processError)
    )
  }

  updateShowing(theaterId: number, data: any): Observable<Showing>{
    return this.httpClient.put<Showing>(this.endpoint + '/showings/' + theaterId, JSON.stringify(data)).pipe(
      retry(1),
      catchError(this.processError)
    )
  }

  addTicket(userId: number, data: any): Observable<Ticket>{
    return this.httpClient.post<Ticket>(this.endpoint + '/tickets/' + userId, JSON.stringify(data), this.httpHeader)
    .pipe(
      retry(1),
      catchError(this.processError)
    )
  }

  processError(err: any) {
    let message = '';
    if(err.error instanceof ErrorEvent) {
     message = err.error.message;
    } else {
     message = `Error Code: ${err.status}\nMessage: ${err.message}`;
    }
    console.log(message);
    return throwError(message);
 }

}
