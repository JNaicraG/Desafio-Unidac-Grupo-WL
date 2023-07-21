import { ColaboradorService } from './../../../services/colaborador.service';
import { Colaborador } from './../../../models/colaborador';
import { Component, OnInit } from '@angular/core';


@Component({
  selector: 'app-listar-colaboradores',
  templateUrl: './listar-colaboradores.component.html',
  styleUrls: ['./listar-colaboradores.component.css']
})
export class ListarColaboradoresComponent implements OnInit{

  listaColaboradores:Colaborador[] = [];

  constructor(
    private service:ColaboradorService
  ){}


  ngOnInit(): void {
    this.service.listar().subscribe((listaColaboradores) => {
        this.listaColaboradores = listaColaboradores
    })
  }

}
