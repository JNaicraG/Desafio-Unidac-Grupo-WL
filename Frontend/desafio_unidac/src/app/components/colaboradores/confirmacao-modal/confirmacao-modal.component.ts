import { Component, OnInit } from '@angular/core';
import { Colaborador } from 'src/app/models/colaborador';
import { ColaboradorService } from 'src/app/services/colaborador.service';
import { ActivatedRoute,Router } from '@angular/router';

@Component({
  selector: 'app-confirmacao-modal',
  templateUrl: './confirmacao-modal.component.html',
  styleUrls: ['./confirmacao-modal.component.css']
})
export class ConfirmacaoModalComponent implements OnInit{
  
  colaborador:Colaborador = {
    id:0,
    nome:'',
    cpf:'',
  };

  constructor(
    private service: ColaboradorService,
    private router: Router,
    private route: ActivatedRoute
  ) { }
  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('id')
    this.service.buscarID(parseInt(id!)).subscribe((colaborador) => {
      this.colaborador = colaborador
    })
  }

  excluirColaborador(){
    if (this.colaborador.id) {
      this.service.excluir(this.colaborador.id).subscribe(() => {
        this.router.navigate(['/listar-colaboradores'])
      })      
    }
  }

  
  cancelar() {
    this.router.navigate(['/listar-colaboradores'])
  }

}
