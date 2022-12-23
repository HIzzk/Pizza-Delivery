<template>
<form id="toppingForm">
    <div id="redDiv"></div>
    <div id="main">
  <div>
      <label for="toppingName">Input a name for the topping</label>
      <br>
      <input type="text" name="toppingName" v-model="newTopping.name">
  </div>
  <div>
      <label for="toppingPice">Input a topping price</label>
      <br>
      <input type="number" name="toppingPrice" min="0" v-model="newTopping.price">
  </div>
  <div>
      <label for="toppingPremium">Is the topping premium. checked means true</label>
      
      <input type="checkbox" name="toppingPremium" v-model="newTopping.isPremium">
  </div>
  <div>
      <label for="toppingAvailable">Is the topping available. checked means true</label>
      <input type="checkbox" name="toppingAvailable" v-model="newTopping.available">
  </div>
  <div>
      <button type="submit" @click.prevent="createNewTopping(newTopping)" >Create this Topping</button>
      <button @click="clearForm">Clear form</button>
  </div>
  </div>
  <div id="greenDiv"></div>
  </form>
</template> 

<script>
import ToppingService from '../services/ToppingsService'
export default {
    data() {
        return {
            toppings: [],
            newTopping :{
                name: "",
                toppingId: 1,
                price: 0,
                isPremium: false,
                available: true,
                added: false
            }
        }
    },
    created(){
        this.$store.dispatch("setToppings");
        this.toppings = this.$store.state.toppings;
    },
    methods:{
        createNewTopping(Topping){
            if(Topping.name == ''){
               alert('Name of topping cannot be empty')
            } else {
            alert('Topping Created')   
            ToppingService.createToppings(Topping);
            this.$store.commit("ADD_TOPPING",Topping);
            this.toppings = this.$store.state.toppings;
            
            }
        },
        clearForm(){
            this.newTopping ={
                  name: "",
                toppingId: 1,
                price: 0,
                isPremium: false,
                available: true,
                added: false
            }
        }
    }
}
</script>

<style>

#toppingForm{
    display: flex;
    height: 96vh;
}
</style>