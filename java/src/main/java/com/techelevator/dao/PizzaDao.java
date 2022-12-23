package com.techelevator.dao;

import com.techelevator.model.Pizza;
import com.techelevator.model.Toppings;

import java.util.ArrayList;

public interface PizzaDao {

    Pizza getPizzaById(int pizzaId);

    Pizza createPizza(String name, String size, String crust, String sauce);

    Pizza insertToppingsOnPizza(ArrayList<Toppings> toppingsList, int pizzaId);

    Pizza getPizzaWithToppings(int pizzaId);
}
