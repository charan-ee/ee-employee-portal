import React, { useState } from 'react'
import { useHistory } from 'react-router-dom';
import EmployeeDataService from '../service/EmployeeDataService';

function AddEmployeeComponent(props) {
    const history = useHistory();
    const [firstName, setFirstName] = useState("")
    const [message, setMessage] = useState("");
    const [everestEmailId, setEverestEmailId] = useState("");
    const [password, setPassword] = useState("");

    const onSave = err => {
        err.preventDefault();
        if(!firstName || !everestEmailId || !password) {
            alert("Enter all fields");
            return;
        }
        const employee = {
            firstName,
            everestEmailId,
            password
        };

        EmployeeDataService.createEmployee(employee).then(response => {
            console.log("employee saved successfully", response)
            setMessage(`Employee added successfully`)
            history.push('/employees')
        }).catch(e => {
            setMessage(e);
            console.log("errors",e)
        });
    };


    return (
    <div id={"addEmployeeForm"}>
        <h2>Add New Employee</h2>
        {message && <div className = "alert alert-success">{message}</div>}
        <form onSubmit={e => onSave(e)} className="row justify-content-center">
            <div className="form-group col-md-10">
                <label htmlFor="firstName">FirstName</label>
                <input
                    id="firstName"
                    placeholder={"Enter the firstName"}
                    className="form-control col-md-12"
                    value={firstName}
                    onChange={e => setFirstName(e.target.value)}
                />
            </div>
            <div className="form-group col-md-10">
                <label htmlFor="email">Email</label>
                <input
                    id="email"
                    placeholder={"Enter the email"}
                    className="form-control col-md-12"
                    type="text"
                    value={everestEmailId}
                    onChange={e => setEverestEmailId(e.target.value)}
                />
            </div>
            <div className="form-group col-md-10">
                <label htmlFor="password">Password</label>
                <input
                    id="password"
                    placeholder={"Enter the password"}
                    className="form-control col-md-12"
                    type="password"
                    value={password}
                    onChange={e => setPassword(e.target.value)}
                />
            </div>
            <div className="form-group col-md-10">
                <button type="submit" className="btn btn-primary">
                    Save
                </button>
            </div>
        </form>
    </div>
  )
}

export default AddEmployeeComponent