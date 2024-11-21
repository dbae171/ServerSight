import React from 'react';
import { Line } from 'react-chartjs-2';
import { Chart as ChartJS, CategoryScale, LinearScale, PointElement, LineElement, Title, Tooltip, Legend } from 'chart.js';

ChartJS.register(CategoryScale, LinearScale, PointElement, LineElement, Title, Tooltip, Legend);

const ServerPerformanceChart = ({ performanceData }) => {
    const dates = performanceData.map(data => 
        new Date(data.performanceDate).toLocaleDateString() // Ensure the date is formatted
    );
    const salesAmounts = performanceData.map(data => data.salesAmount);
    const tablesServed = performanceData.map(data => data.tablesServed);
    const feedbackRatings = performanceData.map(data => data.feedbackRating);

    const data = {
        labels: dates,
        datasets: [
            {
                label: 'Sales Amount',
                data: salesAmounts,
                borderColor: 'rgba(75, 192, 192, 1)',
                backgroundColor: 'rgba(75, 192, 192, 0.2)',
                fill: true,
            },
            {
                label: 'Tables Served',
                data: tablesServed,
                borderColor: 'rgba(153, 102, 255, 1)',
                backgroundColor: 'rgba(153, 102, 255, 0.2)',
                fill: true,
            },
            {
                label: 'Feedback Rating',
                data: feedbackRatings,
                borderColor: 'rgba(255, 159, 64, 1)',
                backgroundColor: 'rgba(255, 159, 64, 0.2)',
                fill: true,
            },
        ],
    };

    const options = {
        responsive: true,
        plugins: {
            legend: {
                position: 'top',
            },
            title: {
                display: true,
                text: 'Server Performance Over Time',
            },
        },
    };

    return (
        <div>
            <Line data={data} options={options} />
            <div style={{ marginTop: '20px' }}>
                <h3>Performance Data Log</h3>
                <table className="table table-striped">
                    <thead>
                        <tr>
                            <th>Date</th>
                            <th>Sales Amount</th>
                            <th>Tables Served</th>
                            <th>Feedback Rating</th>
                        </tr>
                    </thead>
                    <tbody>
                        {performanceData.map((data, index) => (
                            <tr key={index}>
                                <td>{new Date(data.performanceDate).toLocaleDateString()}</td>
                                <td>{data.salesAmount}</td>
                                <td>{data.tablesServed}</td>
                                <td>{data.feedbackRating}</td>
                            </tr>
                        ))}
                    </tbody>
                </table>
            </div>
        </div>
    );
};

export default ServerPerformanceChart;
