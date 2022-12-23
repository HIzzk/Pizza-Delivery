import axios from 'axios';

export default {
    getToppingNutrition(name) {
        return axios.get(`/api/${name}`);
    }
}