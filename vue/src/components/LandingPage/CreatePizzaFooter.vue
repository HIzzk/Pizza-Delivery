<template>
  <div>
     <div class="card" id="cheese">
      <header class="card-header">
        <p class="card-header-title">Create Your Own Pizza</p> 
      </header>
      <figure class="image is-4by3">
            <img class="pizza-photo"  src="\Assests\cheese.jfif" alt="Place Holder Image for Pizza">
      </figure>
      <div class="card-content">
        <div class="content">
          Choose from any number of toppings, cheese, sauces and crust
                  </div>
      </div>
    </div>

  </div>
</template>

<script>
import OrderPizzaService from "@/services/OrderPizzaService";

export default {
  data() {
    return {
      Pizza: {
        pizzaId: 1,
        size: 'medium',
        crust: 'normal',
        sauce: 'red',
        
      }, 
      Toppings:{}
    };
  },
  methods: {
    createNewPizza(Pizza) {
      OrderPizzaService.addPizza(Pizza);
    }
  },
};


</script>

<style>

</style>