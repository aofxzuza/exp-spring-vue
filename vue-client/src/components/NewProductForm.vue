<script setup>
</script>

<template>
    <h2>Add New Product</h2>
    <form id="new-product-form" class="form" @submit.prevent="submitNewProduct">
        <div class="field-group">
            <label for="productNameInput">Name:</label>
            <input v-model="name" id="productNameInput" type="text" required>
        </div>
        <div class="field-group">
            <label for="productPriceInput">Price:</label>
            <input v-model="price" id="productPriceInput" type="number" required>
        </div>
        <div class="form-controls">
            <button id="addProductBtn">
                Add
            </button>
        </div>
    </form>
</template>

<script>
import { useProductStore } from '../stores/productStore.js';
import { mapActions } from 'pinia'
export default {
    name: "NewProductForm",
    data() {
        return {
            name: '',
            price: ''
        }
    },
    methods: {
        ...mapActions(useProductStore, ['addProduct']),
        submitNewProduct(event) {
            this.addProduct(this.name, this.price);
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