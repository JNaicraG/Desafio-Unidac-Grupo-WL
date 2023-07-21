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
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { CriarColaboradorComponent } from './components/colaboradores/criar-colaborador/criar-colaborador.component';
import{ NgxMaskDirective, NgxMaskPipe } from 'ngx-mask'
import { ToastrModule } from 'ngx-toastr';
import { EditarColaboradorComponent } from './components/colaboradores/editar-colaborador/editar-colaborador.component';
import { ConfirmacaoModalComponent } from './components/colaboradores/confirmacao-modal/confirmacao-modal.component';

@NgModule({
  declarations: [
    AppComponent,
    ListarColaboradoresComponent,
    CardColaboradorComponent,
    CriarColaboradorComponent,
    EditarColaboradorComponent,
    ConfirmacaoModalComponent
  ],
  imports: [
    CommonModule,
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
    NgxMaskDirective,
    NgxMaskPipe,
    ToastrModule.forRoot()
  ],
  providers: [ColaboradorService],
  bootstrap: [AppComponent]
})
export class AppModule { }
