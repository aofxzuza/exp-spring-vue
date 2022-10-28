<script setup>
</script>

<template>
    <h2>User List</h2>
    <div class="user-row header">
        <div class="user-id">#</div>
        <div class="user-name">Name</div>
        <div class="user-country">Country</div>
        <div class="user-actions">Actions</div>
    </div>
    <div v-for="user in users" class="user-row">
        <div class="user-id">{{ user.id }}</div>
        <div class="user-name">{{ user.name }}</div>
        <div class="user-country">{{ user.country }}</div>
        <div class="user-actions">Delete</div>
    </div>
</template>

<script>
export default {
  name: "UserList",
  data() {
    return {
        users: [
            { id: 1, name: 'A1', country: 'TH' },
            { id:2, name: 'A2', country: 'TH' }
        ]
    }
  },
}
</script>

<style scoped>
    div.user-row {
        display: flex;
        flex-wrap: wrap;
    }

    div.user-row.header{
    border-bottom: 5px solid black;
    }

    div.user-row div:not(:last-child) {
        margin-right: 8px;
    }

    .user-row .user-id {
        width: 30px;
    }

    .user-row .user-name {
        flex: 1;
    }

    .user-row .user-country {
        width: 80px;
    }

    .user-row .user-actions {
        display: flex;
        justify-content: end;
        width: 80px;
    }

</style>