import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {ListarColaboradoresComponent} from './components/colaboradores/listar-colaboradores/listar-colaboradores.component';

const routes: Routes = [
  {
    path: '',
    redirectTo: 'listar-colaboradores',
    pathMatch: 'full'
  },
  {
    path: 'listar-colaboradores',
    component: ListarColaboradoresComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
