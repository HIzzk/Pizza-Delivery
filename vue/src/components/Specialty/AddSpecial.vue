<template>
  <form id="pizzaForm">
    <div id="redDiv"></div>
    <div id="main">
      <div id="pizzaNameDiv">
        <label for="PizzaName"> Name your Specialty Pizza </label>
        <br />
        <input
          type="text"
          name="PizzaName"
          id="pizzaName"
          v-model="newPizza.name"
        />
        <br />
      </div>
      <div id="pizzaSize">
        <label for="PizzaSize"> Select a Pizza Size</label>
        <div id="pizzaSizeBtn">
          <div>
            <input
              type="radio"
              v-model="newPizza.size"
              autocomplete="off"
              required
              value="Small"
            />
            <label for="pizzaSizeSmall">Small</label>
          </div>
          <div>
            <input
              type="radio"
              v-model="newPizza.size"
              autocomplete="off"
              required
              value="Medium"
            />
            <label for="pizzaSizeMedium">Medium</label>
          </div>
          <div>
            <input
              type="radio"
              v-model="newPizza.size"
              autocomplete="off"
              required
              value="Large"
              checked="checked"
            />
            <label for="pizzaSizeLarge">Large</label>
          </div>
          <div>
            <input
              type="radio"
              v-model="newPizza.size"
              autocomplete="off"
              required
              value="ExLarge"
            />
            <label for="pizzaSizeExLarge">Extra Large</label>
          </div>
          <br />
        </div>
      </div>
      <label for="PizzaCrust"> Select a crust type</label>

      <div id="pizzaCrustBtn">
        <div>
          <input
            id="pizzaCrustReg"
            type="radio"
            v-model="newPizza.crust"
            autocomplete="off"
            required
            value="Regular"
            checked="checked"
          />
          <label for="pizzaCrustReg">Regular</label>
        </div>
        <div>
          <input
            id="pizzaCrustThin"
            type="radio"
            v-model="newPizza.crust"
            autocomplete="off"
            required
            value="Thin"
          />
          <label for="pizzaCrustThin">Thin</label>
        </div>
        <div>
          <input
            id="pizzaCrustDeep"
            type="radio"
            v-model="newPizza.crust"
            autocomplete="off"
            required
            value="Deep Dish"
          />
          <label for="pizzaCrustDeep">Deep Dish</label>
        </div>
        <br />
      </div>
      <label for="PizzaSauce"> Select which sauce you'd like</label>

      <div id="pizzaSauceBtn">
        <div>
          <input
            id="pizzaSauceRed"
            type="radio"
            v-model="newPizza.sauce"
            autocomplete="off"
            required
            value="Red"
          />
          <label for="pizzaSauceRed">Red</label>
        </div>
        <div>
          <input
            id="pizzaSauceWhite"
            type="radio"
            v-model="newPizza.sauce"
            autocomplete="off"
            required
            value="White"
            checked="checked"
          />
          <label for="pizzaSauceWhite">White</label>
        </div>
        <div>
          <input
            id="pizzaSauceExRed"
            type="radio"
            v-model="newPizza.sauce"
            autocomplete="off"
            required
            value="Extra Red"
          />
          <label for="pizzaSauceExRed">Extra red</label>
        </div>
        <br />
      </div>
      <div id="toppingList">
        Select which toppings you'd like
        <!-- change to topping in availableToppings once topping add functionality is complete -->
        <div v-for="topping in availableToppings" :key="topping.id">
          <label for="PizzaTopping"> </label>
          <input
            :id="`PizzaTopping${topping.name}`"
            type="checkbox"
            v-model="newPizza.toppings"
            :value="topping.toppingId"
          />
          <label :for="topping.name">{{ topping.name }}</label>
        </div>
      </div>
      <br />
      <button type="submit" class="btn btn-submit" @click.prevent="updatePizza">
        Order
      </button>
      <button type="button" class="btn btn-cancel" @click="resetForm">
        Clear Choices
      </button>
    </div>
    <div id="greenDiv"></div>
  </form>
</template>

