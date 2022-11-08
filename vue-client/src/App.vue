<script setup>
import ProductList from './components/ProductList.vue'
import NewProductForm from './components/NewProductForm.vue'
</script>

<template>
    <div class="header">
        <h1>Exp-Spring Client</h1>
        <div class="nav-menu">
            <div>{{ username }}</div>
            <button @click="logout">Logout</button>
        </div>
    </div>
    <div class="content">
        <div class="product-list">
            <ProductList />
        </div>
        <div class="new-product-form">
            <NewProductForm />
        </div>
    </div>
</template>

<script>
import { mapState } from 'pinia'
import { useUserStore } from './stores/userStore.js';
export default {
    computed: {
        ...mapState(useUserStore, ['username'])
    },
    methods: {
        logout(event) {
            var logoutOptions = { redirectUri: "http://localhost:8080" };
            console.log("--> log: logoutOptions  ", logoutOptions);
            this.keycloak.logout(logoutOptions)
                .then(success => console.log("--> log: logout success ", success))
                .catch(error => console.log("--> log: logout error ", error));
        }
    },
}
</script>
<style scoped>
.header {
    width: 100%;
    padding: 20px 0px 10px 0px;
    position: fixed;
    display: flex;
    justify-content: space-between;
    align-items: baseline;
    max-width: 1024px;
    z-index: 9999;
}

.header .nav-menu {
    display: flex;
}

.header .nav-menu *:not(:last-child) {
    margin-right: 8px;
}

.content {
    padding-top: 80px;
    width: 100%;
    display: flex;
    flex-wrap: wrap;
    max-width: 1024px;
}

.product-list {
    flex: 2;
    padding: 8px;
    min-width: 400px;
}

.new-product-form {
    flex: 1;
    padding: 8px;
    min-width: 300px;
}
</style>
