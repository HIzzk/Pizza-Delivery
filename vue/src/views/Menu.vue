<template>
  <div>
      <!-- <home-banner/> -->
      <pizza-card />
      <menu-component />    
  </div>
</template>

<script>
// import HomeBanner from '../components/HomeBanner.vue';
import MenuComponent from '../components/LandingPage/MenuComponent.vue';
import PizzaCard from "../components/LandingPage/PizzaCards.vue";
export default {
  components: {
    PizzaCard,
    
    // HomeBanner,
    MenuComponent,

  
  },
};
</script>


<style>
</style>