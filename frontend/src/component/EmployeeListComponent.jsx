import React, {useState, useEffect } from 'react';
import { useHistory } from 'react-router-dom';

import EmployeeDataService from "../service/EmployeeDataService";

const  EmployeeListComponent = () => {
    const history = useHistory()
    const [employees, setEmployees] = useState([]);
    const [message, setMessage] = useState(null);

    const loadEmployees = () => {
        EmployeeDataService.fetchEmployees().then( response => {
        setEmployees(response.data.data)
        }).catch(e => console.log("errors", e));
    }

    useEffect(()=>{
        loadEmployees();
    }, []);

    const deleteEmployee = (id) => {
        const deleteStr = `Deleted course with Id: ${id} successfully`;
        EmployeeDataService.deleteEmployee(id).then( response => {
            console.log(deleteStr, response);
            setMessage(deleteStr);
            loadEmployees();
        }
        )
    }
    
    function addEmployee(){
        history.push('/employee/new')
    }

    return (
        <div>
            <h4>Employee List</h4>
            {message && <div className = "alert alert-success">{message}</div>}
            <button className="btn btn-success float-right" onClick={() => addEmployee()}> Add </button>
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
                            <td>
                                <button className="btn btn-success mr-1" onClick={() => this.editUser(emp.id)}>Edit</button>
                                <button className="btn btn-danger mr-1" onClick={() => deleteEmployee(emp.id)}>Delete</button>
                            </td>
                        </tr>
                    );
                })}
                </tbody>
            </table>
        </div>
    )
}

export default EmployeeListComponent;