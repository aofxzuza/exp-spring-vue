import {
  createApp
} from 'vue'
import App from './App.vue'
import Keycloak from 'keycloak-js';
import { userStore } from './stores/userStore.js';
import './assets/main.css'


let initOptions = {
  url: 'http://localhost:8180',
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
    const app = createApp(App)
    app.config.globalProperties.keycloak = keycloak;
    userStore.login({
      idToken: keycloak.idToken,
      accessToken: keycloak.token,
      username: keycloak.tokenParsed.preferred_username,
    });
    app.mount('#app');
  }
  //Token Refresh
  setInterval(() => {
    keycloak.updateToken(70).then((refreshed) => {
      if (refreshed) {
        console.log('Token refreshed', refreshed);
        userStore.refreshToken({
          idToken: keycloak.idToken,
          accessToken: keycloak.token
        });
        con
      } else {
        console.log('Token not refreshed, valid for',
          Math.round(keycloak.tokenParsed.exp + keycloak.timeSkew - new Date().getTime() / 1000) + ' seconds');
      }
    }).catch((e) => {
      console.log('Failed to refresh token', e);
    });
  }, 6000)
}).catch((e) => {
  console.log('Authenticated Failed', e);
});