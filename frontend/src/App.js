import EmployeeListComponent from "./component/EmployeeListComponent";
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import AddEmployeeComponent from "./component/AddEmployeeComponent";
import EditEmployeeComponent from "./component/EditEmployeeComponent";

function App() {
  return (
    <div className="container">
          <Router>
              <div>
                  <h1>Employee Portal</h1>
                  <Switch>
                      <Route path="/employees" exact component={EmployeeListComponent} />
                      <Route path="/employee/new" component={AddEmployeeComponent} />
                      <Route path="/employee/update/:id" component={EditEmployeeComponent} />
                  </Switch>
              </div>
          </Router>
      </div>
  );
}

export default App;
