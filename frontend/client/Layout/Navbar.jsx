import React, { useContext } from "react";
import { Link, Routes, Route, Outlet, useNavigate, NavLink } from "react-router-dom";
import data from "../data";
import AccountLogo from "../images/account-logo.svg"
import SearchLogo from "../images/search-logo.svg"
import ShoppingCartLogo from "../images/shopping-basket-logo.svg"
import ProjectLogo from "../images/project-logo.png"
import {useAuth} from "../context/AuthContext"

export default function Navbar(props) {

  
const { isUserAuthenticated, ItemAmountInCart } = useAuth()
console.log(isUserAuthenticated)
  return (
    <div>
      <nav className="offer-bar">
        <h4>Currently 70% off on all garden products! <u style={{cursor: "pointer"}}>Shop Now</u> </h4>
      </nav>
      <nav className="nav-bar">

        <NavLink 
          to="/"
          className="nav-bar-icon">
            <img src={ProjectLogo} />
          </NavLink>
        
        <div className="nav-bar mid-section">
        <NavLink 
          to="/"
          className={({isActive}) => 
            isActive ? "navbar-link-active home" : "navbar-link home"
          }>
            <h1>Home</h1>
          </NavLink>

          <NavLink 
          to="/products"
          className={({isActive}) => 
            isActive ? "navbar-link-active products" : "navbar-link products"
          }>
            <h1>Products</h1>
          </NavLink>

          <NavLink 
          to="/about"
          className={({isActive}) => 
            isActive ? "navbar-link-active about" : "navbar-link about"
          }>
            <h1>About</h1>
          </NavLink>

          <NavLink 
          to="/contact"
          className={({isActive}) => 
            isActive ? "navbar-link-active contact" : "navbar-link contact"
          }>
            <h1>Contact</h1>
          </NavLink>
        </div>
          {!isUserAuthenticated ? 
          <div className="nav-bar right-section">
          <NavLink 
          to="/search"
          className={({isActive}) => 
            isActive ? "navbar-link-active search" : "navbar-link search"
          }>
            <img src={SearchLogo} style={{height: "30px"}}/>
          </NavLink>

          <NavLink 
          to="/login"
          className={({isActive}) => 
            isActive ? "navbar-link-active sign-in" : "navbar-link sign-in"
          }>
            <h1>Sign in</h1>
          </NavLink>
          </div>
          :
          <div className="nav-bar right-section"> 
          <NavLink 
          to="/search"
          className={({isActive}) => 
            isActive ? "navbar-link-active search" : "navbar-link search"
          }>
            <img src={SearchLogo} style={{height: "30px"}}/>
          </NavLink>
          
          <NavLink 
          to="/cart"
          className={({isActive}) => 
            isActive ? "navbar-link-active cart" : "navbar-link cart"
          }
          style={{display: "flex"}}>
              <img src={ShoppingCartLogo} style={{height: "30px"}}/>
              {ItemAmountInCart != 0 &&
                <div className="cart-items-circle">
                  {ItemAmountInCart && ItemAmountInCart}
                </div>
              }
          </NavLink>
          
          <NavLink 
          to="/account/profile"
          className={({isActive}) => 
            isActive ? "navbar-link-active account" : "navbar-link account"
          }>
            <img src={AccountLogo} style={{height: "30px"}}/>
          </NavLink> 
          </div>
          }
      </nav>
      <Outlet />
    </div>
  );
}
