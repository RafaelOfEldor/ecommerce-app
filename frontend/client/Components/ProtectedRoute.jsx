import React, { useContext, Component, useEffect } from "react";
import { Link, Routes, Route, Outlet, useNavigate } from "react-router-dom";
import data from "../data";
import GoogleLogo from "../images/Google-g-logo.svg"
import Logo from "../images/Mock-Ecommerce.svg"
import {BsArrowLeftCircleFill, BsArrowRightCircleFill} from "react-icons/bs"
import {useAuth} from "../context/AuthContext"
const apiUrl = process.env.BACKEND_API_BASE_URL;

export default function ProtextedRoute({children}) {

  const navigate = useNavigate();
  const { isUserAuthenticated, getUserAuthentication } = useAuth()

  
  useEffect(() => {
    const checkUserAuthenticated = setTimeout(() => {
      console.log("yoo")
      if (!isUserAuthenticated) {
        navigate("/login")
    }
    }, 500);
  return () => clearTimeout(checkUserAuthenticated);
  }, [isUserAuthenticated]) 
  return isUserAuthenticated ? children : ""
}
