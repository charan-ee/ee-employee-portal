import logo from './logo.svg';
import './App.css';

function App() {
  return (
    <div className="container">
      <h1>Everest Employee Portal</h1>
      <table className="table table-striped">
        <thead>
          <tr>
            <td>Id</td>
            <td>Name</td>
            <td>Email</td>
            <td>Actions</td>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td>1</td>
            <td>Ram</td>
            <td>ram@ee.com</td>
            <td>Delete</td>
          </tr>
        </tbody>
      </table>
    </div>
  );
}

export default App;
