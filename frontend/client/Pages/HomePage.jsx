import React, { useContext } from "react";
import { Link, Routes, Route, Outlet, useNavigate, useSearchParams } from "react-router-dom";
// import data from "../data";
import jacketImage from "../images/random-jacket.jpg"
import {BsArrowLeftCircleFill, BsArrowRightCircleFill} from "react-icons/bs"
import {useAuth} from "../context/AuthContext"
const apiUrl = process.env.BACKEND_API_BASE_URL;

export default function HomePage(props) {

  const [searchParams, setSearchParams] = useSearchParams();
  const itemId = searchParams.get(`itemid`);

  const [slide, setSlide] = React.useState(0);
  const [itemAddedToCart, setItemAddedToCart] = React.useState(false);
  const { isUserAuthenticated, username, userId, mail, firstName, lastName, role, logOut, increaseAmountOfItemsInCart  } = useAuth()
  const navigate = useNavigate();

  const [items, setItems] = React.useState([])
  const [carouselItems, setCarouselItems] = React.useState([])

  React.useEffect(() => {
    console.log(items)
  },[items])

  async function fetchProducts() {
    // fetch(`${apiUrl}/api/v1/products/page/${Math.floor((Math.random() * 3))}`).then((response) =>
    //   response.json().then((data) => {
    //     setItems(data);
    //   }),
    // );

    fetch(`${apiUrl}/api/v1/products/page/0`).then((response) =>
      response.json().then((data) => {
        setItems(data);
      }),
    );
  }

  async function fetchCarouselItems() {
    fetch(`${apiUrl}/api/v1/products/page/1`).then((response) =>
      response.json().then((data) => {
        setCarouselItems(data);
      }),
    );
  }

  React.useEffect(() => {
    fetchProducts();
    fetchCarouselItems();
  },[])

  const nextSlide = () => {
    if (slide + 1 < carouselElements.length) {
      setSlide(slide + 1)
    }
  }

  const previousSlide = () => {
    if (slide - 1 >= 0) {
    setSlide(slide - 1)
    }
  }

  function handleViewProduct(productId){
    navigate(`/products/product/view?itemid=${productId}`)
  }

  const handleAddItemToCart = async (event, itemId) => {
    event.stopPropagation();
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

  function handleBuyItem() {
    if (isUserAuthenticated) {
      console.log("yoo")
    } else {
      navigate("/login")
    }
  }

  const itemElements = items.map((item, index) => {
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

  const carouselElements = carouselItems.map((item, index) => {
    return (
      <div className={slide === index ? "slide" : "slide slide-hidden"} key={index} onClick={() => handleViewProduct(item.itemId)}>
        <img src={item.itemImage} style={{userSelect: "none", maxHeight: "200px", minHeight: "400px"}}/>
        <h4 style={{userSelect: "none"}}>{item.itemName}</h4>
        <h4 style={{userSelect: "none"}}>${item.itemPrice.toFixed(2)}</h4>
        <h5 style={{userSelect: "none"}}>{Array.from(item.itemDescription).map((item, index) => {
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
        <h4 style={{color: "green", userSelect: "none"}} >{item.itemInStock === true ? "in stock" : "out of stock"}</h4>
        {/* <h4 style={{userSelect: "none"}}>{item.itemReview[Math.floor((Math.random() * 3))].reviewRating} / 5</h4> */}
      </div>
      )
  })

  return (
    <div>
      <div className="homepage-carousel">
        <BsArrowLeftCircleFill className="arrow homepage-carousel-left" onClick={previousSlide}/>
        {items && carouselElements}
        <BsArrowRightCircleFill className="arrow homepage-carousel-right" onClick={nextSlide}/>
        <span className="indicators" >
          {carouselElements.map((_, index) => {
            return (
              <button key={index} onClick={null} className={slide === index ? "indicator" : "indicator indicator-inactive"} ></button>
            )
          })}
        </span>
      </div>
      <div style={{display: "flex", marginLeft: "10vw",}}>
        <h1>Products:</h1>
      </div>
      <div className="item-cards">
        {items && itemElements}
      </div>

      <div className={`item-added-to-cart-component ${itemAddedToCart ? 'show' : ''}`}>
        <h1>Item added to cart</h1>
      </div>
    </div>
  );
}