import {Injectable } from '@angular/core';
import {Colaborador } from '../models/colaborador';
import {Observable} from 'rxjs';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ColaboradorService {

  private readonly API = 'http://127.0.0.1:8080/colaboradores';

  constructor(private http:HttpClient) { 
  }

  listar():Observable<Colaborador[]>{
    return this.http.get<Colaborador[]>(this.API)
  }

}
