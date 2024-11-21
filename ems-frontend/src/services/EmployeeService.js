//axios for HTTP requests, to retrieve or send data to server
import axios from "axios";

//holding base URL
const REST_API_BASE_URL = 'http://localhost:8080/api/employees';

export const listEmployees = () => axios.get(REST_API_BASE_URL);

export const createEmployee = (employee) => axios.post(REST_API_BASE_URL, employee);

export const getEmployee = (employeeId) => axios.get(REST_API_BASE_URL + '/'+ employeeId);

export const updateEmployee = (employeeId, employee) => axios.put(REST_API_BASE_URL + '/' + employeeId, employee);

export const deleteEmployee = (employeeId) => axios.delete(REST_API_BASE_URL + '/' + employeeId);

export const logPerformance = (employeeId, performanceData) => 
    axios.post(`${REST_API_BASE_URL}/${employeeId}/performance`, performanceData);

export const getPerformanceByEmployeeId = (employeeId) => 
    axios.get(`${REST_API_BASE_URL}/${employeeId}/performance`);
