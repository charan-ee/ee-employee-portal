import axios from "axios";

const API_BASE_URL = 'http://localhost:8080';

class EmployeeDataService {
  fetchEmployees = () => {
    return axios.get(`${API_BASE_URL}/api/employees`);
  }
}

export default new EmployeeDataService();
   