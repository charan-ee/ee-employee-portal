import React, {useState, useEffect} from 'react';
import EmployeeDataService from "../service/EmployeeDataService";

const  EmployeeListComponent = () => {
    const [employees, setEmployees] = useState([]);

    const loadEmployees = () => {
        EmployeeDataService.fetchEmployees().then( response => {
        setEmployees(response.data.data)
        }).catch(e => console.log("errors", e));
    }

    useEffect(()=>{
        loadEmployees();
    }, []);

    return (
        <div>
            <h4>Employee List</h4>
            <table className={"table table-striped"}>
                <thead>
                <tr>
                    <td>Id</td>
                    <td>Name</td>
                    <td>Email</td>
                    <td>Actions</td>
                </tr>
                </thead>
                <tbody>
                {employees.map(emp => {
                    return (
                        <tr key={emp.id}>
                            <td>{emp.id}</td>
                            <td>{emp.firstName} {emp.lastName}</td>
                            <td>{emp.everestEmailId}</td>
                            <td><button className={"btn btn-danger"}>Delete</button></td>
                        </tr>
                    );
                })}
                </tbody>
            </table>
        </div>
    )
}

export default EmployeeListComponent;