<script setup>
</script>

<template>
    <h2>Add New Product</h2>
    <form id="new-product-form" class="form" @submit.prevent="submitNewProduct">
        <div class="field-group">
            <label>Name:</label>
            <input v-model="name" type="text" required>
        </div>
        <div class="field-group">
            <label>Price:</label>
            <input v-model="price" type="number" required>
        </div>
        <div class="form-controls">
            <button>
                Add
            </button>
        </div>
    </form>
</template>

<script>
import { productStore } from '../stores/productStore.js';
export default {
  name: "NewProductForm",
  data() {
    return {
        name: '',
        price: ''
    }
  },
  methods: {
    submitNewProduct(event){
        productStore.addProduct(this.name, this.price);
    }
  }
}
</script>>

<style scoped>
    .field-group {
        margin-top: 8px;
        display: flex;
        flex-direction: column;
    }
    .form-controls {
        margin-top: 16px;
        display: flex;
        justify-content: end;
    }
</style>