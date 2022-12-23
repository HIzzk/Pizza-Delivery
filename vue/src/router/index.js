import Vue from 'vue';
import Router from 'vue-router';
import Home from '../views/Home.vue';
import Login from '../views/Login.vue';
import Logout from '../views/Logout.vue';
import Register from '../views/Register.vue';
import store from '../store/index';
import Menu from '../views/Menu.vue';
import Orders from '../views/Orders.vue';
import CustomPizza from '../views/CustomPizza.vue';
import Checkout from '../views/Checkout.vue';
import ToppingView from '../views/ToppingView.vue';
import ToppingsAvailability from '../views/ToppingsAvailability';
import AddPizza from '../views/AddPizza.vue';
import ToppingsDelete from '../views/ToppingsDelete';
import DeleteSpecial from '../views/DestroyPizza.vue';
import AboutUs from '../views/AboutUs.vue';
import ToppingNutrition from '../views/ToppingNutrition.vue';
Vue.use(Router)

/**
 * The Vue Router is used to "direct" the browser to render a specific view component
 * inside of App.vue depending on the URL.
 *
 * It also is used to detect whether or not a route requires the user to have first authenticated.
 * If the user has not yet authenticated (and needs to) they are redirected to /login
 * If they have (or don't need to) they're allowed to go about their way.
 */

const router = new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [
    {
      path: '/home',
      name: 'home',
      component: Home,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/login",
      name: "login",
      component: Login,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/logout",
      name: "logout",
      component: Logout,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/register",
      name: "register",
      component: Register,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/",
      name: "menu",
      component: Menu,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/customPizza",
      name: "customPizza",
      component: CustomPizza,

    },
    {
      path: '/cart',
      name: 'checkout',
      component: Checkout,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/orders/",
      name: "Orders",
      component: Orders,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/toppings",
      name: "Toppings",
      component: ToppingView,
      meta: {
        requiresAuth: true
        // this needs to be true once login functionality is done
      }
    },
    {
      path: "/toppings/availability",
      name: "Toppings avail",
      component: ToppingsAvailability,
      meta: {
        requiresAuth: true
        // this needs to be true once login functionality is done
      }},
      {
      path: "/addPizza",
      name: "AddPizza",
      component: AddPizza,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/toppings/delete",
      name: "Toppings delete",
      component: ToppingsDelete,
      meta: {
        requiresAuth: true
        // this needs to be true once login functionality is done
      }
    },
      {
      path: "/deleteSpecial",
      name: "DeleteSpecial",
      component: DeleteSpecial,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/aboutUs",
      name: "AboutUs",
      component: AboutUs,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/toppingNutrition",
      name: 'ToppingNutrition',
      component: ToppingNutrition,
      meta: {
        requiresAuth: false
      }
    }
  ]
})

router.beforeEach((to, from, next) => {
  // Determine if the route requires Authentication
  const requiresAuth = to.matched.some(x => x.meta.requiresAuth);

  // If it does and they are not logged in, send the user to "/login"
  if (requiresAuth && store.state.token === '') {
    next("/login");
  } else {
    // Else let them go to their next destination
    next();
  }
});

export default router;
