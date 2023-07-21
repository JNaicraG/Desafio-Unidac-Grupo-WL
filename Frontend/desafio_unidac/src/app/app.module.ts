import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { ColaboradorService } from './services/colaborador.service'
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ListarColaboradoresComponent } from './components/colaboradores/listar-colaboradores/listar-colaboradores.component';
import { CardColaboradorComponent } from './components/colaboradores/card-colaborador/card-colaborador.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';


@NgModule({
  declarations: [
    AppComponent,
    ListarColaboradoresComponent,
    CardColaboradorComponent
  ],
  imports: [
    CommonModule,
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [ColaboradorService],
  bootstrap: [AppComponent]
})
export class AppModule { }
