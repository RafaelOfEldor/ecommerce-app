import React, { useContext, useState } from "react";
import { Link, Routes, Route, Outlet, useNavigate } from "react-router-dom";
// import data from "../data";
import jacketImage from "../images/random-jacket.jpg"
import {BsArrowLeftCircleFill, BsArrowRightCircleFill} from "react-icons/bs"
import {useAuth} from "../context/AuthContext"
const apiUrl = process.env.BACKEND_API_BASE_URL;

export default function ProductsPage(props) {

  const [slide, setSlide] = React.useState(0);
  const [itemAddedToCart, setItemAddedToCart] = React.useState(false);
  const { isUserAuthenticated, username, userId, mail, firstName, lastName, role, logOut, increaseAmountOfItemsInCart  } = useAuth()
  const navigate = useNavigate();

  const [products, setProducts] = React.useState([])
  const [page, setPage] = useState(0)

  async function fetchProducts() {
    fetch(`${apiUrl}/api/v1/products/page/${page}`).then((response) =>
      response.json().then((data) => {
        setProducts(data);
      }),
    );
  }

  React.useEffect(() => {
    fetchProducts();
  },[page])

  function handleViewProduct(productId){
    navigate(`/products/product/view?itemid=${productId}`)
  }

  const handleAddItemToCart = async (event, itemId) => {
    event.stopPropagation()
    if (isUserAuthenticated) {
      const addToCartElement = {
        userId: userId,
        itemId: itemId
      }
      console.log(JSON.stringify())
      const res = await fetch(`${apiUrl}/api/v1/user/cart/additem`, {
            method: "POST",
            body: JSON.stringify(addToCartElement),
            headers: {
              "content-type": "application/json",
              Authorization: `Bearer ${localStorage.getItem("access_token")}`,
            }
          })
          if (res.ok) {
            const data = await res.json();
            increaseAmountOfItemsInCart()
            console.log(data)
            setItemAddedToCart(true)

            const addedToCartDuration = setTimeout(() => {
              console.log("it happened")
              setItemAddedToCart(false)
            }, 2000);
            return () => clearTimeout(addedToCartDuration);
          }

    } else {
      navigate("/login")
    }
  }

  const handleBuyItem = async (event) => {
    event.stopPropagation()
    if (isUserAuthenticated) {
      console.log("yoo")
    } else {
      navigate("/login")
    }
  }

  const productsElements = products.map((item, index) => {
    return (
      <div className="item-card" key={index} onClick={() => handleViewProduct(item.itemId)}>
        <img src={item.itemImage} style={{maxHeight: "200px", maxWidth: "300px"}}/>
        <h4>{item.itemName}</h4>
        <h4>${item.itemPrice.toFixed(2)}</h4>
        <h5>{Array.from(item.itemDescription).map((item, index) => {
          if (index < 150) {
            return (
            item
            )
          } else if (index >= 150 && index <= 153) {
            return (
              "."
            )
          }
        })}</h5>
        <div style={{display: "flex", justifyContent: "space-between", alignItems: "center"}}>
          <h4 style={{color: "green"}} >{item.itemInStock === true ? "in stock" : "out of stock"}</h4>
          <div style={{display: "flex", justifyContent: "space-between", alignItems: "center", gap: "5px"}}>
            <button
            className="item-card-addcart-button"
            onClick={(event) => handleAddItemToCart(event, item?.itemId)}
            >
              Add To Cart</button>
            <button
            className="item-card-buy-button"
            onClick={() => handleBuyItem(item?.itemId)}
            >
              Buy</button>
            </div>
        </div>
        {/* <h4>{item.itemReview[Math.floor((Math.random() * 3))].reviewRating} / 5</h4> */}
      </div>
      )
  })

  return (
    <div>
      
      <div style={{display: "flex", marginLeft: "10vw",}}>
        <h1>Products:</h1>
      </div>
      <div className="item-cards">
        {products && productsElements}
      </div>

      <div className={`item-added-to-cart-component ${itemAddedToCart ? 'show' : ''}`}>
        <h1>Item added to cart</h1>
      </div>
      <div style={{display: "flex", justifyContent: "center", alignItems: "center"}}>
        <button onClick={() => setPage(prev => prev - 1)}
        style={{ marginTop: "50px", width: "200px", height: "100px", backgroundColor: "blue", color: "white", border: "none",
          fontSize: "1.2rem", }}>
          previous page
        </button>
        <button onClick={() => setPage(prev => prev + 1)}
        style={{marginLeft: "50vw", transform: "translate(-50%", marginTop: "50px", width: "200px", height: "100px", backgroundColor: "blue", color: "white", border: "none",
          fontSize: "1.2rem", }}>
          next page
        </button>
        </div>
    </div>
  );
}
