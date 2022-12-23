package com.techelevator.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class NutritionResponseDto {
    private List<NutritionResponseFood> foods;

    public List<NutritionResponseFood> getFoods() {
        return foods;
    }

    public void setFoods(List<NutritionResponseFood> food) {
        this.foods = food;
    }
}
