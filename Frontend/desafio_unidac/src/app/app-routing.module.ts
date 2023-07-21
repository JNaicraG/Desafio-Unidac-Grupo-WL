import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {ListarColaboradoresComponent} from './components/colaboradores/listar-colaboradores/listar-colaboradores.component';
import { CriarColaboradorComponent } from './components/colaboradores/criar-colaborador/criar-colaborador.component';
import { EditarColaboradorComponent } from './components/colaboradores/editar-colaborador/editar-colaborador.component';

const routes: Routes = [
  {
    path: '',
    redirectTo: 'listar-colaboradores',
    pathMatch: 'full'
  },
  {
    path: 'listar-colaboradores',
    component: ListarColaboradoresComponent
  },
  {
    path: 'criar-colaborador',
    component: CriarColaboradorComponent
  },
  {
    path: 'colaboradores/editar-colaborador/:id',
    component: EditarColaboradorComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
