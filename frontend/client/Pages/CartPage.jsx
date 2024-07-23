import React, { useContext, Component, useEffect, useState } from "react";
import { Link, Routes, Route, Outlet, useNavigate, NavLink, useLocation } from "react-router-dom";
import data from "../data";
import GoogleLogo from "../images/Google-g-logo.svg"
import Logo from "../images/Mock-Ecommerce.svg"
import {BsArrowLeftCircleFill, BsArrowRightCircleFill} from "react-icons/bs"
import {useAuth} from "../context/AuthContext"
const apiUrl = process.env.BACKEND_API_BASE_URL;

export default function CartPage(props) {


  const { isUserAuthenticated, username, userId, addresses, mail, firstName, lastName, role, getUserFromToken, logOut  } = useAuth()
  const navigate = useNavigate();
  const location = useLocation();
  const {pathname, hash, search} = location
  const pathText = pathname.split("/")
  const [cartDetails, setCartDetails] = useState([]);
  const [shippingAddress, setShippingAddress] = useState()
  const [itemsToBuyPreparedList, setitemsToBuyPreparedList] = useState([]);
  const [totalPrice, setTotalPrice] = useState();
  const [originalPrice, setOriginalPrice] = useState([]);
  const [errorMessage, setErrorMessage] = useState();

  async function fetchCartInfo() {
    if (isUserAuthenticated) {
      const res = await fetch(`${apiUrl}/api/v1/usercart/${userId}`, {
            method: "GET",
            headers: {
              Authorization: `Bearer ${localStorage.getItem("access_token")}`,
            }
          })
          if (res.ok) {
            const data = await res.json();
            setCartDetails(data.items)
            setOriginalPrice(prev => data.items.map((item) => {
              return (
                item.itemPrice
              )
            }))
            setitemsToBuyPreparedList(prev => data.items.map((item) => {
              return (
                {
                itemName: item.itemName,
                itemOrigianlId: item.itemId,
                itemImage: item.itemImage,
                itemPrice: item.itemPrice,
                itemDescription: item.itemDescription,
                itemCategory: item.itemCategory,
                itemQuantity: 1
                }
              )
            }))
            let sum = 0;
            for (let i = 0; i <cartDetails.length; i++) {
              sum += cartDetails[i].itemPrice
            }
            console.log(cartDetails)
            console.log(originalPrice)
            console.log(sum)
            setTotalPrice(sum)
          }
    }
  }

  async function handleRemoveFromCart(itemId) {
    if (isUserAuthenticated) {
      const removeFromCartElement = {
        userId: userId,
        itemId: itemId
      }
      console.log(JSON.stringify())
      const res = await fetch(`${apiUrl}/api/v1/user/cart/removeitem`, {
            method: "POST",
            body: JSON.stringify(removeFromCartElement),
            headers: {
              "content-type": "application/json",
              Authorization: `Bearer ${localStorage.getItem("access_token")}`,
            }
          })
          if (res.ok) {
            const data = await res.json();
            console.log(data)
          }
    } else {
      navigate("/login")
    }

    window.location.reload()
  }

  const adressOptionsElement = addresses.map(item => {
    return (
        <option 
          value={item.addressId} style={{padding: "50px", fontSize: "1rem", textAlign: "center"}}>
          {item.addressStreetName} {item.addressHouseNumber}, {item.addressPostalCode} 
        </option>
           )
        }
    )
  async function handleCheckout() {
    if (addresses.length === 0) {
      setErrorMessage("You need a shipping address to checkout. You can add one here")
    } else if (!shippingAddress) {
      setErrorMessage("You need to select a shipping address before proceeding to checkout")
    } else {
      const purchaseElement = {
        userId: userId,
        addressId: shippingAddress,
        items: itemsToBuyPreparedList
      }

      const res = await fetch("http://localhost:8080/api/v1/usercart/checkout", {
            method: "POST",
            body: JSON.stringify(purchaseElement),
            headers: {
              "content-type": "application/json",
              Authorization: `Bearer ${localStorage.getItem("access_token")}`,
            }
          })
          if (res.ok) {
            const data = await res.json();
            console.log(data)
            getUserFromToken()
            const awaitRedirect = setTimeout(() => {
              navigate("/account/purchases")
            }, 500);
            return () => clearTimeout(awaitRedirect);
          }
          
      console.log(shippingAddress)
    }
    /*
    Create an object containg a Long "userId" and an array items containing ItemsWithQuantityDTO.
    Example:

    userId: userId,
    addressId: shippingAddress,
    items: itemsToBuyPreparedList
    
    */
  }

  const handleQuantityChange = (index, event) => {
    const newCartDetails = [...cartDetails];
    const newItemsToBuyDetails = [...itemsToBuyPreparedList]

    const newQuantity = parseInt(event.target.value, 10);
  
    newCartDetails[index].itemPrice = originalPrice[index] * newQuantity;
    newItemsToBuyDetails[index].itemQuantity = newQuantity;
    console.log(originalPrice)
    console.log(newQuantity)
    console.log(newCartDetails[index].itemPrice)
  
    setCartDetails(newCartDetails);
    setitemsToBuyPreparedList(newItemsToBuyDetails)
    calculateTotalPrice(); // Update the total price based on the changes
  };

  console.log(cartDetails)
  console.log(itemsToBuyPreparedList)

  const handleAddressSelect = (event) => {
    setShippingAddress(event.target.value)
  }

  console.log(shippingAddress)

  function calculateTotalPrice() {
    let sum = 0;
    for (let i = 0; i <cartDetails.length; i++) {
      sum += cartDetails[i].itemPrice
    }
    setTotalPrice(sum)
  }

  useEffect(() => {
    fetchCartInfo()
  }, [])

  useEffect(() => {
    calculateTotalPrice()
  }, [cartDetails])

  const cartElements = cartDetails.map((item, index) => {
    return (
      <div className="cart-items-div" key={index}>
        <div>
          <img src={item.itemImage} style={{maxHeight: "100px", maxWidth: "100px", minWidth: "100px"}}/>
        </div>
        <div style={{height: "180px", width: "1px", backgroundColor: "black"}}></div>
        <div style={{display: "flex", flexDirection: "column"}}>
          <h4>{item.itemName}</h4>
          <h5 style={{fontWeight: "400", fontSize: "0.8rem", maxWidth: "650px"}}>
          {Array.from(item.itemDescription).map((item, index) => {
          if (index < 200) {
            return (
            item
            )
          } else if (index >= 200 && index <= 203) {
            return (
              "."
            )
          }
        })}
          </h5>
          
        <div className="cart-item-operations-div">
          <button onClick={() => handleRemoveFromCart(item.itemId)} >Remove from cart</button>
        </div>
        </div>
        <div style={{display: "flex", alignItems: "center", justifyContent: "center", paddingLeft: "140px", flexDirection: "column",
          gap: "20px"}}
        >
          <h3 style={{}}>${item.itemPrice.toFixed(2)}</h3>
          <select className="cart-quantity-selecter"
          onChange={(event) => handleQuantityChange(index, event)}
          >
            <option value={1}>Qty: 1</option>
            <option value={2}>Qty: 2</option>
            <option value={3}>Qty: 3</option>
            <option value={4}>Qty: 4</option>
            <option value={5}>Qty: 5</option>
          </select>
        </div>
        
      </div>
    )
  })
  return (
    <div className="cart-page-div">
      <div className="cart-div">
        <h1 style={{marginRight: "770px"}}>Shopping Cart</h1>
        <div style={{height: "1px", width: "1000px", background: "linear-gradient(142deg, rgba(2,0,36,1) 0%, rgba(157,24,89,1) 37%, rgba(143,49,159,1) 57%, rgba(18, 61, 182, 1) 100%)"}}></div>
        {cartElements}
        <div style={{height: "1px", width: "1000px", background: "linear-gradient(142deg, rgba(2,0,36,1) 0%, rgba(157,24,89,1) 37%, rgba(143,49,159,1) 57%, rgba(18, 61, 182, 1) 100%)"}}></div>
        <div style={{display: "flex", alignItems: "flex-end", maxHeight: "50px", justifyContent: "flex-end", padding: "20px"}}>
          <h3 style={{marginLeft: "770px", fontWeight: "400"}}
          >Subtotal {`(${cartElements?.length != 0 && cartElements.length} items)`}: <b>${totalPrice && totalPrice.toFixed(2)}</b></h3>
        </div>
      </div>

      <div className="checkout-from-cart-div">
        
        <h4 style={{fontWeight: "400", color: "green"}}>
          Our company provides <b>100% free shipping</b> anywhere in the world! 
        </h4 >
        <h4 style={{fontWeight: "400", color: "green"}}>Unhappy with your purchase? No problem! We provide a 100% money-back-guarantee for our dissatisfied customers</h4>
        <div style={{display: "flex", alignItems: "center", gap: "10px"}}>
          <h3 style={{fontWeight: "400"}}>Ship to:</h3>
          <select style={{height: "30px", width: "200px", textAlign: "center"}} onChange={(event) => handleAddressSelect(event)}>
            <option style={{padding: "50px", fontSize: "1rem", textAlign: "center"}} value={null}>Select address</option>
            {adressOptionsElement}
          </select>
        </div>
        <h3 style={{fontWeight: "400"}}>Subtotal {`(${cartElements?.length != 0 && cartElements.length} items)`}: <b>${totalPrice && totalPrice.toFixed(2)}</b></h3>
        <button onClick={handleCheckout}>Proceed to checkout</button>
        {errorMessage && <h5 style={{color: "red", fontWeight: "400", textAlign: "center"}}>{errorMessage}</h5>}
      </div>
    </div>
  )
}
