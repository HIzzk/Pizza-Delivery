package com.techelevator.dao;

import com.techelevator.model.Pizza;
import com.techelevator.model.Toppings;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class JdbcPizzaDao implements PizzaDao {

    private final JdbcTemplate jdbcTemplate;
    private final ToppingDao toppingDao;

    public JdbcPizzaDao(JdbcTemplate jdbcTemplate, ToppingDao toppingDao) {
        this.jdbcTemplate = jdbcTemplate;
        this.toppingDao = toppingDao;
    }

    /**
     * Retrieve a pizza from the database using the pizzaId integer associated with pizza_id. Should return toppings as well.
     * @param pizzaId the Id associated with a unique pizza object
     * @return a pizza object with all values
     */
    @Override
    public Pizza getPizzaById(int pizzaId) {
        String sql="SELECT * FROM pizza WHERE pizza_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, pizzaId);
        if (results.next()) {
            return mapRowToPizza(results);
        } else {
            return null;
        }
    }

    /**
     * Create a new pizza in the pizza table. Note that no toppings are associated here.
     * @param size String indicating pizza size
     * @param crust String indicating pizza crust type
     * @param sauce String indicating pizza sauce type
     * @return if the pizza has been created with a new id int
     */
    @Override
    public Pizza createPizza(String name, String size, String crust, String sauce) {
        String insertToppingSql = "INSERT into pizza (name, pizza_size, crust, sauce) VALUES (?, ?, ?, ?) RETURNING pizza_id";
        Integer newPizzaId;
        newPizzaId = jdbcTemplate.queryForObject(insertToppingSql, Integer.class, name, size, crust, sauce);
        if (newPizzaId != null)
        {
           return getPizzaById(newPizzaId);
        }
        return null;
    }

    /**
     * Retrieves pizza by Id using getPizzaById method, creates SqlRowSet of pizza topping Ids, and loops through SqlRowSet to map Toppings objects.
     * Sets resultant ArrayList of toppings as Toppings Array List in pizza object and returns completed pizza object
     * @param pizzaId the Id int of the pizza to be queried
     * @return completed pizza object including toppings
     */


    /**
     * Creates many-to-many relationship in pizza_toppings intermediate table to associate toppings with a given pizza by IDs
     * @param toppingsList ArrayList of Toppings to pull IDs from
     * @param pizzaId ID int associated with a given pizza
     * @return Pizza object
     */
    @Override
    public Pizza insertToppingsOnPizza(ArrayList<Toppings> toppingsList, int pizzaId) {
        Pizza newPizza = new Pizza();
        Integer newPizzaId = 0;
        for (Toppings topping : toppingsList){
            String sql = "INSERT into pizza_toppings (pizza_id, topping_id) VALUES (?, ?) returning pizza_id;";
            newPizzaId = jdbcTemplate.queryForObject(sql, Integer.class, pizzaId, topping.getToppingId());
            newPizza = getPizzaWithToppings(newPizzaId);
        }
        return newPizza;
    }

    /**
     * Pulls pizza from pizza table by ID and populates toppings by IDs from toppings table by intermediate table pizza_toppings
     * @param pizzaId int of pizza ID to be given ArrayList toppings
     * @return pizza object with toppings ArrayList
     */
    @Override
    public Pizza getPizzaWithToppings(int pizzaId) {
        Pizza pizza = new Pizza();
        ArrayList<Toppings> toppingsArrayList = new ArrayList<>();
        String sql = "SELECT topping_id from pizza_toppings where pizza_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, pizzaId);
        while (results.next()){
            int toppingIdToInsert = results.getInt("topping_id");
            toppingsArrayList.add(toppingDao.getToppingById(toppingIdToInsert));
        }
        pizza.setToppings(toppingsArrayList);
        return pizza;
    }

    /**
     * Map Sqlrowset query object to new Pizza object, returning pizza without toppings
     * @param rowSet query for pizza_id, name, pizza_size, crust, and sauce
     * @return pizza object with id, name, size, crust, and sauce
     */
    private Pizza mapRowToPizza(SqlRowSet rowSet) {
        Pizza pizza = new Pizza();
        pizza.setPizzaId(rowSet.getInt("pizza_id"));
        pizza.setName(rowSet.getString("name"));
        pizza.setSize(rowSet.getString("pizza_size"));
        pizza.setCrust(rowSet.getString("crust"));
        pizza.setSauce(("sauce"));
        return pizza;
    }

    /**
     * calls toppingDao object to map toppings to topping objects by toppingId int and returns an arrayList of toppings
     * @param rowSet SqlRowSet query object of toppingId ints from pizza_topping table
     * @return ArrayList of toppings
     */
    private ArrayList mapRowToToppingsList(SqlRowSet rowSet) {
        ArrayList<Toppings> toppingsList = new ArrayList<>();
        while (rowSet.next()) {
            toppingsList.add(toppingDao.getToppingById(rowSet.getInt("topping_id")));
        }
        return toppingsList;
    }

}
