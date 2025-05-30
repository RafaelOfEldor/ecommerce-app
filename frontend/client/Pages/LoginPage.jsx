import React, { useState, useEffect } from "react";
import { Link, useNavigate } from "react-router-dom";
import GoogleLogo from "../images/Google-g-logo.svg";
import Logo from "../images/Mock-Ecommerce.svg";
import { useAuth } from "../context/AuthContext";
import "./css/pages/registerAndLoginPage.css"
import LoginWithOpenidButton from "../functions/LoginWithOpenidButton";

const apiUrl = window.__ENV__?.BACKEND_API_BASE_URL;

export default function LoginPage(props) {
  const [errorMessage, setErrorMessage] = useState("");
  const [loading, setLoading] = useState(true);
  const { getUserFromToken, getUserAuthentication } = useAuth();
  const navigate = useNavigate();

  useEffect(() => {
    const preloadImages = async () => {
      const images = [GoogleLogo, Logo];
      await loadImages(images);
      setLoading(false);
    };

    preloadImages();
  }, []);

  const loadImages = (images) => {
    return Promise.all(
      images.map(
        (image) =>
          new Promise((resolve, reject) => {
            const img = new Image();
            img.src = image;
            img.onload = resolve;
            img.onerror = reject;
          })
      )
    );
  };

  async function loginUser(e) {
    e.preventDefault();
    if (e.target.username.value === "" || e.target.password.value === "") {
      setErrorMessage("All fields Must be filled");
      return;
    }

    const userInfo = {
      username: e.target.username.value,
      password: e.target.password.value,
    };

    const res = await fetch(`${apiUrl}/api/v1/auth/authenticate`, {
      method: "POST",
      body: JSON.stringify(userInfo),
      headers: {
        "content-type": "application/json",
      },
    });

    if (res.ok) {
      const data = await res.json();
      localStorage.setItem("access_token", data.token);
      getUserFromToken();
      getUserAuthentication();
      navigate("/");
    } else {
      setErrorMessage("Wrong username or password");
    }
  }

  if (loading) {
    return <div style={{ display: "flex", justifyContent: "center", alignItems: "center", height: "100vh" }}>Loading...</div>;
  }

  return (
    <div style={{ display: "flex" }}>
      <img src={Logo} className="register-page-logo" alt="Logo" />
      <form className="register-form" onSubmit={loginUser}>
        <h1 style={{ fontWeight: "500", letterSpacing: "1px" }}>Sign In</h1>
        <h4 style={{ color: "red" }}>{errorMessage && errorMessage}</h4>
        <input placeholder="Username" name="username" />
        <input placeholder="Password" name="password" type="password" />
        <button className="create-account-button">Sign In</button>
        <LoginWithOpenidButton />
        <div style={{ display: "flex", gap: "20px", alignItems: "center" }}>
          <h4 style={{ fontWeight: "300" }}>Don't have an account? </h4>
          <Link to="/register">Sign Up</Link>
        </div>
      </form>
    </div>
  );
}
