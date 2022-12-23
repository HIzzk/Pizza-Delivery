import Vue from 'vue';
import Vuex from 'vuex';
import axios from 'axios';

import ToppingsService from '../services/ToppingsService';
import SpecialPizzaService from '../services/SpecialPizzaService';


Vue.use(Vuex)

/*
 * The authorization header is set for axios when you login but what happens when you come back or
 * the page is refreshed. When that happens you need to check for the token in local storage and if it
 * exists you should set the header so that it will be attached to each request
 */
const currentToken = localStorage.getItem('token')
const currentUser = JSON.parse(localStorage.getItem('user'));

if (currentToken != null) {
  axios.defaults.headers.common['Authorization'] = `Bearer ${currentToken}`;
}

export default new Vuex.Store({
  // plugins: [createPersistedState()],
  state: {
    token: currentToken || '',
    user: currentUser || {},
    specials: [],
    toppings: [],
    showCart: false,

    Cart: {
      orderId: '',
      price: '',
      delivery: false,
      orderStatus: '',
      pizzas: []
    },

    specialtyPizza: {
      pizzaId: '',
      name: '',
      size: 'Medium',
      crust: '',
      sauce: '',
      image_url: '',
      toppings: []
    }, 

    tempSpecialtyPizza:{
      pizzaId: '',
      name: '',
      size: 'Medium',
      crust: '',
      sauce: '',
      image_url: '',
      toppings: []
    }
  },
  mutations: {
    SET_AUTH_TOKEN(state, token) {
      state.token = token;
      localStorage.setItem('token', token);
      axios.defaults.headers.common['Authorization'] = `Bearer ${token}`
    },
    SET_USER(state, user) {
      state.user = user;
      localStorage.setItem('user', JSON.stringify(user));
    },
    LOGOUT(state) {
      localStorage.removeItem('token');
      localStorage.removeItem('user');
      state.token = '';
      state.user = {};
      axios.defaults.headers.common = {};
    },
    ADD_TO_CART(state, pizza) {
      state.Cart.pizzas.push(pizza);
    },
    ADD_TOPPING(state, topping) {
      state.toppings.push(topping);
    },
    UPDATE_TOPPING(state,topping){
      let correctTopping = state.toppings.find(top => top.toppingId == topping.toppingId)
      correctTopping.available = topping.available;
    },
    DELETE_TOPPING(state,id){
      let newTopList = state.toppings.filter(top =>{
        return top.id != id
      });
      state.toppings = newTopList;
    },
    UPDATE_CART_TOTAL(state) {
      let sum = 0;
      state.Cart.pizzas.forEach(pizza => {
        sum += pizza.price;
      });
      state.Cart.price = sum;
    },

    UPDATE_PIZZA_LIST(state, pizza) {
      state.specialtyPizza.push(pizza)
    },
    SET_TOPPINGS_LIST(state, toppingsList) {
      state.toppings = [];
      let toppingsMod = [];
      toppingsMod.push(toppingsList);
      for (let i = 0; i < toppingsMod[0].length; i++) {
        state.toppings.push(toppingsList[i]);
      }

    },
    SET_SPECIALS_LIST(state, specialsList) {
      state.specials = [];
      let specialsMod = [];
      specialsMod.push(specialsList);
      for (let i = 0; i < specialsMod[0].length; i++) {
        state.specials.push(specialsList[i]);
      }
    },
    REMOVE_SPECIAL(state, pizza) {
      let specialsMod = state.specials.filter(obj => {
        return obj.name !== pizza.name;
      })
      state.specials = specialsMod;
    },
    SET_TEMP_PIZZA(state, pizza) {
      state.tempSpecialtyPizza = pizza;
      state.tempSpecialtyPizza.size = "Medium";
    },
    SET_CART_TOTAL(state, price){
      state.Cart.price = price;
    },
    TOGGLE_SHOW_CART(state){
      state.showCart = !state.showCart
    }
    
  },
  actions: {
    setToppings({ commit }) {
      ToppingsService.getAllToppings().then((response) => {
        commit('SET_TOPPINGS_LIST', response.data);
      })
    },
    setSpecials({ commit }) {
      SpecialPizzaService.getAllSpecialtyPizzas().then((response) => {
        commit('SET_SPECIALS_LIST', response.data);
      })
    }
  }
})

