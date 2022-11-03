import {
  createApp
} from 'vue'
import App from './App.vue'
import Keycloak from 'keycloak-js';

import './assets/main.css'


let initOptions = {
  url: 'http://127.0.0.1:8180',
  realm: 'myrealm',
  clientId: 'app-vue',
  onLoad: 'login-required'
}

let keycloak = new Keycloak(initOptions);

keycloak.init({
  onLoad: initOptions.onLoad
}).then((auth) => {
  if (!auth) {
    window.location.reload();
  } else {
    console.log("Authenticated");
    createApp(App).mount('#app');
  }
  //Token Refresh
  setInterval(() => {
    keycloak.updateToken(70).then((refreshed) => {
      if (refreshed) {
        console.log('Token refreshed' + refreshed);
      } else {
        console.log('Token not refreshed, valid for ' +
          Math.round(keycloak.tokenParsed.exp + keycloak.timeSkew - new Date().getTime() / 1000) + ' seconds');
      }
    }).catch((e) => {
      console.log('Failed to refresh token', e);
    });
  }, 6000)

}).catch((e) => {
  console.log('Authenticated Failed', e);
});