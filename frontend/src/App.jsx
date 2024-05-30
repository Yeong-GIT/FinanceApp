// src/App.jsx
import React from "react";
import SalesForm from "./components/SalesForm"; // Corrected path
import SalesList from "./components/SalesList"; // Corrected path

const App = () => {
    return (
        <div>
            <h1>Sales Department</h1>
            <SalesForm />
            <SalesList />
        </div>
    );
};

export default App;
