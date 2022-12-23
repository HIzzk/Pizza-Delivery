package com.techelevator.dao;

import com.techelevator.model.Toppings;

import java.util.List;

public interface ToppingDao {

    Toppings getToppingById(int toppingId);

    List<Toppings> getAllToppings();

    Toppings createTopping(String name, double price, boolean isPremium);

    void updateToppingById(boolean check,int toppingId);

    void deleteTopping(int id);
}
