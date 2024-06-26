// src/pages/SalesPage.jsx
import React from 'react';
import SalesForm from '../components/SalesForm';
import SalesList from '../components/SalesList';

const SalesPage = () => {
    return (
        <div>
            <h1>Sales Department</h1>
            <SalesForm />
            <SalesList />
        </div>
    );
};

export default SalesPage;
