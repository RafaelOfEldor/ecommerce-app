import React, { useContext } from "react";
import { Link, Routes, Route, Outlet, useNavigate } from "react-router-dom";
// import data from "../data";
import jacketImage from "../images/random-jacket.jpg"
import {BsArrowLeftCircleFill, BsArrowRightCircleFill} from "react-icons/bs"
import {useAuth} from "../context/AuthContext"

export default function HomePage(props) {

  const [slide, setSlide] = React.useState(0);
  const { isUserAuthenticated, username, mail, firstName, lastName, role, logOut  } = useAuth()
  const navigate = useNavigate();

  const [items, setItems] = React.useState([])
  const [carouselItems, setCarouselItems] = React.useState([])

  React.useEffect(() => {
    console.log(items)
  },[items])

  async function fetchProducts() {
    // fetch(`http://localhost:8080/api/v1/products/page/${Math.floor((Math.random() * 3))}`).then((response) =>
    //   response.json().then((data) => {
    //     setItems(data);
    //   }),
    // );

    fetch(`http://localhost:8080/api/v1/products/page/0`).then((response) =>
      response.json().then((data) => {
        setItems(data);
      }),
    );
  }

  async function fetchCarouselItems() {
    fetch(`http://localhost:8080/api/v1/products/page/1`).then((response) =>
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

  function handleAddItemToCart() {
    if (isUserAuthenticated) {
      console.log("yoo")
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
      <div className="item-card" key={index}>
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
            onClick={handleAddItemToCart}
            >
              Add To Cart</button>
            <button
            className="item-card-buy-button"
            onClick={handleBuyItem}
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
      <div className={slide === index ? "slide" : "slide slide-hidden"} key={index}>
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
    </div>
  );
}
