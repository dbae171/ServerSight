import React, { useState, useEffect } from 'react';
import { useParams } from 'react-router-dom';
import { logPerformance, getPerformanceByEmployeeId } from '../services/EmployeeService';
import ServerPerformanceChart from './ServerPerformanceChart';

const ServerPerformanceComponent = () => {
    const { id } = useParams();
    const [salesAmount, setSalesAmount] = useState('');
    const [tablesServed, setTablesServed] = useState('');
    const [feedbackRating, setFeedbackRating] = useState('');
    const [performanceDate, setPerformanceDate] = useState('');
    const [performanceData, setPerformanceData] = useState([]);

    // Fetch performance data when the component loads
    useEffect(() => {
        if (id) {
            getPerformanceByEmployeeId(id).then((response) => {
                setPerformanceData(response.data); // Load saved performance data from the backend
            }).catch(error => {
                console.error(error);
            });
        }
    }, [id]);

    const handleSubmit = (e) => {
        e.preventDefault();

        const performance = {
            salesAmount,
            tablesServed,
            feedbackRating,
            performanceDate,
        };

        logPerformance(id, performance)
            .then((response) => {
                setPerformanceData([...performanceData, response.data]);
                setSalesAmount('');
                setTablesServed('');
                setFeedbackRating('');
                setPerformanceDate('');
            })
            .catch((error) => console.error(error));
    };

    return (
        <div>
            <form onSubmit={handleSubmit}>
                <input
                    type="number"
                    value={salesAmount}
                    onChange={(e) => setSalesAmount(e.target.value)}
                    placeholder="Sales Amount"
                    required
                />
                <input
                    type="number"
                    value={tablesServed}
                    onChange={(e) => setTablesServed(e.target.value)}
                    placeholder="Tables Served"
                    required
                />
                <input
                    type="number"
                    value={feedbackRating}
                    onChange={(e) => setFeedbackRating(e.target.value)}
                    placeholder="Feedback Rating"
                    required
                />
                <input
                    type="date"
                    value={performanceDate}
                    onChange={(e) => setPerformanceDate(e.target.value)}
                    placeholder="Performance Date"
                    required
                />
                <button type="submit">Log Performance</button>
            </form>

            <ServerPerformanceChart performanceData={performanceData} />
        </div>
    );
};

export default ServerPerformanceComponent;
