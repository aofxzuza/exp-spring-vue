import {
  reactive
} from 'vue'

export const userStore = reactive({
  idToken: null,
  accessToken: null,
  username: null,
  login(payload) {
    console.log('login', payload);
    this.idToken = payload.idToken;
    this.accessToken = payload.accessToken;
    this.username = payload.username
  },
  refreshToken(payload) {
    console.log('refreshToken', payload);
    this.idToken = payload.idToken;
    this.accessToken = payload.accessToken;
  }
})