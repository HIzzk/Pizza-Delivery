package com.techelevator.dao;

import com.techelevator.model.Order;
import com.techelevator.model.NewOrderDto;
import com.techelevator.model.OrderStatusUpdateDto;
import com.techelevator.model.Pizza;

import java.util.ArrayList;
import java.util.List;

public interface OrderDao {
    List<Order> getAllOrders();

    Order getOrderById(int orderId);

    Order insertOrder(NewOrderDto order);

    Order updateOrderStatus(int orderId, OrderStatusUpdateDto updateDto);


    Order insertPizzasIntoOrder(ArrayList<Pizza> pizzaArrayList, int orderId);

    Order getOrderWithPizza(int orderId);

    void deleteOrder(int orderId);
}
