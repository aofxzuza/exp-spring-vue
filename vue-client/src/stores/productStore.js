import {
  reactive
} from 'vue'
import axios from 'axios';
import { userStore } from './userStore.js';

export const productStore = reactive({
  products: [],
  fetchProduct() {
    axios.get('/api/product', {
        headers: {
          'Authorization': `Bearer ${userStore.accessToken}`
        }
      })
      .then(response => {
        console.log("Fetch products", response.data);
        this.products = response.data;
      }).catch(e => console.log('Failed to fetch products', e));
  },
  addProduct(name, price) {
    axios.post('/api/product', {
        name,
        price,
      }, {
        headers: {
          'Authorization': `Bearer ${userStore.accessToken}`
        }
      })
      .then((response) => {
        console.log("Added Product", response.data);
        this.fetchProduct();
      }).catch(e => console.log('Failed to add product', e));
  },
  removeProductById(id) {
    axios.delete(`/api/product/${id}`, {
        headers: {
          'Authorization': `Bearer ${userStore.accessToken}`
        }
      })
      .then(() => {
        console.log("Delete Product Id", id);
        this.fetchProduct();
      }).catch(e => console.log('Failed to delete product', e));
  }
})