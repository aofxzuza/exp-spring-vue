import { reactive } from 'vue'

export const userStore = reactive({
  id: 1,
  users: [],
  addUser(name, country){
    this.users.push({id: this.id ,name, country});
    this.id++;
  },
  removeUserById(id){
    this.users = this.users.filter(element => element.id != id);
  }
})