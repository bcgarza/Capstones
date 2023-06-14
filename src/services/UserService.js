import axios from 'axios';

export default {

    updatePreferences(requestBody) {
        return axios.put('/preferences/update', requestBody);
    },

    getUserPreferences(userId) {
        return axios.get(`/preferences/${userId}`);
    }

}