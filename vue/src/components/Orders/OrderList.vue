<template>
  <div>
    <label > Show Pending Orders</label>
    <input type="checkbox" v-model="showPending">
    <label > Show Cancelled Orders</label>
    <input type="checkbox" v-model="showCancelled">
    <label > Show Completed Orders</label>
    <input type="checkbox" v-model="showCompleted">
    <label > Show All Orders</label>
    <input type="checkbox" v-model="showAll">
  
    <div v-if="showActive">
      <h1>Active Orders</h1>
    <div v-for="order in activeOrders" v-bind:key="order.orderId" >
      
      <div class="card">
        <header class="card-header">
          <p class="card-header-title"> Order #{{order.orderId}}</p>
          <button class="card-header-icon" aria-label="more options">
            <span class="icon">
              <i class="fas fa-angle-down" aria-hidden="true"></i>
            </span>
          </button>
        </header>
        <div class="card-content">
          <div class="content">
            ${{order.price}}
            <br>
            Is this a Delivery: {{order.delivery}} <br>
            </div>
            <label > Pending </label>
            <input type="radio" v-model="order.orderStatus" value="Pending">
            <label > Completed </label>
            <input type="radio" v-model="order.orderStatus" value="Completed">
            <label > Cancelled </label>
            <input type="radio" v-model="order.orderStatus" value="Cancelled">
          
            <br />
            <div  v-for="pizza in order.pizzas" v-bind:key="pizza.pizzaId">
              <br>
                Pizza Name: {{pizza.name}} <br>
                Toppings: 
                <div v-for="topping in pizza.toppings" v-bind:key="topping.toppingId">
                   {{topping.name}}
                </div>
                <br>
              </div>
          
        </div>
        <footer class="card-footer">
          
          
          <a href="#" class="card-footer-item">Delete</a>
        </footer>
      </div>

    </div>
    </div>
    <div v-if="showCompleted">
    <h1>Completed Orders</h1>
    <div v-for="order in completedOrders" v-bind:key="order.orderId">
      
      <div class="card">
        <header class="card-header">
          <p class="card-header-title"> Order #{{order.orderId}}</p>
          <button class="card-header-icon" aria-label="more options">
            <span class="icon">
              <i class="fas fa-angle-down" aria-hidden="true"></i>
            </span>
          </button>
        </header>
        <div class="card-content">
          <div class="content">
            ${{order.price}}
            <br>
            Is this a Delivery: {{order.delivery}} <br>
            </div>
            <label > Pending </label>
            <input type="radio" v-model="order.orderStatus" value="Pending">
            <label > Completed </label>
            <input type="radio" v-model="order.orderStatus" value="Completed">
            <label > Cancelled </label>
            <input type="radio" v-model="order.orderStatus" value="Cancelled">
          
            <br />
            <div  v-for="pizza in order.pizzas" v-bind:key="pizza.pizzaId">
              <br>
                Pizza Name: {{pizza.name}} <br>
                Toppings: 
                <div v-for="topping in pizza.toppings" v-bind:key="topping.toppingId">
                   {{topping.name}}
                </div>
                <br>
              </div>
          
        </div>
        <footer class="card-footer">
          
          
          <a href="#" class="card-footer-item">Delete</a>
        </footer>
      </div>

    </div>
    </div>
    <div v-if="showCancelled">
    <h1>Cancelled Orders</h1>
    <div v-for="order in cancelledOrders" v-bind:key="order.orderId">
      
      <div class="card">
        <header class="card-header">
          <p class="card-header-title"> Order #{{order.orderId}}</p>
          <button class="card-header-icon" aria-label="more options">
            <span class="icon">
              <i class="fas fa-angle-down" aria-hidden="true"></i>
            </span>
          </button>
        </header>
        <div class="card-content">
          <div class="content">
            ${{order.price}}
            <br>
            Delivery? : {{order.delivery}} <br>
            </div>
            <label > Pending </label>
            <input type="radio" v-model="order.orderStatus" value="Pending">
            <label > Completed </label>
            <input type="radio" v-model="order.orderStatus" value="Completed">
            <label > Cancelled </label>
            <input type="radio" v-model="order.orderStatus" value="Cancelled">
          
            <br />
            
           <div  v-for="pizza in order.pizzas" v-bind:key="pizza.pizzaId">
              <br>
                Pizza Name: {{pizza.name}} <br>
                Toppings: 
                <div v-for="topping in pizza.toppings" v-bind:key="topping.toppingId">
                   {{topping.name}}
                </div>
                <br>
              </div>
        </div>
       
        <footer class="card-footer">
          
          
          <a href="#" class="card-footer-item">Delete</a>
        </footer>
      </div>

    </div>
    </div>
    <div v-if="showAll">
    <h1>All Orders</h1>
    <div v-for="order in orders" v-bind:key="order.orderId">
      
      <div class="card">
        <header class="card-header">
          <p class="card-header-title"> Order #{{order.orderId}}</p>
          <button class="card-header-icon" aria-label="more options">
            <span class="icon">
              <i class="fas fa-angle-down" aria-hidden="true"></i>
            </span>
          </button>
        </header>
        <div class="card-content">
          <div class="content">
            ${{order.price}}
            <br>
            Is this a Delivery: {{order.delivery}} <br>
            </div>
            <label > Pending </label>
            <input type="radio" v-model="order.orderStatus" value="Pending">
            <label > Completed </label>
            <input type="radio" v-model="order.orderStatus" value="Completed">
            <label > Cancelled </label>
            <input type="radio" v-model="order.orderStatus" value="Cancelled">
          
            <br />
            <div  v-for="pizza in order.pizzas" v-bind:key="pizza.pizzaId">
              <br>
                Pizza Name: {{pizza.name}} <br>
                Toppings: 
                <div v-for="topping in pizza.toppings" v-bind:key="topping.toppingId">
                   {{topping.name}}
                </div>
                
                <br>
              </div>
          
        </div>
        <footer class="card-footer">
          
          
          <a href="#" class="card-footer-item">Delete</a>
        </footer>
      </div>

    </div>
    </div>
    
    <button type="button"  @click="saveOrderChanges()">Save Changes</button>
    
  </div>
