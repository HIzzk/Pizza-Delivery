<template>
  <div>
    <div>
      <h2>Topping: {{ topping.name }}</h2>
    </div>
    <div>
      {{ nutrition["foods"][0] }}
    </div>
  </div>
</template>

<script>
import NutritionService from "../services/NutritionService.js";

export default {
  created() {
    NutritionService.getToppingNutrition(this.topping.name).then((response) => {
      this.nutrition = response.data;
    });
  },
  data() {
    return {
      nutrition: [],
    };
  },
  computed: {
    //pulls information out of returned nested array of size 1
    // nutritionPull() {
    //   return this.nutrition["foods"][0];
    //}
  },
  props: ["topping"],
  // this.name = name;
  // this.grams = grams;
  // this.calories = calories;
  // this.totalFat = totalFat;
  // this.saturatedFat = saturatedFat;
  // this.cholesterol = cholesterol;
  // this.sodium = sodium;
  // this.totalCarbs = totalCarbs;
  // this.dietaryFiber = dietaryFiber;
  // this.sugars = sugars;
  // this.protein = protein;
  // this.potassium = potassium;
};
</script>

<style>
</style>