<template>
   <div>
     <cart-orders/>
   </div>
</template>

<script>
import CartOrders from '../components/Orders/CartOrders.vue'
//logic for cart loop would be here with import for custom pizza

//styling here or in app for popup cart (absolute)

export default {
  components: {
    CartOrders
  }
  
}