<template>
  <div id="section-banner">
    &nbsp;&nbsp;
    <div id="banner">
      &nbsp;&nbsp;
      <button
        class="fa-icon-btn"
        @click="$store.state.showCart = !$store.state.showCart"
      >
        <div class="fa-icon">
          <font-awesome-icon icon="fas fa-shopping-cart" />Cart
        </div>
      </button>
      <!-- &nbsp;&nbsp; -->
      <div id="fa-icon">
        <button class="fa-icon-btn">
          <font-awesome-icon icon="fa fa-bars" />
          <router-link class="menu-items" :to="{ name: 'menu' }">  Menu</router-link
          >&nbsp;&nbsp;
        </button>
      </div>
      <!-- <router-link class="menu-items" :to="{ name: 'checkout' }"
          >Cart</router-link -->
      <!-- >&nbsp;|&nbsp; -->
      &nbsp;&nbsp;
      <div class="fa-icon">
        <button class="fa-icon-btn">
          <font-awesome-icon icon="fas fa-circle-info" />

          <router-link class="menu-items" v-bind:to="{ name: 'AboutUs' }"
            > About Us</router-link
          >
        </button>
      </div>
      &nbsp;&nbsp;

      <router-link class="menu-items" v-bind:to="{ name: 'home' }"
        ><button class="fa-icon-btn">
          <div>
            <span class="icon">
              <font-awesome-icon icon="fas fa-hotel" /> Home
            </span>
            
          </div>
        </button></router-link
      >&nbsp;&nbsp;
      <div class="fa-icon">
        <router-link
          v-bind:to="{ name: 'logout' }"
          v-if="$store.state.token != ''"
          ><button class="fa-icon-btn">
            <font-awesome-icon icon="fas fa-right-from-bracket" />
            Logout
          </button></router-link
        >
      </div>
      <div class="spacer"></div>

      <div id="pizza-name-title">Speziata's Pizzeria</div>
    </div>

    <checkout v-show="$store.state.showCart" id="checkout" />
  </div>
</template>

<script>
import Checkout from "@/views/Checkout.vue";

export default {
  components: {
    Checkout,
  },
};
</script>

<style>
#pizza-name-title {
  font-size: 35px;
  margin-right: 90px;
}

.spacer {
  flex-grow: 1;
}
#checkout {
  margin-top: 3rem;
}

#home {
  margin: 10px;
}
#banner {
  background: linear-gradient(to right, rgb(241, 227, 227), #be162c);
  color: white;
  z-index: 2;
  position: fixed;
  top: 0;
  display: flex;
  justify-content: center;
  align-items: center;
  width: 50%;
  
  /* justify-content: space-around; */
  height: 2.5rem;
  width: 100vw;
}
.fa-icon {
  color: black;
  display: flex;
  justify-content: center;
  width: 3rem;
}
.fa-icon-btn {
  display: flex;
  
  justify-content: center;
  flex-direction: row;
  font: icon;
  align-items: center;
  align-content: center;
  color: black;
  align-items: center;
  margin: 0;

  /* width: 20%; */
  height: 2.5rem;
  cursor: pointer;
  width: 4em;
  color: black;
  background: linear-gradient(to right, #c5d3e0, #a0b3b6);
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
/* a {
  color: black;
} */
/* .menu-items {
  color: black;
}
.menu-items:hover {
  cursor: pointer;
  color: red;
} */
/* #pizza-name-title {
 justify-items: end;
 justify-content: end;
} */
</style>