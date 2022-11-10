<script setup>
</script>

<template>
    <h2>Product List</h2>
    <div class="product-row header">
        <div class="product-id">#</div>
        <div class="product-name">Name</div>
        <div class="product-price">price</div>
        <div class="product-actions">Actions</div>
    </div>
    <div v-for="product in products" class="product-row">
        <div class="product-id">{{ product.id }}</div>
        <div class="product-name">{{ product.name }}</div>
        <div class="product-price">{{ product.price }}</div>
        <div class="product-actions">
            <button @click="deleteProduct(product.id)">Delete</button>
        </div>
    </div>
</template>

<script>
import { useProductStore } from '../stores/productStore.js';
import { mapState, mapActions } from 'pinia'

export default {
    name: "ProductList",
    computed: {
        ...mapState(useProductStore, ['products'])
    },
    methods: {
        ...mapActions(useProductStore, ['fetchProduct', 'removeProductById']),
        deleteProduct(id, event) {
            this.removeProductById(id);
        }
    },
    mounted() {
        this.fetchProduct();
    }
}
</script>

<style scoped>
div.product-row {
    display: flex;
    flex-wrap: wrap;
    margin-bottom: 8px;
}

div.product-row.header {
    border-bottom: 5px solid black;
}

div.product-row div:not(:last-child) {
    margin-right: 8px;
}

.product-row .product-id {
    width: 30px;
}

.product-row .product-name {
    flex: 1;
}

.product-row .product-country {
    width: 80px;
}

.product-row .product-actions {
    display: flex;
    justify-content: end;
    width: 80px;
}
</style>