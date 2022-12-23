package com.techelevator.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class NewOrderDto {
    private int orderId;
    private LocalDateTime date;
    private BigDecimal price;
    private boolean isDelivery;
    private String orderStatus;
    private ArrayList<Pizza> pizzas;

    public NewOrderDto(int orderId, LocalDateTime date, BigDecimal price, boolean isDelivery, String orderStatus, ArrayList<Pizza> pizzas) {
        this.orderId = orderId;
        this.date = date;
        this.price = price;
        this.isDelivery = isDelivery;
        this.orderStatus = orderStatus;
        this.pizzas = pizzas;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public boolean isDelivery() {
        return isDelivery;
    }

    public void setDelivery(boolean delivery) {
        isDelivery = delivery;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public ArrayList<Pizza> getPizzas() {
        return pizzas;
    }

    public void setPizzas(ArrayList<Pizza> pizzas) {
        this.pizzas = pizzas;
    }
}
