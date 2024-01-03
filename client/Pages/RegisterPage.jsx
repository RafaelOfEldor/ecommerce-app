import React, { useContext, Component } from "react";
import { Link, Routes, Route, Outlet, useNavigate } from "react-router-dom";
import data from "../data";
import GoogleLogo from "../images/Google-g-logo.svg"
import Logo from "../images/Mock-Ecommerce.svg"
import {BsArrowLeftCircleFill, BsArrowRightCircleFill} from "react-icons/bs"

export default function RegisterPage(props) {

  return (
    <div style={{display: "flex"}}>
      <img src={Logo} className="register-page-logo"/>
      <form className="register-form">
        <h1 style={{fontWeight: "500", letterSpacing: "1px"}}>Create an account</h1>
        <input placeholder="First Name" />
        <input placeholder="Last Name" />
        <input placeholder="Username" />
        <input placeholder="Email" />
        <input placeholder="Password" />
        <input placeholder="Confirm Password" />
        <button className="create-account-button">Create Account</button>
        <button className="login-google-button"> <img src={GoogleLogo}/>Sign up with Google</button>
        <div style={{display: "flex", gap: "20px", alignItems: "center"}}>
          <h4 style={{fontWeight: "300"}}>Already have an account? </h4>
          <Link to="/login">Log In</Link>
        </div>
      </form>
    </div>
  );
}
