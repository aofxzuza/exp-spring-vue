<script setup>
</script>

<template>
    <h2>Add New User</h2>
    <form id="new-user-form" class="form" @submit.prevent="submitNewUser">
        <div class="field-group">
            <label>Name:</label>
            <input v-model="name" type="text" required>
        </div>
        <div class="field-group">
            <label>Country:</label>
            <input v-model="country" type="text" maxlength="2" required>
        </div>
        <div class="form-controls">
            <button>
                Add
            </button>
        </div>
    </form>
</template>

<script>
export default {
  name: "NewUSerForm",
  data() {
    return {
        name: '',
        country: ''
    }
  },
  methods: {
    submitNewUser(event){
        alert("Adding name " + this.name+ " country " + this.country);
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