package com.techelevator.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Nutrition {

        @JsonProperty("food_name")
        private String name;

        //grams
        @JsonProperty("serving_weight_grams")
        private double grams;

        //kcals
        @JsonProperty("nf_calories")
        private double calories;

        //grams
        @JsonProperty("nf_total_fat")
        private double totalFat;

        //grams
        @JsonProperty("nf_saturated_fat")
        private double saturatedFat;

        //mgrams
        @JsonProperty("nf_cholesterol")
        private double cholesterol;

        //mgrams
        @JsonProperty("nf_sodium")
        private double sodium;

        //grams
        @JsonProperty("nf_total_carbohydrate")
        private double totalCarbs;

        //grams
        @JsonProperty("nf_dietary_fiber")
        private double dietaryFiber;

        //grams
        @JsonProperty("nf_sugars")
        private double sugars;

        //grams
        @JsonProperty("nf_protein")
        private double protein;

        //mgrams
        @JsonProperty("potassium")
        private double potassium;

        //empty constructor
        public Nutrition() {

        }

        //full constructor
        public Nutrition(String name, double grams, double calories, double totalFat, double saturatedFat, double cholesterol, double sodium, double totalCarbs, double dietaryFiber, double sugars, double protein, double potassium) {
            this.name = name;
            this.grams = grams;
            this.calories = calories;
            this.totalFat = totalFat;
            this.saturatedFat = saturatedFat;
            this.cholesterol = cholesterol;
            this.sodium = sodium;
            this.totalCarbs = totalCarbs;
            this.dietaryFiber = dietaryFiber;
            this.sugars = sugars;
            this.protein = protein;
            this.potassium = potassium;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getGrams() {
            return grams;
        }

        public void setGrams(double grams) {
            this.grams = grams;
        }

        public double getCalories() {
            return calories;
        }

        public void setCalories(double calories) {
            this.calories = calories;
        }

        public double getTotalFat() {
            return totalFat;
        }

        public void setTotalFat(double totalFat) {
            this.totalFat = totalFat;
        }

        public double getSaturatedFat() {
            return saturatedFat;
        }

        public void setSaturatedFat(double saturatedFat) {
            this.saturatedFat = saturatedFat;
        }

        public double getCholesterol() {
            return cholesterol;
        }

        public void setCholesterol(double cholesterol) {
            this.cholesterol = cholesterol;
        }

        public double getSodium() {
            return sodium;
        }

        public void setSodium(double sodium) {
            this.sodium = sodium;
        }

        public double getTotalCarbs() {
            return totalCarbs;
        }

        public void setTotalCarbs(double totalCarbs) {
            this.totalCarbs = totalCarbs;
        }

        public double getDietaryFiber() {
            return dietaryFiber;
        }

        public void setDietaryFiber(double dietaryFiber) {
            this.dietaryFiber = dietaryFiber;
        }

        public double getSugars() {
            return sugars;
        }

        public void setSugars(double sugars) {
            this.sugars = sugars;
        }

        public double getProtein() {
            return protein;
        }

        public void setProtein(double protein) {
            this.protein = protein;
        }

        public double getPotassium() {
            return potassium;
        }

        public void setPotassium(double potassium) {
            this.potassium = potassium;
        }

}
