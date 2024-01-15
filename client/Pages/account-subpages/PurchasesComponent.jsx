import React, { useContext, Component, useState } from "react";
import { Link, Routes, Route, Outlet, useNavigate } from "react-router-dom";
import {useAuth} from "../../context/AuthContext"

export default function PurchasesComponent(props) {


  const { isUserAuthenticated, username, mail, orders, firstName, lastName, role  } = useAuth()
  const [viewOrder, setViewOrder] = useState( {
    isActive: false,
    orderToSee: null
  })
  const navigate = useNavigate();

  function handleViewOrder(orderId) {
    console.log("yoo")
    setViewOrder(prev => {
      return (
        {
          isActive: !prev.isActive,
          orderToSee: orderId
        }
      )
    })
  }

  const orderElements = orders.map((order, index) => {
    return (
      viewOrder?.isActive && viewOrder?.orderToSee === order.orderId ?

      <div className="order-component-div active"
      onClick={() => handleViewOrder(order.orderId)}>
        <div className="order-component-header">
        <h3>{order.orderId}</h3>
          <h3>{order.user.firstname} {order.user.lastname}</h3>
          <h3>{order.address.addressStreetName} {order.address.addressHouseNumber}, {order.address.addressPostalCode}</h3>
          <h3>3 Days or something</h3>
          
        </div>

        <h3>Details for order nr {order.orderId}:</h3>
        <div className="order-items-div active">

          {order.items.map((item, index) => {
            return (
                  <div className="order-details-div active">
                    <h3>{item.orderedItemName}</h3>
                  </div>
                )
              }
            )
          }

        </div>

      </div>
      :
      <div className="order-component-div inactive" onClick={() => handleViewOrder(order.orderId)}>
          <h3>{order.orderId}</h3>
          <h3>{order.user.firstname} {order.user.lastname}</h3>
          <h3>{order.address.addressStreetName} {order.address.addressHouseNumber}, {order.address.addressPostalCode}</h3>
          <h3>3 Days or something</h3>
      </div>
    )
  })

  return (
    <div className="order-page-div">
      <h1>Your orders: </h1>
      <div style={{display: "flex", justifyContent: "space-around", alignItems: "center", width: "1000px", height: "50px", backgroundColor: "pink", borderStyle: "solid",
    marginTop: "50px"}}>
        <h3>Order id:</h3>
        <h3>Customer name:</h3>
        <h3>Shipping to:</h3>
        <h3>Expected arrival:</h3>
      </div>
      {orderElements}
    </div>
  )
}




