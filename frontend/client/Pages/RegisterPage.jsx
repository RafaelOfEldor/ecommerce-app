import React, { useContext, Component } from "react";
import { Link, useNavigate } from "react-router-dom";
import Logo from "../images/Mock-Ecommerce.svg"
import {useAuth} from "../context/AuthContext"
import "./css/pages/registerAndLoginPage.css"
import LoginWithOpenidButton from "../functions/LoginWithOpenidButton";

const apiUrl = window.__ENV__?.BACKEND_API_BASE_URL;

export default function RegisterPage(props) {

  const [errorMessage, setErrorMessage] = React.useState("")
  const { getUserFromToken, getUserAuthentication } = useAuth();
  
  const navigate = useNavigate();
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
    } else if (!/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(e.target.email.value))
    {
      setErrorMessage("Invalid email")
      return;
    } else if (e.target.password.value !== e.target.confirmPassword.value) {
      setErrorMessage("Passwords do not match")
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

    const res = await fetch(`${apiUrl}/api/v1/auth/register`, {
      method: "POST",
      body: JSON.stringify(userInfo),
      headers: {
        "content-type": "application/json",
      },
    })
    if (res.ok) {
      const data = await res.json(); 
      localStorage.setItem("access_token", data.token)
      getUserFromToken();
      getUserAuthentication()
      navigate("/")
    } else {
      setErrorMessage("Username already taken");
    }
  }

  

}

  return (
    <div style={{display: "flex"}}>
      <img src={Logo} className="register-page-logo"/>
      <form className="register-form" onSubmit={registerUser}>
        <h1 style={{fontWeight: "500", letterSpacing: "1px"}}>Create an account</h1>
        <h4 style={{color: "red", letterSpacing: "1px", position: "absolute", top: "550"}}>{errorMessage !== "" && errorMessage}</h4>
        <input placeholder="First Name" name="firstName" />
        <input placeholder="Last Name" name="lastName" />
        <input placeholder="Username" name="username" />
        <input placeholder="Email" name="email" />
        <input placeholder="Password" name="password" type="password"/>
        <input placeholder="Confirm Password" name="confirmPassword" type="password" />
        <button className="create-account-button">Create Account</button>
        <LoginWithOpenidButton />
        <div style={{display: "flex", gap: "20px", alignItems: "center"}}>
          <h4 style={{fontWeight: "300"}}>Already have an account? </h4>
          <Link to="/login">Log In</Link>
        </div>
      </form>
    </div>
  );
}
