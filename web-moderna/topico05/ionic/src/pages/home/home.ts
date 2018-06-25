import { Component } from '@angular/core';
import { NavController } from 'ionic-angular';

@Component({
  selector: 'page-home',
  templateUrl: 'home.html'
})
export class HomePage {

  titulo: String;
  constructor(public navCtrl: NavController) {
    this.titulo = "Gestão de Contatos";
  }

  public getTitulo(): String {
    return "App: "+ this.titulo;
  }

}
