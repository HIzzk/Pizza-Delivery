<template>
  <div>
      <delete-menu />
      <delete-special />
  </div>
</template>

<script>
import DeleteMenu from '../components/Specialty/DeleteMenu.vue';
import DeleteSpecial from '../components/Specialty/DeleteSpecial.vue';
export default {
    components: {
        DeleteMenu,
        DeleteSpecial,
    }

}
</script>

<style>

</style>