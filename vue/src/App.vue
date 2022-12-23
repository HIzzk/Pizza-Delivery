

<template>
  <div id="app">
    <home-banner></home-banner>
    <router-view id="main-view"></router-view>
  </div>
</template>
<script>
// import Checkout from "@/views/Checkout.vue";
import HomeBanner from "@/components/HomeBanner.vue";


// import Home from '@/views/Home';
// import Menu from '@/views/Menu';
// import ToppingService from '@/services/ToppingsService';
// import SpecialPizzaService from '@/services/SpecialPizzaService'
export default {
  name: "App",
  components: {
    // Checkout,
    HomeBanner,
  },
  methods: {},
  data() {
    return {};
  },
};
</script>
<style>
#main-view {
  margin-top: 3rem;
}

/* #banner {
  position: fixed;
  display: flex;
  align-items: center;
  z-index: 2;
}
#cart-btn {
  display: flex;
  flex-direction: column;
  justify-content: center;
  margin:0;
  

  justify-content: center;
  width: 4em;
  background: linear-gradient(to right, #9fbcd6, #151d64);
}
.checkout {
  border: red;
  border-radius: 4px;
  width: 350px;
  position: fixed;
  
  top: 10px;
  right: 10px;
}
#nav {
  background-color: #fff;
}
.menu-items {
  color: black;
}
.menu-items:hover {
  cursor: pointer;
  color: red;
} */
</style>