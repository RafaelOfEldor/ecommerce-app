import React, { useContext, Component } from "react";
import { Link, Routes, Route, Outlet, useNavigate } from "react-router-dom";
import data from "../data";
import GoogleLogo from "../images/Google-g-logo.svg"
import Logo from "../images/Mock-Ecommerce.svg"
import {BsArrowLeftCircleFill, BsArrowRightCircleFill} from "react-icons/bs"
import {useAuth} from "../context/AuthContext"

export default function AboutPage(props) {


  const { isUserAuthenticated } = useAuth()

  if (isUserAuthenticated()) {
    return (
      <div style={{display: "flex"}}>
      <h1>Hello</h1>
    </div>
    )
  } else {
    return (
      <div style={{display: "flex"}}>
      <h1>Please log in.</h1>
    </div>
    )
  }
}
