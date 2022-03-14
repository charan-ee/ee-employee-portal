import axios from "axios";

const API_BASE_URL = 'http://localhost:8080';

class EmployeeDataService {
  fetchEmployees = () => {
    return axios.get(`${API_BASE_URL}/api/employees`);
  }

  fetchEmployeeById = (id) => {
    return axios.get(`${API_BASE_URL}/api/employees/${id}`);
  }

  searchEmployeeByName = (name) => {
    return axios.get(`${API_BASE_URL}/api/employees/search?query=${name}`,name)
  }

  createEmployee = (employee) => {
    return axios.post(`${API_BASE_URL}/api/employees`,employee);
  }

  updateEmployee = (id, employee) => {
    return axios.put(`${API_BASE_URL}/api/employees/${id}`, employee);
  }

  deleteEmployee = (id) => {
    return axios.delete(`${API_BASE_URL}/api/employees/${id}`);
  }

}

export default new EmployeeDataService();