import { Injectable } from '@angular/core';
import {Observable} from 'rxjs-compat/Observable';
import { Member } from '../interfaces/member';
import { HttpClient } from '@angular/common/http'
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class MembersDataService {

  private apiServiceUrl = environment.apiBaseUrl;

  private members : Member[];

  constructor(private http: HttpClient) { }

  getMembersOf(bandId: number): Observable<Member[]> {
  	return this.http.get<Member[]>(`${this.apiServiceUrl}/members/${bandId}`);
  }

  addMember(member: Member, bandId : number): Observable<Member>{
    return this.http.post<Member>(`${this.apiServiceUrl}/members/${bandId}/add`, member);
  }
  deleteMember(index){
    this.members.splice(index,1);
  }
}
