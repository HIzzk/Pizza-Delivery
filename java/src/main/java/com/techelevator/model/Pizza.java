package com.techelevator.model;

import com.techelevator.model.Toppings;

import java.util.ArrayList;

public class Pizza {

    private int pizzaId;
    private String name;
    private String size;
    private String crust;
    private String sauce;
    private ArrayList<Toppings> toppings;

    public Pizza(int pizzaId, String name, String size, String crust, String sauce, ArrayList<Toppings> toppingsArrayList) {
        this.pizzaId = pizzaId;
        this.name = name;
        this.size = size;
        this.crust = crust;
        this.sauce = sauce;
        this.toppings = toppingsArrayList;
    }
    public Pizza () {

    }

    public int getPizzaId() {
        return pizzaId;
    }

    public void setPizzaId(int pizzaId) {
        this.pizzaId = pizzaId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getCrust() {
        return crust;
    }

    public void setCrust(String crust) {
        this.crust = crust;
    }

    public String getSauce() {
        return sauce;
    }

    public void setSauce(String sauce) {
        this.sauce = sauce;
    }

    public ArrayList<Toppings> getToppings() {
        return toppings;
    }

    public void setToppings(ArrayList<Toppings> toppingsArrayList) {
        this.toppings = toppingsArrayList;
    }
}