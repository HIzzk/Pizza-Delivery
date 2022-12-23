package com.techelevator.controller;

import com.techelevator.Service.NutritionService;
import com.techelevator.model.Nutrition;
import com.techelevator.model.NutritionResponseDto;
import com.techelevator.model.Toppings;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class NutritionController {
    private String API_BASE = "/api/";
    private final NutritionService nutritionService;

    public NutritionController(NutritionService nutritionService) {
        this.nutritionService = nutritionService;
    }

    @RequestMapping(path = "/api/{name}", method = RequestMethod.GET)
    public NutritionResponseDto getToppingNutrition(@PathVariable String name) {
        NutritionResponseDto nutritionDto = nutritionService.search(name);
        return nutritionDto;
    }
}
