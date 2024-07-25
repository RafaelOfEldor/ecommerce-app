import React, { useContext, Component } from "react";
import { Link, Routes, Route, Outlet, useNavigate } from "react-router-dom";
import data from "../data";
import GoogleLogo from "../images/Google-g-logo.svg"
import Logo from "../images/Mock-Ecommerce.svg"
import {BsArrowLeftCircleFill, BsArrowRightCircleFill} from "react-icons/bs"
import {useAuth} from "../context/AuthContext"
const apiUrl = window.__ENV__?.BACKEND_API_BASE_URL;

export default function LoginPage(props) {

  const [errorMessage, setErrorMessage] = React.useState("")
  const { getUserFromToken, getUserAuthentication } = useAuth();
  
  const navigate = useNavigate();
  async function loginUser(e) {
    e.preventDefault()
    if (e.target.username.value === "" || e.target.password.value === "") {
      setErrorMessage("All fields Must be filled")
      return;
    }
      const userInfo = {
        username: e.target.username.value,
        password: e.target.password.value
    }

    const res = await fetch(`${apiUrl}/api/v1/auth/authenticate`, {
      method: "POST",
      body: JSON.stringify(userInfo),
      headers: {
        "content-type": "application/json",
      },
    })
    if (res.ok) {

      const data = await res.json();
      
      localStorage.setItem("access_token", data.token)
      console.log(data)
      
      getUserFromToken();
      getUserAuthentication();
      navigate("/")
    } else {
      setErrorMessage("Wrong username or password")
    }

}

  return (
    <div style={{display: "flex"}}>
      <img src={Logo} className="register-page-logo"/>
      <form className="register-form" onSubmit={loginUser}>
        <h1 style={{fontWeight: "500", letterSpacing: "1px"}}>Sign In</h1>
        <h4 style={{color: "red"}}>{errorMessage && errorMessage}</h4>
        <input placeholder="Username" name="username"/>
        <input placeholder="Password" name="password" type="password"/>
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
