<script setup>
import UserList from './components/UserList.vue'
import NewUserForm from './components/NewUserForm.vue'

</script>

<template>
    <div class="header">
        <h1>Exp-Spring Client</h1>
    </div>
    <div class="content">
        <div class="user-list">
            <UserList/>
        </div>
        <div class="new-user-form">
            <NewUserForm/>
        </div>
    </div>
</template>

<style scoped>
    .header {
        width: 100%;
        padding: 20px 0px 10px 0px;
        position: fixed;
    }

    .content {
        padding-top: 80px;
        width: 100%;
        display: flex;
        flex-wrap: wrap;
    }

    .user-list {
        flex: 2;
        padding: 8px;
        min-width: 400px;
    }

    .new-user-form {
        flex: 1;
        padding: 8px;
        min-width: 300px;
    }
</style>