</template>

<script>
import OrderPizzaService from "@/services/OrderPizzaService";
import PizzaService from "@/services/PizzaService";
export default {
  data() {
    return {
      orders: [],
      showPending: false,
      showCancelled: false,
      showCompleted: false,
      showAll: false,
    };
  },
  computed:{
    activeOrders(){
      return this.orders.filter(order => {
         return order.orderStatus == 'Pending'
      })
    },
    completedOrders(){
      return this.orders.filter(order => {
         return order.orderStatus == 'Completed'
      })
    },
    cancelledOrders(){
      return this.orders.filter(order => {
         return order.orderStatus == 'Cancelled'
      })
    },
  },
  methods: {
    saveOrderChanges() {
      // call pizzaOrderService to update DB as data is being pulled from db so updating the db will complete functionality
      this.orders.forEach(order => {
          OrderPizzaService.updateOrderStatus(order.orderId, order.orderStatus)
      });
      alert("Orders Updated");
    },
    deleteOrder() {}
    
  },
  created() {
    OrderPizzaService.getAllOrders().then((response) => {
      this.orders = response.data;
    
      this.orders.forEach(order => {
        OrderPizzaService.getPizzasByOrderId(order.orderId).then(orderResponse => {
          order.pizzas = orderResponse.data.pizzas;

          order.pizzas.forEach(pizza => {
            PizzaService.getToppingsByPizzaId(pizza.pizzaId).then(pizzaResponse => {
              pizza.toppings = pizzaResponse.data.toppings;
            })
          })
        })
      })
    });
  },
};
</script>

<style>
#saveOrderChanges{
  /* position: fixed;
  z-index: 3;
  display: flex;
  align-content: flex-end; */
  
}
</style>