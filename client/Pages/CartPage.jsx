import React, { useContext, Component, useEffect, useState } from "react";
import { Link, Routes, Route, Outlet, useNavigate, NavLink, useLocation } from "react-router-dom";
import data from "../data";
import GoogleLogo from "../images/Google-g-logo.svg"
import Logo from "../images/Mock-Ecommerce.svg"
import {BsArrowLeftCircleFill, BsArrowRightCircleFill} from "react-icons/bs"
import {useAuth} from "../context/AuthContext"

export default function CartPage(props) {


  const { isUserAuthenticated, username, userId, mail, firstName, lastName, role, logOut  } = useAuth()
  const navigate = useNavigate();
  const location = useLocation();
  const {pathname, hash, search} = location
  const pathText = pathname.split("/")
  const [cartDetails, setCartDetails] = useState([]);

  async function fetchCartInfo() {
    if (isUserAuthenticated) {
      const res = await fetch(`http://localhost:8080/api/v1/usercart/${userId}`, {
            method: "GET",
            headers: {
              Authorization: `Bearer ${localStorage.getItem("access_token")}`,
            }
          })
          if (res.ok) {
            const data = await res.json();
            setCartDetails(data.items)
            console.log(cartDetails)
          }
    }
  }

  useEffect(() => {
    fetchCartInfo()
  }, [])

  const cartElements = cartDetails.map((item, index) => {
    return (
      <div style={{display: "flex", maxWidth: "1200px", maxHeight: "100px", alignItems: "center", gap: "10px", backgroundColor: "rgba(0, 0, 0, 0.1)", borderStyle: "solid",
      borderWidth: "1px"}}>
        <div>
          <img src={item.itemImage} style={{maxHeight: "60px", maxWidth: "60px"}}/>
        </div>
        <div style={{height: "100px", width: "1px", backgroundColor: "black"}}></div>
        <div style={{display: "flex", flexDirection: "column"}}>
          <h4>{item.itemName}</h4>
          <h5 style={{fontWeight: "400", fontSize: "0.8rem"}}>{item.itemDescription}</h5>
          <h5>${item.itemPrice.toFixed(2)}</h5>
        </div>
      </div>
    )
  })
  return (
    <div style={{display: "flex", flexDirection: "column", marginLeft: "200px", marginTop: "100px", gap: "10px"}}>
      {cartElements}
  </div>
  )
}
