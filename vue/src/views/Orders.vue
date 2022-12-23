<template>
  <div>
<home-banner/>
<order-list/>
  </div>
</template>

<script>
import HomeBanner from "../components/HomeBanner";
import OrderList from "../components/Orders/OrderList.vue"
export default {
  components: { HomeBanner,
  OrderList },

}
</script>

<style>

</style>