import axios from "axios";

export default {

    getAllToppings() {
        return axios.get("/toppings/")
    },

    createToppings(topping) {
        return axios.post('/toppings/', topping)
    },

    getToppingsById(toppingId) {
        return axios.get(`/toppings/${toppingId}`)
    },
    updateToppingById(toppingId, topping) {
        return axios.put(`/toppings/${toppingId}`, topping)
    },

    deleteToppingsById(toppingId) {
        return axios.delete(`/toppings/${toppingId}`)
    }


}


