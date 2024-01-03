import React, { useContext, Component } from "react";
import { Link, Routes, Route, Outlet, useNavigate } from "react-router-dom";
import data from "../data";
import GoogleLogo from "../images/Google-g-logo.svg"
import Logo from "../images/Mock-Ecommerce.svg"
import {BsArrowLeftCircleFill, BsArrowRightCircleFill} from "react-icons/bs"

export default function RegisterPage(props) {

  const [errorMessage, setErrorMessage] = React.useState("")

  async function registerUser(e) {
    e.preventDefault()
    if (e.target.firstName.value === "" 
    || e.target.lastName.value === "" 
    || e.target.username.value === "" 
    || e.target.email.value === "" 
    || e.target.password.value === ""
    || e.target.confirmPassword.value === "") {
      setErrorMessage("All fields Must be filled")
      return;
    }
    if (e.target.password.value === e.target.confirmPassword.value) {
      const userInfo = {
        firstname: e.target.firstName.value,
        lastname: e.target.lastName.value,
        username: e.target.username.value,
        email: e.target.email.value,
        password: e.target.password.value
    }

    const res = await fetch("http://localhost:8080/api/v1/auth/register", {
      method: "POST",
      body: JSON.stringify(userInfo),
      headers: {
        "content-type": "application/json",
      },
    })
    const data = await res.json();
    console.log(data)
  }
}

  return (
    <div style={{display: "flex"}}>
      <h4 style={{color: "red", position: "absolute", letterSpacing: "1px", marginLeft: "74vw", marginTop: "10vh"}}>{errorMessage !== "" && errorMessage}</h4>
      <img src={Logo} className="register-page-logo"/>
      <form className="register-form" onSubmit={registerUser}>
        <h1 style={{fontWeight: "500", letterSpacing: "1px"}}>Create an account</h1>
        <input placeholder="First Name" name="firstName" />
        <input placeholder="Last Name" name="lastName" />
        <input placeholder="Username" name="username" />
        <input placeholder="Email" name="email" />
        <input placeholder="Password" name="password" type="password"/>
        <input placeholder="Confirm Password" name="confirmPassword" type="password" />
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
