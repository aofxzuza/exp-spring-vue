<script setup>
import UserList from './components/UserList.vue'
</script>

<template>
    <div class="header">
        <h1>Exp-Spring Client</h1>
    </div>
    <div class="content">
        <UserList/>
    </div>
</template>

<style scoped>
    div.header {
        width: 100%;
        padding: 20px 0px 10px 0px;
        position: fixed;
    }

    div.content {
        padding-top: 80px;
    }
</style>
