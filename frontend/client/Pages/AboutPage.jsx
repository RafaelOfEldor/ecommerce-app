import React, { useContext, Component } from "react";
import { Link, Routes, Route, Outlet, useNavigate } from "react-router-dom";
import data from "../data";
import GoogleLogo from "../images/Google-g-logo.svg"
import Logo from "../images/Mock-Ecommerce.svg"
import {BsArrowLeftCircleFill, BsArrowRightCircleFill} from "react-icons/bs"
import {useAuth} from "../context/AuthContext"
const apiUrl = process.env.BACKEND_API_BASE_URL;

export default function AboutPage(props) {


  return (
    <div style={{display: "flex"}}>
    <h1>Hello</h1>
  </div>
  )
}
