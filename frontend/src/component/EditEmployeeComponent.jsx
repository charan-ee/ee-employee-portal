import React, { useEffect, useState } from 'react'
import { useHistory } from 'react-router-dom';
import EmployeeDataService from '../service/EmployeeDataService';

function EditEmployeeComponent(props) {
  const id = props.match.params.id
  let history = useHistory()
  const [firstName, setFirstName] = useState("");
  const [everestEmailId, setEverestEmailId] = useState("");
  const [password, setPassword] = useState("");

  const fetchEmployee = () => {
    EmployeeDataService.fetchEmployeeById(id).then( response => {
      var employee = response.data
      setFirstName(employee.firstName);
      setEverestEmailId(employee.everestEmailId);
      setPassword(employee.password);
    })
  }

  const onUpdate = err => {
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

    EmployeeDataService.updateEmployee(id, employee).then(response => {
        console.log("employee updated successfully", response)
        history.push('/employees')
    }).catch(e => {
        console.log("errors",e)
    });
};

  useEffect(() => {
    fetchEmployee()
  }, []);
  return (
    <div id={"addEmployeeForm"}>
      <h2>Add New Employee</h2>
      <form onSubmit={e => onUpdate(e)} className="row justify-content-center">
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
          <button type="submit" className="btn btn-primary">Update</button>
        </div>
        </form>
    </div>
  )
}

export default EditEmployeeComponent