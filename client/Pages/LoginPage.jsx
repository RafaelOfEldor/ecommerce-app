import React, { useContext, Component } from "react";
import { Link, Routes, Route, Outlet, useNavigate } from "react-router-dom";
import data from "../data";
import GoogleLogo from "../images/Google-g-logo.svg"
import Logo from "../images/Mock-Ecommerce.svg"
import {BsArrowLeftCircleFill, BsArrowRightCircleFill} from "react-icons/bs"

export default function LoginPage(props) {

  return (
    <div style={{display: "flex"}}>
      <img src={Logo} className="register-page-logo"/>
      <form className="register-form">
        <h1 style={{fontWeight: "500", letterSpacing: "1px"}}>Sign In</h1>
        <input placeholder="Username" />
        <input placeholder="Password" />
        <button className="create-account-button">Sign In</button>
        <button className="login-google-button"> <img src={GoogleLogo}/>Sign up with Google</button>
        <div style={{display: "flex", gap: "20px", alignItems: "center"}}>
          <h4 style={{fontWeight: "300"}}>Don't have an account? </h4>
          <Link to="/register">Sign Up</Link>
        </div>
      </form>
    </div>
  );
}
