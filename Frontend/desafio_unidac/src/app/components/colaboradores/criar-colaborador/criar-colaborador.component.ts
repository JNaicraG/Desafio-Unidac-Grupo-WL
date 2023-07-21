import { ColaboradorService } from './../../../services/colaborador.service';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ToastrService } from 'ngx-toastr';
import { Router } from '@angular/router';
import { Colaborador } from 'src/app/models/colaborador';

@Component({
  selector: 'app-criar-colaborador',
  templateUrl: './criar-colaborador.component.html',
  styleUrls: ['./criar-colaborador.component.css']
})
export class CriarColaboradorComponent implements OnInit{
  
  formGroup!:FormGroup;
  listaColaboradores:Colaborador[] = [];

  constructor(private router: Router,
    private service: ColaboradorService,
    private formBuilder: FormBuilder,
    private toast: ToastrService){
    }

  ngOnInit(): void {
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
    if(arr.length>0)
      return 0
    return 1 
  }

  salvar(){
    if(this.formGroup.valid){
      if(this.confirmarDados()){
        this.service.criar(this.formGroup.value).subscribe(() =>{
          this.toast.info("Dados cadastrados com sucesso!");
        });
      }else{
        this.toast.error("Colaborador já cadastrado!")
      }
    } else{
      this.toast.error("Preencha os campos obrigatórios!","Erro");
    }
  }


}
