import { Injectable } from '@angular/core';
import {Colaborador } from '../models/colaborador';
import {Observable} from 'rxjs';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ColaboradorService {

  private readonly API = 'https://backenddesafio-unidacrest-api-production.up.railway.app/colaboradores';

  constructor(private http:HttpClient) { 
  }

  listar():Observable<Colaborador[]>{
    return this.http.get<Colaborador[]>(this.API)
  }

  criar(colaborador:Colaborador):Observable<Colaborador>{
    return this.http.post<Colaborador>(this.API,colaborador);
  }


  excluir(id:Number):Observable<Colaborador>{
    const url = `${this.API}/${id}`
    return this.http.delete<Colaborador>(url);
  }

  buscarID(id:Number):Observable<Colaborador>{
    const url = `${this.API}/${id}`
    return this.http.get<Colaborador>(url);
  }

  editar(colaborador:Colaborador):Observable<Colaborador>{
    const url = `${this.API}`
    return this.http.put<Colaborador>(url,colaborador);
  }

  

}
