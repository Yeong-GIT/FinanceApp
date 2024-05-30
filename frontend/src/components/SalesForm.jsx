// src/components/SalesForm.jsx
import React, { useState } from 'react';
import axios from '../services/api';
import './SalesForm.css';

const SalesForm = () => {
    const [customerId, setCustomerId] = useState('');
    const [description, setDescription] = useState('');
    const [totalDue, setTotalDue] = useState('');
    const [taskDescription, setTaskDescription] = useState('');
    const [taskCompleteStatus, setTaskCompleteStatus] = useState(false);

    const handleSubmit = async (event) => {
        event.preventDefault();
        try {
            const response = await axios.post('/invoices', {
                customerId,
                description,
                totalDue,
                taskDescription,
                taskCompleteStatus,
            });
            console.log(response.data);
        } catch (error) {
            console.error('There was an error creating the invoice!', error);
        }
    };

    return (
        <form className="form-container" onSubmit={handleSubmit}>
            <input
                type="text"
                value={customerId}
                onChange={(e) => setCustomerId(e.target.value)}
                placeholder="Customer ID"
                required
            />
            <input
                type="text"
                value={description}
                onChange={(e) => setDescription(e.target.value)}
                placeholder="Description"
                required
            />
            <input
                type="number"
                value={totalDue}
                onChange={(e) => setTotalDue(e.target.value)}
                placeholder="Total Due"
                required
            />
            <input
                type="text"
                value={taskDescription}
                onChange={(e) => setTaskDescription(e.target.value)}
                placeholder="Task Description"
                required
            />
            <label>
                Task Complete Status:
                <input
                    type="checkbox"
                    checked={taskCompleteStatus}
                    onChange={() => setTaskCompleteStatus(!taskCompleteStatus)}
                />
            </label>
            <button type="submit">Create Invoice</button>
        </form>
    );
};

export default SalesForm;
