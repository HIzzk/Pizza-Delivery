import axios from 'axios';

export default {

    getPizzaById(specialId) {
        return axios.get(`/SpecialtyPizzas/${specialId}`);
      },

      getAllSpecialtyPizzas() {
          return axios.get("/SpecialtyPizzas/");
      },
    
      createNewSpecialtyPizza(pizza) {
        return axios.post('/SpecialtyPizzas/', pizza);
      },

      updateSpecialtyPizza(pizza) {
        return axios.put(`/SpecialtyPizzas/${pizza.pizzaId}`, pizza);
      },

      deleteSpecialtyPizza(pizza) {
        return axios.delete(`/SpecialtyPizzas/${pizza.pizzaId}`);
      }
    

}