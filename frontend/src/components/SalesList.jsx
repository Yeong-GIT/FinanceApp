// src/components/SalesList.jsx
import React, { useEffect, useState } from 'react';
import axios from '../services/api';
import './SalesList.css';

const SalesList = () => {
    const [invoices, setInvoices] = useState([]);

    useEffect(() => {
        const fetchInvoices = async () => {
            try {
                const response = await axios.get('/invoices');
                setInvoices(response.data);
            } catch (error) {
                console.error('There was an error fetching the invoices!', error);
            }
        };

        fetchInvoices();
    }, []);

    return (
        <div>
            <h2>Invoices</h2>
            <table>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Invoice No</th>
                        <th>Created Date</th>
                        <th>Description</th>
                        <th>Total Due</th>
                        <th>Approval Status</th>
                        <th>Customer ID</th>
                    </tr>
                </thead>
                <tbody>
                    {invoices.map((invoice) => (
                        <tr key={invoice.id}>
                            <td>{invoice.id}</td>
                            <td>{invoice.invNo}</td>
                            <td>{invoice.createdDate}</td>
                            <td>{invoice.description}</td>
                            <td>{invoice.totalDue}</td>
                            <td>{invoice.invApprovalStatus ? 'Approved' : 'Pending'}</td>
                            <td>{invoice.customerId}</td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </div>
    );
};

export default SalesList;
