<template>
  <div class="main-container">
    <create-pizza id="create-pizza" />
    <pizza-cards
      v-for="pizza in this.$store.state.specials"
      v-bind:key="pizza.id"
      v-bind:pizza="pizza"
      id="pizza"
    />
    <view-toppings id="view-toppings"/>
  </div>
</template>

<script>
import PizzaCards from "./PizzaCards.vue";
import CreatePizza from "./CreatePizza.vue";
import ViewToppings from "./ViewToppings.vue";
// import SpecialPizzaService from '@/services/SpecialPizzaService.js'
export default {
  components: {
    PizzaCards,
    CreatePizza,
    ViewToppings,
  },
  pizzas: [],
  toppings: [],

  created() {
    this.$store.dispatch("setSpecials");
    this.$store.dispatch("setToppings");
    this.pizzas = this.$store.state.specials;
    this.toppings = this.$store.state.toppings;
  },
};
</script>

<style>
.main-container {
  display: grid;
  grid-template-columns: 1fr 1fr 1fr;
  grid-template-areas:
    "#create-pizza #pizza #pizza"
    "#pizza #pizza #pizza"
    "#pizza #pizza pizza";

  grid-gap: 40px;
}
</style>