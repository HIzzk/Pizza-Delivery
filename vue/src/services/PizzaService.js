import axios from 'axios'

export default {
    createSpecialtyPizza(pizza){
        return axios.post('/pizza', pizza )
    },

    getToppingsByPizzaId(pizzaId){
       return axios.get( `/pizza/${pizzaId}`)
    },

    getAllPizzas(){
       return axios.get('pizza')
    }
}