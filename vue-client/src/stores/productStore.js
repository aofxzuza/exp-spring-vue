import {
  defineStore
} from 'pinia'
import axios from 'axios';
import {
  useUserStore
} from './userStore.js';



export const useProductStore = defineStore('product', {
  state: () => ({
    products: [],
  }),
  actions: {
    fetchProduct() {
      const userStore = useUserStore();
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
      const userStore = useUserStore();
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
      const userStore = useUserStore();
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
  },
})