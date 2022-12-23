<template>
<form id="toppingForm">
    <div id="redDiv"></div>
    <div id='main'>
    <div v-for="topping in $store.state.toppings" :key="topping.name">
            <label > {{topping.name}} availability. Checked for true Unchecked for false </label>
            <input type="checkbox" v-model="topping.available">
    </div>
    <!-- not sure how to tackle. should each button have a submit? ideally submit should submit them all but sending all of the toppings would be awkward -->
    <button type="submit" @click.prevent="updateTopping(toppings)" onClick="return alert('Toppings Updated')">Update these Toppings</button> 
    <!-- <button @click="clearForm">Clear form</button> -->
    </div>
    <div id="greenDiv"></div>
</form> 
</template>

<script>
import ToppingService from '../services/ToppingsService'
export default {
    data() {
        return{
            toppings: []
                
            
        }
    },
    computed: {
        // toppings(){
        //     return this.$store.state.toppings;
        // }
    },
     created(){
        this.$store.dispatch("setToppings");
        this.toppings = this.$store.state.toppings;
    },
    methods: {
        updateTopping(){
            this.$store.state.toppings.forEach(topping => {
               ToppingService.updateToppingById(topping.toppingId, topping)
                this.$store.commit("UPDATE_TOPPING",topping)
            });
          
    },
    }
}
</script>

<style>

</style>