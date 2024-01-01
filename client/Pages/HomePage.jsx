import React, { useContext } from "react";
import { Link, Routes, Route, Outlet, useNavigate } from "react-router-dom";
import data from "../data";
import jacketImage from "../images/random-jacket.jpg"
import {BsArrowLeftCircleFill, BsArrowRightCircleFill} from "react-icons/bs"

export default function HomePage(props) {

  const [slide, setSlide] = React.useState(0);

  const [items, setItems] = React.useState(data)
  React.useEffect(() => {
    console.log("hii")
    console.log(items)
    console.log(itemElements)
  },[items])

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

  const itemElements = items.map((item, index) => {
    return (
      <div className="item-card">
        <img src={jacketImage}/>
        <h4>{item.itemName}</h4>
        <h4>${item.itemPrice}</h4>
        <h5>{item.itemDescription}</h5>
        <h4 style={{color: "green"}} >{item.itemInStock === "true" ? "in stock" : "out of stock"}</h4>
        <h4>{item.itemReview[Math.floor((Math.random() * 3))].reviewRating} / 5</h4>
      </div>
      )
  })

  const carouselElements = items.map((item, index) => {
    return (
      <div className={slide === index ? "slide" : "slide slide-hidden"} >
        <img src={jacketImage}/>
        <h4>{item.itemName}</h4>
        <h4>${item.itemPrice}</h4>
        <h5>{item.itemDescription}</h5>
        <h4 style={{color: "green"}} >{item.itemInStock === "true" ? "in stock" : "out of stock"}</h4>
        <h4>{item.itemReview[Math.floor((Math.random() * 3))].reviewRating} / 5</h4>
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
