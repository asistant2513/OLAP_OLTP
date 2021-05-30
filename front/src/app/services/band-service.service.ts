import { Injectable } from '@angular/core';
import {Observable} from 'rxjs-compat/Observable';
import { Band } from '../interfaces/band';
import { HttpClient } from '@angular/common/http'
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class BandServiceService {

  private apiServiceUrl = environment.apiBaseUrl;

  private bands;

  constructor(private http: HttpClient) { }

  getBands(): Observable<Band[]> {
  	return this.http.get<Band[]>(`${this.apiServiceUrl}/bands`);
  }

  addBand(band : Band) : Observable<Band>{
    return this.http.post<Band>(`${this.apiServiceUrl}/bands/add`, band);
  }

  deleteBand(index: number): Observable<void>{
    console.log(`${this.apiServiceUrl}/bands/delete/${index}`);
    return this.http.delete<void>(`${this.apiServiceUrl}/bands/delete/${index}`);
  }

  updateBand(band: Band): Observable<Band>{
    return this.http.put<Band>(`${this.apiServiceUrl}/bands/update`, band);
  }

}
