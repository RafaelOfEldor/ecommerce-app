import React, { useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import {useAuth} from "../../context/AuthContext"
import Triangle from "../../images/triangle.svg"
import "../css/components/purchasesComponent.css"
const apiUrl = window.__ENV__?.BACKEND_API_BASE_URL;

export default function PurchasesComponent(props) {


  const { isUserAuthenticated, username, mail, orders, firstName, getUserFromToken, lastName, role  } = useAuth()
  const [viewOrder, setViewOrder] = useState( {
    isActive: false,
    orderToSee: null
  })
  const navigate = useNavigate();

  function handleViewOrder(orderId) {
    setViewOrder(prev => {
      return (
        {
          isActive: orderId === prev.orderToSee ? !prev.isActive : true,
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
          <div style={{minWidth: "180px", maxWidth: "180px", alignItems: "center", justifyContent: "center", textAlign: "center"}}>
            <div style={{display: "flex", alignItems: "center"}}>
              <img src={Triangle} style={{maxHeight: "15px", maxWidth: "15px", marginRight: "50px", transform: "rotate(0deg)"}}/>
              <h3 style={{ marginLeft: "28px"}}>{order.orderId}</h3>
            </div>
          </div>
          <div style={{height: "40px", width: "1px", background: "linear-gradient(142deg, rgba(2,0,36,1) 0%, rgba(157,24,89,1) 37%, rgba(143,49,159,1) 57%, rgba(18, 61, 182, 1) 100%)"}}></div>
          <div style={{minWidth: "180px", maxWidth: "180px", alignItems: "center", justifyContent: "center", textAlign: "center"}}>
            <h3>{order.user.firstname} {order.user.lastname}</h3>
          </div>
          <div style={{height: "40px", width: "1px", background: "linear-gradient(142deg, rgba(2,0,36,1) 0%, rgba(157,24,89,1) 37%, rgba(143,49,159,1) 57%, rgba(18, 61, 182, 1) 100%)"}}></div>
          <div style={{minWidth: "180px", maxWidth: "180px", alignItems: "center", justifyContent: "center", textAlign: "center"}}>
            <h3>{order.address.addressStreetName} {order.address.addressHouseNumber}, {order.address.addressPostalCode}</h3>
          </div>
          <div style={{height: "40px", width: "1px", background: "linear-gradient(142deg, rgba(2,0,36,1) 0%, rgba(157,24,89,1) 37%, rgba(143,49,159,1) 57%, rgba(18, 61, 182, 1) 100%)"}}></div>
          <div style={{minWidth: "180px", maxWidth: "180px", alignItems: "center", justifyContent: "center", textAlign: "center"}}>
            <h3>soon</h3>
          </div>
          
        </div>


        <div className="order-items-div active">

          {order.items.map((item, index) => {
            return (
                  <div className="order-details-div active">
                    <h3>{item?.orderedItemName.slice(0, 10)}{item?.orderedItemName?.length > 9 && "..."}</h3>
                    <img src={item.orderedItemImage} style={{maxHeight: "40px"}}/>
                    <h5 style={{maxHeight: "15px"}}>
                      {Array.from(item.orderedItemDescription).map((item, index) => {
                          if (index < 50) {
                            return (
                            item
                            )
                          } else if (index >= 50 && index <= 53) {
                            return (
                              "."
                            )
                          }
                        })}
                    </h5>
                    <h3 style={{marginTop: "45px", minWidth: "150px", display: "flex", alignItems: "center"}}>
                    ${item.orderedItemPrice.toFixed(2)} <h5 style={{fontSize: "0.8rem", fontWeight: "600", marginLeft: "10px"}}>per unit </h5>
                    </h3>
                    <h5 style={{marginTop: "5px", marginRight: "69px", minWidth: "80px"}}>Quantity: {item.orderedItemQuantity}</h5>
                    <Link to={`/products/product/view?itemid=${item.orderedItemOriginalItemId}`} className="order-component-link">
                      View item
                    </Link>
                  </div>
                )
                
              }
              
            )
            
          }
        </div>

      </div>
      :
      <div className="order-component-div inactive" onClick={() => handleViewOrder(order.orderId)}>
        
        <div style={{minWidth: "180px", maxWidth: "180px", alignItems: "center", justifyContent: "center", textAlign: "center"}}>
          <div style={{display: "flex", alignItems: "center"}}>
              <img src={Triangle} style={{maxHeight: "15px", maxWidth: "15px", marginRight: "50px", transform: "rotate(-90deg)"}}/>
              <h3 style={{ marginLeft: "30px"}}>{order.orderId}</h3>
          </div>
        </div>
        <div style={{height: "40px", width: "1px", background: "linear-gradient(142deg, rgba(2,0,36,1) 0%, rgba(157,24,89,1) 37%, rgba(143,49,159,1) 57%, rgba(18, 61, 182, 1) 100%)"}}></div>
        <div style={{minWidth: "180px", maxWidth: "180px", alignItems: "center", justifyContent: "center", textAlign: "center"}}>
            <h3>{order.user.firstname} {order.user.lastname}</h3>
        </div>
          <div style={{height: "40px", width: "1px", background: "linear-gradient(142deg, rgba(2,0,36,1) 0%, rgba(157,24,89,1) 37%, rgba(143,49,159,1) 57%, rgba(18, 61, 182, 1) 100%)"}}></div>
          <div style={{minWidth: "180px", maxWidth: "180px", alignItems: "center", justifyContent: "center", textAlign: "center"}}>
            <h3>{order.address.addressStreetName} {order.address.addressHouseNumber}, {order.address.addressPostalCode}</h3>
          </div>
          <div style={{height: "40px", width: "1px", background: "linear-gradient(142deg, rgba(2,0,36,1) 0%, rgba(157,24,89,1) 37%, rgba(143,49,159,1) 57%, rgba(18, 61, 182, 1) 100%)"}}></div>
          <div style={{minWidth: "180px", maxWidth: "180px", alignItems: "center", justifyContent: "center", textAlign: "center"}}>
            <h3>soon</h3>
          </div>
      </div>
    )
  })

  return (
    <div style={{marginLeft: "50px", marginTop: "50px"}}>
      <h1>Your orders: </h1>
      <div className="order-page-div">
        <div style={{display: "flex", justifyContent: "space-around", alignItems: "center", width: "55vw", height: "50px", borderStyle: "solid",
      borderWidth: "1px"}}>
          <div style={{minWidth: "180px", maxWidth: "180px", alignItems: "center", justifyContent: "center", textAlign: "center"}}>
            <h3>order id:</h3>
          </div>
          <div style={{height: "40px", width: "1px", background: "linear-gradient(142deg, rgba(2,0,36,1) 0%, rgba(157,24,89,1) 37%, rgba(143,49,159,1) 57%, rgba(18, 61, 182, 1) 100%)"}}></div>
          <div style={{minWidth: "180px", maxWidth: "180px", alignItems: "center", justifyContent: "center", textAlign: "center"}}>
            <h3>Customer name:</h3>
          </div>
          <div style={{height: "40px", width: "1px", background: "linear-gradient(142deg, rgba(2,0,36,1) 0%, rgba(157,24,89,1) 37%, rgba(143,49,159,1) 57%, rgba(18, 61, 182, 1) 100%)"}}></div>
          <div style={{minWidth: "180px", maxWidth: "180px", alignItems: "center", justifyContent: "center", textAlign: "center"}}>
            <h3>Shipping to:</h3>
          </div>
          <div style={{height: "40px", width: "1px", background: "linear-gradient(142deg, rgba(2,0,36,1) 0%, rgba(157,24,89,1) 37%, rgba(143,49,159,1) 57%, rgba(18, 61, 182, 1) 100%)"}}></div>
          <div style={{minWidth: "180px", maxWidth: "180px", alignItems: "center", justifyContent: "center", textAlign: "center"}}>
            <h3>Expected arrival:</h3>
          </div>
        </div>
        {orderElements}
      </div>
    </div>
  )
}




