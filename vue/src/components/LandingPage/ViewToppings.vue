<template>
  <div>
    <router-link id="create" :to="{ name: 'ToppingNutrition' }">
      <div class="card" id="create">
        <header class="card-header">
          <p class="card-header-title">Nutritional Information</p>
        </header>
        <figure class="image is-4by3">
          <img
            class="pizza-photo"
            src="\Assests\toppings.png"
            alt="Place Holder Image for Pizza"
          />
        </figure>
        <div class="card-content">
          <div class="content">
            Find out more about our delicious, healthy toppings.
          </div>
        </div>
      </div>
    </router-link>
  </div>
</template>

<script>
export default {
  
};
</script>

<style>
header:hover{
 cursor: pointer;
  background-color: rgba(252, 101, 101, 0.644);
}

#create{
  text-align: center;
  min-height: 100%;
}


</style>