package com.techelevator.model;

import java.math.BigDecimal;

public class Toppings {
    private String name;
    private int toppingId;
    private BigDecimal price;
    private boolean premium;
    private boolean available;

    public Toppings(String name, int toppingId, BigDecimal price, boolean isPremium, boolean isAvailable) {
        this.name = name;
        this.toppingId = toppingId;
        this.price = price;
        this.premium = isPremium;
        this.available = isAvailable;
    }
    public Toppings() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getToppingId() {
        return toppingId;
    }

    public void setToppingId(int toppingId) {
        this.toppingId = toppingId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public boolean isPremium() {
        return premium;
    }

    public void setPremium(boolean premium) {
        this.premium = premium;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}