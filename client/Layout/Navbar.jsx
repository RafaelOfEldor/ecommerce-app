import React, { useContext } from "react";
import { Link, Routes, Route, Outlet, useNavigate } from "react-router-dom";
import data from "../data";

export default function Navbar(props) {
  return (
    <div>
      <nav className="offer-bar">
        <h4>Currently 70% off on all garden products. <u style={{cursor: "pointer"}}>Shop Now</u> </h4>
      </nav>
      <nav className="nav-bar">
        <div className="nav-bar-icon">
          <h1>Icon#1</h1>
        </div>
        
        <div className="nav-bar mid-section">
          <h1>Home</h1>
          <h1>Products</h1>
          <h1>About</h1>
          <h1>Contact</h1>
        </div>

        <div className="nav-bar right-section">
          <h1 style={{width: "100px"}}>Sign in</h1>
          <h1>fav#1</h1>
          <h1>fav#2</h1>
          <h1>fav#3</h1>
        </div>
      </nav>
      <Outlet />
    </div>
  );
}
