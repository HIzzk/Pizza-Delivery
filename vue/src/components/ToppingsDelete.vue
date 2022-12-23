<template>
<div>
  <div v-for="topping in $store.state.toppings" :key="topping.name">
            <label > do you want to delete {{topping.name}}?  </label>
            <input type="checkbox" v-model="toppingsToDelete" :value="topping.toppingId">
    </div>
    <button type="submit" @click="deleteToppings"> Delete select toppings</button>
  </div>  
</template>

<script>
import ToppingsService from '../services/ToppingsService'
export default {
    data() {
        return{
            toppingsToDelete:[]
        }
    },
    methods: {
        deleteToppings() {
            this.toppingsToDelete.forEach(id => {
                ToppingsService.deleteToppingsById(id)
                this.$store.commit("DELETE_TOPPINGS", id)
            })
        }
    }

}
</script>

<style>

</style>