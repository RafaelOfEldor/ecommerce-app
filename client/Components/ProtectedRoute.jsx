import React, { useContext, Component, useEffect } from "react";
import { Link, Routes, Route, Outlet, useNavigate } from "react-router-dom";
import data from "../data";
import GoogleLogo from "../images/Google-g-logo.svg"
import Logo from "../images/Mock-Ecommerce.svg"
import {BsArrowLeftCircleFill, BsArrowRightCircleFill} from "react-icons/bs"
import {useAuth} from "../context/AuthContext"

export default function ProtextedRoute({children}) {

  const navigate = useNavigate();
  const { isUserAuthenticated } = useAuth()

  useEffect(() => {
    if (!isUserAuthenticated()) {
        navigate("/login")
    }
  }, []) 
  return isUserAuthenticated() ? children : ""
}