<script>
// import OrderPizzaService from '../services/OrderPizzaService.js'
import SpecialPizzaService from "../../services/SpecialPizzaService.js";
// import ToppingsService from '../../services/ToppingsService';
export default {
  computed: {
    // currently does nothing until topping add functionality is added
    availableToppings() {
      return this.$store.state.toppings.filter((topping) => {
        if (topping.available == true) {
          return topping;
        }
      });
    },
    
    pizzaPrice() {
      let basePrice = 10;
      let pizzaSum = 0;
      this.newPizza.toppings.forEach((topping) => {
        pizzaSum = basePrice += topping.price;
      });
      return pizzaSum;
    },
  },
  data() {
    return {
      testPizza: [],
      toppings: [],
      newPizza: {
        pizzaId: "",
        name: "",
        size: "Large",
        crust: "Regular",
        sauce: "Red",
        price: "",
        toppings: [],
      },
    };
  },
  created() {
    this.toppings = this.$store.state.toppings;
  },
  methods: {
    createNewPizza() {
      const newPizza = this.newPizza;

      newPizza.toppings = this.newPizza.toppings.map((toppingId) => {
        return this.toppings.find((topping) => topping.toppingId === toppingId);
      });
      newPizza.price = this.pizzaPrice;
      // OrderPizzaService.addPizza(newPizza);
      SpecialPizzaService.createNewSpecialtyPizza(newPizza);
      this.resetForm();
    },
    filterPizza() {
      const newPizza = this.newPizza;
      const specialsList = this.$store.state.specials;
      const specialsMod = specialsList.filter((obj) => {
        return obj.name.toUpperCase() == newPizza.name.toUpperCase();
      });
      return specialsMod;
    },

    //Finds pizza from store state if pizza name == existing name and updates it, else calls createNewPizza function
    updatePizza() {
      const newPizza = this.newPizza;
      const specialsMod = this.filterPizza();
      this.testPizza = specialsMod;
      if (specialsMod.length > 0) {
        alert(newPizza);
        newPizza.pizzaId = specialsMod[0].pizzaId;
        newPizza.toppings = this.newPizza.toppings.map((toppingId) => {
          return this.toppings.find(
            (topping) => topping.toppingId === toppingId
          );
        });
        SpecialPizzaService.updateSpecialtyPizza(newPizza).then(() => {
          this.resetForm();
          this.$store.dispatch("setSpecials");
        });
      } else {
        this.createNewPizza();
        this.$store.dispatch("setSpecials");
      }
    },
    resetForm() {
      this.newPizza = {
        pizzaId: "",
        name: "",
        size: "Large",
        crust: "Regular",
        sauce: "Red",
        price: "",
        toppings: [],
      };
    },
  },
};
</script>

<style scoped>
button {
  align-content: space-around;

  width: 50%;
  cursor: pointer;
  border-radius: 5em;
  color: #fff;
  background: linear-gradient(to right, #27b055, #064d15);
  border: 0;
  padding-left: 40px;
  padding-right: 40px;
  padding-bottom: 10px;
  padding-top: 10px;
  font-family: "Ubuntu", sans-serif;
  font-size: 13px;
  box-shadow: 0 0 20px 1px rgba(0, 0, 0, 0.04);
  align-items: center;
  align-self: center;
  margin-top: 10px;
  margin-bottom: 24px;
}

#pizzaForm {
  /* text-align: center; */
  display: flex;
  flex-wrap: wrap;
  justify-content: space-around;
  height: 96vh;
}

#pizzaSizeBtn {
  display: flex;
  justify-content: space-evenly;
  width: 100%;
}
#pizzaSauceBtn {
  display: flex;
  justify-content: space-evenly;
  width: 100%;
}
#pizzaCrustBtn {
  display: flex;
  justify-content: space-evenly;
  width: 100%;
}

#pizzaName {
  display: flex;
  align-content: center;
  flex-wrap: wrap;
}
#pizzaNameDiv {
  display: flex;
  flex-direction: column;
  align-items: center;
}
#toppingList {
  display: flex;
  flex-direction: column;
  align-items: flex-start;
}
#greenDiv {
  background: green;
  flex-grow: 1;
}
#redDiv {
  background: red;
  flex-grow: 1;
}
#main {
  flex-grow: 1;
  justify-content: flex-start;
  background: #f9f6d8;
  height: 100%;
}
</style>