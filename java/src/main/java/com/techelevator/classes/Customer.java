package com.techelevator.classes;

public class Customer {
    private int customerId;
    private int orderId;
    private String address;
    private String creditCard;
    private String CVV;

    public Customer(int customerId, int orderId, String address, String creditCard, String CVV) {
        this.customerId = customerId;
        this.orderId = orderId;
        this.address = address;
        this.creditCard = creditCard;
        this.CVV = CVV;
    }
    public Customer() {

    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(String creditCard) {
        this.creditCard = creditCard;
    }

    public String getCVV() {
        return CVV;
    }

    public void setCVV(String CVV) {
        this.CVV = CVV;
    }
}
