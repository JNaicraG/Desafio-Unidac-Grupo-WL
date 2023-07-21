import {Colaborador} from '../../../models/colaborador';
import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-card-colaborador',
  templateUrl: './card-colaborador.component.html',
  styleUrls: ['./card-colaborador.component.css']
})
export class CardColaboradorComponent implements OnInit{
  @Input() colaborador:Colaborador={
    id:0,
    nome:"",
    cpf:""
  }

  ngOnInit(): void {
  }

}
