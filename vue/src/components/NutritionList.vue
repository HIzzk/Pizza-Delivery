<template>
  <div>
    <div  class="card-container">
      <nutrition-info v-for="topping in toppings" :key="topping.name" v-bind:topping="topping" class="card" />
      Placeholder
    </div>
  </div>
</template>

<script>
import NutritionInfo from "../components/NutritionInfo.vue";

export default {
  components: {
      NutritionInfo,
  },

  data() {
    return {
      toppings: [],
    };
  },
  created() {
    this.$store.dispatch("setToppings");
    this.toppings = this.$store.state.toppings;
  },
};
</script>

<style>
</style>