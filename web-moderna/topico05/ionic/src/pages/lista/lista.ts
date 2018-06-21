import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';
import { RemoteServiceProvider } from '../../providers/remote-service/remote-service';

/**
 * Generated class for the ListaPage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */

@Component({
  selector: 'page-lista',
  templateUrl: 'lista.html',
})
export class ListaPage {

  listaContatos = [];

  constructor(private service: RemoteServiceProvider) {
    this.getContatos();
  }

  getContatos() {
    this.service.getContatos()
      .subscribe(data => {
        console.log(data);
        this.listaContatos = data
      });
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad ListaPage');
  }

}
