package com.techelevator.controller;

import com.techelevator.dao.JdbcToppingDao;
import com.techelevator.dao.ToppingDao;
import com.techelevator.model.Toppings;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin
public class ToppingController {
    private final ToppingDao toppingDao;
    private final String API_BASE = "/toppings"; // need to determine what local host this is running on

    public ToppingController( ToppingDao toppingDao) {
        this.toppingDao=toppingDao;
    }

    @RequestMapping(path= API_BASE + "/", method=RequestMethod.GET)
    public List<Toppings> getAllToppings() {
        return toppingDao.getAllToppings();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = API_BASE + "/", method = RequestMethod.POST)
    public Toppings createTopping(@RequestBody Toppings topping) {
        return toppingDao.createTopping(topping.getName(),topping.getPrice().doubleValue(),topping.isPremium());
    }
    // potential for this to cause floating point error in price if there is one its most likely this method

    @RequestMapping(path= API_BASE + "/{id}", method = RequestMethod.GET)
    public Toppings getToppingById (int topId) {
        return toppingDao.getToppingById(topId);
    }

    @RequestMapping(path= API_BASE + "/{id}",method = RequestMethod.PUT)
    public void updateTopping(@RequestBody Toppings topping, @PathVariable int id) {
         toppingDao.updateToppingById(topping.isAvailable(),id);
    }

    @RequestMapping(path = API_BASE + "/{id}", method = RequestMethod.DELETE)
    public void deleteTopping(@PathVariable int id) {
        toppingDao.deleteTopping(id);
    }
}
