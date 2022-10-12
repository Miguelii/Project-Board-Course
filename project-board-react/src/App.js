import React, { Component } from "react";
import "./App.css";
import "bootstrap/dist/css/bootstrap.min.css";
import Navbar from "./components/Navbar";
import ProjectBoard from "./components/ProjectBoard";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import AddProjectTask from "./components/ProjectTask/AddProjectTask";
import { Provider } from "react-redux";
import store from "./store";
import UpdateProjectTask from "./components/ProjectTask/UpdateProjectTask";

class App extends Component {
  render() {
    return (
      <Provider store={store}>
      <div>
        <Navbar/>
      <BrowserRouter> 
          <Routes>
            <Route exact path="/" element={<ProjectBoard />} />
            <Route path="/AddProjectTask" element={<AddProjectTask />} />
          </Routes>
        </BrowserRouter>
      </div>
    </Provider>
    );
  }
}

export default App;
