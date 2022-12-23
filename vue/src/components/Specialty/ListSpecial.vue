<template>
  <div>
    <h1>Specialty Pizzas</h1>
    <div v-for="pizza in pizzas" :key="pizza.id" class="card-container">
      <div class="card">
        <header class="content">
          <p class="card-header-title">{{ pizza.name }}</p>
        </header>
        <div class="card-content">
          <div class="content">
            <div>
              <p>Size: {{ pizza.size }}</p>
            </div>
            <br>
            <div>
              <p>Crust: {{ pizza.crust }}</p>
            </div>
            <br>
            <div>
              <p>Sauce: {{ pizza.sauce }}</p>
            </div>
            <br>
            <div>
              Toppings:
              <ul>
                <li v-for="topping in pizza.toppings" :key="topping">
                  {{ topping.name }}
                </li>
              </ul>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
//import SpecialPizzaService from "@/services/SpecialPizzaService";

export default {
  data() {
    return {
      pizzas: [],
      toppings: [],
    };
  },
  computed: {
    storePizzas() {
      return this.$store.state.specials;
    },
  },
  created() {
    this.$store.dispatch("setSpecials");
    this.pizzas = this.$store.state.specials;
    this.$store.dispatch("setToppings");
    this.toppings = this.$store.state.toppings;
  },
};
</script>
<style>
.card-container {
  display: grid;
  grid-column: 1fr;
}

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