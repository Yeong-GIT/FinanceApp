// src/services/api.js
import axios from 'axios';

const api = axios.create({
    baseURL: 'http://localhost:8080/api', // Adjust the URL based on your backend configuration
});

export default api;
