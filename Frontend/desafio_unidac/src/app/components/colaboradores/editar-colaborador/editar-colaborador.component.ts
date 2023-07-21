import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { ColaboradorService } from 'src/app/services/colaborador.service';
import {Colaborador} from '../../../models/colaborador';
import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-editar-colaborador',
  templateUrl: './editar-colaborador.component.html',
  styleUrls: ['./editar-colaborador.component.css']
})
export class EditarColaboradorComponent implements OnInit{

  formGroup!:FormGroup; 
  listaColaboradores:Colaborador[] = [];
  @Input() colaborador:Colaborador={
    id:0,
    nome:"",
    cpf:""
  }
  constructor(private router: Router,
    private service: ColaboradorService,
    private formBuilder: FormBuilder,
    private route: ActivatedRoute,
    private toast: ToastrService){
    }
  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('id');
    this.service.buscarID(parseInt(id!)).subscribe(dados => this.colaborador = dados);
    //this.colaborador.id=parseInt(id!);
    this.service.listar().subscribe((listaColaboradores) => {
      this.listaColaboradores = listaColaboradores
  })
    this.formGroup = this.formBuilder.group({
      nome:["",Validators.required],
      cpf:["",Validators.required]
    })
  }

  confirmarDados(){
    const arr = this.listaColaboradores.filter(dados => dados.cpf === this.formGroup.get('cpf')?.value) ;
    if(arr.length==1)
      return 0
    return 1
  }

  editar(){
    if(this.formGroup.valid){
      if(this.confirmarDados()){
        this.colaborador.nome = this.formGroup.get('nome')?.value;
        this.colaborador.cpf = this.formGroup.get('cpf')?.value;

        this.service.editar(this.colaborador).subscribe(() =>{
          this.toast.info("Dados cadastrados com sucesso!");
        });
      }else{
        this.toast.error("Colaborador duplicado!")
      }
    } else{
      this.toast.error("Preencha os campos obrigatórios!","Erro");
    }
  }

}
