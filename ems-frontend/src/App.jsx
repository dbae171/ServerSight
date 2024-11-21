
import './App.css'
import ListEmployeeComponent from './components/ListEmployeeComponent.jsx'
import  HeaderComponent from './components/HeaderComponent.jsx'
import {BrowserRouter, Routes, Route} from 'react-router-dom'
import EmployeeComponent from './components/EmployeeComponent.jsx'

function App() {

  return (
    <>
      <BrowserRouter>
        <HeaderComponent />
          <Routes>
          {/* //http://localhost:3000 */}
            <Route path='/' element = { <ListEmployeeComponent />}></Route>
            {/* //http://localhost:3000/employees */}
            <Route path='/employees' element = { <ListEmployeeComponent />}></Route>
            {/* //http://localhost:3000/add-employee */}
            <Route path='/add-employee' element = { <EmployeeComponent />}></Route>
            {/* //http://localhost:3000/add-employee */}
            <Route path='/edit-employee/:id' element = {<EmployeeComponent/>}></Route>
          </Routes>
      </BrowserRouter>
    </>
  )
}

export default App
