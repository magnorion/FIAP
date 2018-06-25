import { Component } from '@angular/core';
import { Platform } from 'ionic-angular';
import { StatusBar } from '@ionic-native/status-bar';
import { SplashScreen } from '@ionic-native/splash-screen';

import { HomePage } from '../pages/home/home';
import { ContatoPage } from '../pages/contato/contato';
import { ListaPage } from '../pages/lista/lista'; 

@Component({
  templateUrl: 'app.html'
})
export class MyApp {
  rootPage:any;

  constructor(platform: Platform, statusBar: StatusBar, splashScreen: SplashScreen) {
    this.rootPage = HomePage;
    
    platform.ready().then(() => {
      // Okay, so the platform is ready and our plugins are available.
      // Here you can do any higher level native things you might need.
      statusBar.styleDefault();
      splashScreen.hide();
    });
  }

  navigatePage(opcao: string) {
    if (opcao == 'home') {
      this.rootPage = HomePage;
      } else if (opcao == 'contato') {
        this.rootPage = ContatoPage;
      } else if (opcao == 'lista') {
        this.rootPage = ListaPage;
      }
  } 
}

