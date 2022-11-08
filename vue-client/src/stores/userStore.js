import {
  defineStore
} from 'pinia'

export const useUserStore = defineStore('user', {
  state: () => ({
    idToken: null,
    accessToken: null,
    username: null
  }),
  actions: {
    login(payload) {
      console.log('login', payload);
      this.idToken = payload.idToken;
      this.accessToken = payload.accessToken;
      this.username = payload.username;
    },
    refreshToken(payload) {
      console.log('refreshToken', payload);
      this.idToken = payload.idToken;
      this.accessToken = payload.accessToken;
    }
  },
})