package com.techelevator.controller;

import com.techelevator.dao.JdbcOrderDao;
import com.techelevator.dao.OrderDao;
import com.techelevator.dao.PizzaDao;
import com.techelevator.model.NewOrderDto;
import com.techelevator.model.Order;
import com.techelevator.model.OrderStatusUpdateDto;
import com.techelevator.model.Pizza;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin
public class OrderController {
  private final OrderDao orderDao;
  private final PizzaDao pizzaDao;

  public OrderController (OrderDao orderDao, PizzaDao pizzaDao) {
      this.orderDao=orderDao;
      this.pizzaDao = pizzaDao;

  }
  @ResponseStatus(HttpStatus.CREATED)
  @RequestMapping(path = "/orders", method = RequestMethod.POST)
    public Order createOrder (@RequestBody NewOrderDto order) {
    Order createdOrder = orderDao.insertOrder(order);
    if (order.getPizzas() != null) {
      for (Pizza newPizza : order.getPizzas()){
        Pizza returnPizza = pizzaDao.createPizza(newPizza.getName(), newPizza.getSize(), newPizza.getCrust(),newPizza.getSauce());
        newPizza.setPizzaId(returnPizza.getPizzaId());
        if (newPizza.getToppings() != null ) { //avoid returning null pointer when mapping arrayList to pizza object and SQL
          pizzaDao.insertToppingsOnPizza(newPizza.getToppings(), returnPizza.getPizzaId());
          returnPizza.setToppings(newPizza.getToppings());
        }
      }
      orderDao.insertPizzasIntoOrder(order.getPizzas(), createdOrder.getOrderId());
    }
      return createdOrder;
  }

  @RequestMapping(path = "/orders/", method = RequestMethod.GET)
    public List<Order> getAllOrders () {
      return orderDao.getAllOrders();
  }

  @RequestMapping(path = "/orders/{id}", method = RequestMethod.GET)
    public Order getOrderById (@PathVariable int id) {
      return orderDao.getOrderWithPizza(id);
  }

  @RequestMapping(path = "/orders/{id}", method = RequestMethod.PUT)
    public Order updateOrder(@PathVariable int id, @RequestBody OrderStatusUpdateDto update) {
      return orderDao.updateOrderStatus(id,update);
  }
  @RequestMapping(path = "/orders/", method = RequestMethod.DELETE)
  public void deleteOrder(int orderId) {
    orderDao.deleteOrder(orderId);
  }
}
