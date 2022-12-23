<template>

    <form id="pizzaForm" >
      <div id="redDiv"></div>
      <div id="main">
      <div id="pizzaNameDiv">
       <label for="PizzaName"> Name your Custom Pizza </label>
       <br>
    <input type="text" name="PizzaName" id="pizzaName" v-model="newPizza.name"> <br>
    </div>
      <div id="pizzaSize">
    <label for="PizzaSize"> Select a Pizza Size </label>
    <div id=pizzaSizeBtn>
      <div>
    <input  type="radio" v-model="newPizza.size" autocomplete="off" required value="Small" >
    <label for="pizzaSizeSmall">Small</label>
    </div>
    <div>
    <input  type="radio" v-model="newPizza.size" autocomplete="off" required value="Medium">
    <label for="pizzaSizeMedium">Medium</label>
    </div>
    <div>
    <input type="radio" v-model="newPizza.size" autocomplete="off" required value="Large">
    <label for="pizzaSizeLarge">Large</label>
    </div>
    <div>
    <input  type="radio" v-model="newPizza.size" autocomplete="off" required value="ExLarge">
    <label for="pizzaSizeExLarge">Extra Large</label>
    </div>
    <br>
    
      </div>
      </div>
    <label for="PizzaCrust"> Select a crust type </label>
    
    <div id="pizzaCrustBtn">
      <div>
    <input id="pizzaCrustReg" type="radio" v-model="newPizza.crust" autocomplete="off" required value="Regular" >
    <label for="pizzaCrustReg">Regular</label>
    </div>
    <div>
    <input id="pizzaCrustThin" type="radio" v-model="newPizza.crust" autocomplete="off" required value="Thin">
    <label for="pizzaCrustThin">Thin</label>
    </div>
    <div>
    <input id="pizzaCrustDeep" type="radio" v-model="newPizza.crust" autocomplete="off" required value="Deep Dish">
    <label for="pizzaCrustDeep">Deep Dish</label>
    </div>
    <br>
    </div>
    <label for="PizzaSauce"> Select which sauce you'd like </label>
    
    <div id ="pizzaSauceBtn">
      <div>
    <input id="pizzaSauceRed" type="radio" v-model="newPizza.sauce" autocomplete="off" required value="Red" >
    <label for="pizzaSauceRed">Red</label>
    </div>
    <div>
    <input id="pizzaSauceWhite" type="radio" v-model="newPizza.sauce" autocomplete="off" required value="White" >
    <label for="pizzaSauceWhite">White</label>
    </div>
    <div>
    <input id="pizzaSauceExRed" type="radio" v-model="newPizza.sauce" autocomplete="off" required value="Extra Red" >
    <label for="pizzaSauceExRed">Extra red</label>
    </div>
    <br>
    </div><div id="toppingList">
    Select which toppings you'd like
    <!-- change to topping in availableToppings once topping add functionality is complete -->
    <div v-for="topping in availableToppings" :key="topping.name" >
        <label for="PizzaTopping"> </label>
        <input :key="toppings.name" :id="`PizzaTopping${topping.name}`" type="checkbox" v-model="newPizza.toppings" :value="topping" >
        <label :for="topping.name">{{topping.name}}</label>
       
        
    </div>
      <div>
        <div>Order Total: ${{pizzaTotal}}</div>
    </div>


</div>
    <input :for="orderQuantity" type="text" v-model="orderQuantity">Quantity 
   <label :for="orderQuantity"></label>
    <br>
    <button type="submit" class="btn btn-submit" @click.prevent="createNewPizza" onClick="return Alert ('Pizza Added To Cart')"> Order </button>
    <button type="button" class="btn btn-cancel" @click="resetForm"> Clear Choices </button>
    
    
      </div>
    <div id ="greenDiv"></div>
  </form>
</template>

<script>

// import OrderPizzaService from '../services/OrderPizzaService.js'
export default {
  created() {
    
    if (this.$store.state.toppings.length < 1){
      this.$store.dispatch("setToppings");
    }
    this.toppings = this.$store.state.toppings;

    if(this.$store.state.tempSpecialtyPizza.pizzaId) {
        this.newPizza = this.$store.state.tempSpecialtyPizza;
        this.newPizza.toppings = this.$store.state.tempSpecialtyPizza.toppings;
      }
  },
  computed: {
    availableToppings() {
      return this.$store.state.toppings.filter(topping => {
         if ( topping.available == true) {
           return topping;
         }
      })
    },
    pizzaPrice() {
      let basePrice = 10;
      if(this.newPizza.size === 'Small'){
        basePrice = 7.50; 
      }
      else if(this.newPizza.size === 'Large'){
        basePrice = 12.50;
      }
      else if (this.newPizza.size === 'Extra Large'){
        basePrice = 15.00;
      }
      let pizzaSum = basePrice;
      this.newPizza.toppings.forEach(topping => {
        pizzaSum += topping.price;
     });
      return pizzaSum;
    },
    pizzaTotal() {
         return this.orderQuantity * this.pizzaPrice;
    },
  },
  data() {
    return {
      orderQuantity: 1,
      toppings: [
        
      ],
      newPizza: {
        pizzaId: '',
        name: "",
        size: "Medium",
        crust: "Regular",
        sauce: "Red",
        price: "",
        toppings: []
      },
    };
  },
  methods: {
    createNewPizza() {
      if (confirm("Are you sure you want to add this to your cart?")) {
      const newPizza = this.newPizza;
      newPizza.price = this.pizzaPrice;
      for (let i = 0; i < this.orderQuantity; i++) {
              const newPizzaObj = {...newPizza}
              newPizzaObj.pizzaId += i;
              this.$store.commit('ADD_TO_CART', newPizzaObj);
      }
//      this.$store.commit('UPDATE_CART_TOTAL');
      this.resetForm();
      }
    },
    resetForm() {
      this.newPizza = {
        name: '',
        size: "Medium",
        crust: "Regular",
        sauce: 'Red',
        toppings: [],
      }
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

#pizzaForm{
  /* text-align: center; */
  display: flex;
  flex-wrap: wrap;
  justify-content: space-around;
  height: 96vh;
  
}

#pizzaSizeBtn{
  display: flex;
  justify-content:space-evenly;
  width: 100%;
}
#pizzaSauceBtn {
  display: flex;
  justify-content:space-evenly;
  width: 100%;
}
#pizzaCrustBtn {
  display: flex;
  justify-content:space-evenly;
  width: 100%;
}

#pizzaName {
  display: flex;
  align-content: center;
  flex-wrap: wrap;
  
}
#pizzaNameDiv{
  display: flex;
  flex-direction: column;
  align-items: center;  
}
#toppingList {
  display: flex;
  flex-direction: column;
  align-items: flex-start;
}
#greenDiv{
  background: green;
  flex-grow: 1;
}
#redDiv{
  background: red;
  flex-grow: 1;
}
#main{
  flex-grow: 1;
  justify-content: flex-start;
  background: #F9F6D8;
  height: 100%;
}
</style>