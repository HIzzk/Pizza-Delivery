<template>
    <div
      class="card"
      id="meat-lover"
    >
      <header class="card-header">
        <p class="card-header-title">{{ pizza.name }}</p>
      </header>
          <button  type="button" @click="destroyPizza(pizza)">
            Delete Pizza
    </button>
      <figure class="image is-4by3">
        <img src="\Assests\meaty.jfif" alt="Place Holder Image for Pizza" />
      </figure>
      <div class="card-content">
        {{ pizza.pizzaSize }}
      </div>
      <div class="card-content">
        {{ pizza.crust }}
      </div>
      <div class="card-content">
        {{ pizza.sauce }}
      </div>
      <div class="card-content" id="toppings">
        <div
          class="content"
          v-for="topping in pizza.toppings"
          v-bind:key="topping.name"
        >
          {{ topping.name }}
        </div>
      </div>
    </div>
</template>

<script>

import SpecialPizzaService from "../../services/SpecialPizzaService.js";

export default {
  // data() {
  //   return {
  //     specialtyPizza: this.setPizza,
  //   };
  // },
  computed: {
    setPizza() {
      return this.pizza;
    },
  },

  props: ["pizza"],

  components: {},

  methods: {
    destroyPizza(pizza) {
      SpecialPizzaService.deleteSpecialtyPizza(pizza).then(() => this.$store.commit('REMOVE_SPECIAL', pizza));
    },
  },
};
</script>

<style>
header:hover {
  cursor: pointer;
  background-color: rgba(252, 101, 101, 0.644);
}

header {
  background: linear-gradient(to right, #27b055, #064d15);
  color: white;
}

#meat-lover {
  grid-area: meat;
  background-color: #f3ebf6;
}

#meat-lover:hover {
  cursor: pointer;
  background-color: rgba(252, 101, 101, 0.644);
}

.pizza:hover {
  cursor: pointer;
  background-color: rgba(255, 255, 255, 0.644);
}
</style>