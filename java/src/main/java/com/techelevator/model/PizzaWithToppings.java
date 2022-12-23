package com.techelevator.model;

import java.util.ArrayList;

public class PizzaWithToppings {

    private int pizzaId;
    private ArrayList<Toppings> toppingsList;

    public PizzaWithToppings(int pizzaId, ArrayList<Toppings> toppingsList){
        this.pizzaId = pizzaId;
        this.toppingsList = toppingsList;
    }
    public PizzaWithToppings(){

    }

    public int getPizzaId() {
        return pizzaId;
    }

    public void setPizzaId(int pizzaId) {
        this.pizzaId = pizzaId;
    }

    public ArrayList<Toppings> getToppingsList() {
        return toppingsList;
    }

    public void setToppingsList(ArrayList<Toppings> toppingsList) {
        this.toppingsList = toppingsList;
    }
}
