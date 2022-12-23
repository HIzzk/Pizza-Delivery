package com.techelevator.dao;

import com.techelevator.model.Order;
import com.techelevator.model.NewOrderDto;
import com.techelevator.model.OrderStatusUpdateDto;
import com.techelevator.model.Pizza;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcOrderDao implements OrderDao{

    private final JdbcTemplate jdbcTemplate;
    private final PizzaDao pizzaDao;

    public JdbcOrderDao(JdbcTemplate jdbcTemplate, PizzaDao pizzaDao){
        this.jdbcTemplate = jdbcTemplate;
        this.pizzaDao = pizzaDao;
    }


    @Override
    public List<Order> getAllOrders() {
        List<Order> orders = new ArrayList<>();
        String sql = "SELECT * FROM orders;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()){
            Order order = mapRowtoOrder(results);
            orders.add(order);
        }
        return orders;
    }

    @Override
    public Order getOrderById(int orderId) {
        Order order = new Order();
        String sql = "Select * from orders where order_id = ?;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, orderId);
        while (results.next()){
            order = mapRowtoOrder(results);
        }
        return order;
    }

    @Override
    public Order insertOrder(NewOrderDto order) {
        Integer orderId = 0;
        Order newOrder = new Order();
        String sql = "INSERT into orders (order_time, order_status, price, isDelivery) VALUES (CURRENT_TIMESTAMP,?,?,?) returning order_id;";
        orderId = jdbcTemplate.queryForObject(sql, Integer.class, order.getOrderStatus(), order.getPrice(), order.isDelivery());
        newOrder = getOrderById(orderId);
        return newOrder;
    }

    @Override
    public Order updateOrderStatus(int orderId, OrderStatusUpdateDto updateDto) {
        String sql = "UPDATE orders SET order_status = ? WHERE order_id = ?;";
        jdbcTemplate.update(sql, updateDto.getOrderStatus(), orderId);
        return getOrderById(orderId);
    }


    @Override
    public Order insertPizzasIntoOrder(ArrayList<Pizza> pizzaArrayList, int orderId) {
        Order newOrder = new Order();
        Integer newOrderId = 0;
        for (Pizza pizza : pizzaArrayList){
            String sql = "INSERT into order_pizza (order_id, pizza_id) VALUES (?, ?) returning order_id;";
            newOrderId = jdbcTemplate.queryForObject(sql, Integer.class, orderId, pizza.getPizzaId());
        }
        newOrder = getOrderWithPizza(newOrderId);
        return newOrder;
    }

    @Override
    public void deleteOrder(int orderId) {
        String sql = "Delete from order where order_id = ?";
        jdbcTemplate.update(sql,orderId);
    }

    @Override
    public Order getOrderWithPizza(int orderId) {
        Order order = new Order();
        ArrayList<Pizza> pizzaArrayList = new ArrayList<>();
        String sql = "SELECT pizza_id from order_pizza where order_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, orderId);
        while (results.next()){
            int pizzaIdToInsert = results.getInt("pizza_id");
            pizzaArrayList.add(pizzaDao.getPizzaById(pizzaIdToInsert));
        }
        order.setPizzas(pizzaArrayList);
        return order;
    }

    private Order mapRowtoOrder(SqlRowSet rowSet){
        Order order = new Order();
        order.setOrderId(rowSet.getInt("order_id"));
        order.setDate(rowSet.getTimestamp("order_time").toLocalDateTime());
        order.setDelivery(rowSet.getBoolean("isDelivery"));
        order.setPrice(rowSet.getBigDecimal("price"));
        order.setOrderStatus(rowSet.getString("order_status"));

        return order;
    }
}
