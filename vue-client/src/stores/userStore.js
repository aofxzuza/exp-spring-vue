import { reactive } from 'vue'
import axios from 'axios';

export const userStore = reactive({
  id: 1,
  users: [],
  fetchUser(){
    axios.get('/api/user')
      .then(response => {
        console.log("Fetch User", response.data);
        this.users = response.data;
      });
  },
  addUser(name, country){
    axios.post('/api/user', { name, country})
      .then((response) => {
        console.log("Added User", response.data);
        this.fetchUser();
      });
  },
  removeUserById(id){
    axios.delete(`/api/user/${id}`)
      .then(() => {
        console.log("Delete User Id", id);
        this.fetchUser();
      });
  }
})