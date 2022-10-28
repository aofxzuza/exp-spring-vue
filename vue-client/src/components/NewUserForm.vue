<script setup>
</script>

<template>
    <h2>Add New User</h2>
    <form id="new-user-form" class="form">
        <div class="field-group">
            <label for="name-input">Name:</label>
            <input type="text" name="name" id="name-input">
        </div>
        <div class="field-group">
            <label for="name-country">Country:</label>
            <input type="text" name="country"  size="2" id="name-country">
        </div>
        <div class="form-controls">
            <button>
                Add
            </button>
        </div>
    </form>
</template>

<script>
</script>

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