import EmployeeListComponent from "./component/EmployeeListComponent";
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import EmployeeComponent from "./component/AddEmployeeComponent";

function App() {
  return (
    <div className="container">
          <Router>
              <div>
                  <h1>Employee Portal</h1>
                  <Switch>
                      <Route path="/employees" exact component={EmployeeListComponent} />
                      <Route path="/employee/new" component={EmployeeComponent} />
                  </Switch>
              </div>
          </Router>
      </div>
  );
}

export default App;
