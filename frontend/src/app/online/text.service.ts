import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class TextService {
  private baseUrl = 'http://localhost:8080/api/texts';

  constructor(private http: HttpClient) {}

  getAllTexts(): Observable<any[]> {
    return this.http.get<any[]>(`${this.baseUrl}/all`);
  }

  getTextById(id: number): Observable<any> {
    return this.http.get<any>(`${this.baseUrl}/${id}`);
  }

  getCharacterMapsForText(textId: number, characterType: string): Observable<any[]> {
    return this.http.get<any[]>(`${this.baseUrl}/${characterType}/${textId}`);
  }

  postText(textObject: any): Observable<any> {
    console.log("text Posted")
    return this.http.post(`${this.baseUrl}/new`, textObject);
  }
}
