package com.techelevator.controller;

import com.techelevator.dao.JdbcPizzaDao;
import com.techelevator.dao.PizzaDao;
import com.techelevator.dao.ToppingDao;
import com.techelevator.model.Pizza;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class PizzaController {
    private final PizzaDao pizzaDao;
    private final ToppingDao toppingDao;
    private String API_BASE = ""; // need to determine what local host this is running on

    public PizzaController(PizzaDao pizzaDao, ToppingDao toppingDao) {
        this.pizzaDao=pizzaDao;
        this.toppingDao=toppingDao;
    }

    @ResponseStatus (HttpStatus.CREATED)
    @RequestMapping (path = "/pizza", method = RequestMethod.POST)
    public Pizza createPizza (@RequestBody Pizza newPizza) { //Create a pizza and add the toppings from a front end JSON, then return it
        Pizza returnPizza = pizzaDao.createPizza(newPizza.getName(), newPizza.getSize(), newPizza.getCrust(),newPizza.getSauce());
        if (newPizza.getToppings() != null ) { //avoid returning null pointer when mapping arrayList to pizza object and SQL
            pizzaDao.insertToppingsOnPizza(newPizza.getToppings(), returnPizza.getPizzaId());
            returnPizza.setToppings(newPizza.getToppings());
        }
        return returnPizza;
    }

    @RequestMapping (path= "/pizza/{pizzaId}", method = RequestMethod.GET)
    public Pizza getPizzaById (@PathVariable int pizzaId) {
        return pizzaDao.getPizzaWithToppings(pizzaId);
    }
    //update pizza controller method
//    @RequestMapping (path= "/pizzas/{id}" method = RequestMethod.PUT)
//    public Pizza updatePizza (Pizza pizza) {
//        return
//    }

}
