import React, { useContext, useState } from "react";
import { Link, Routes, Route, Outlet, useNavigate, useSearchParams } from "react-router-dom";
// import data from "../data";
import jacketImage from "../images/random-jacket.jpg"
import {BsArrowLeftCircleFill, BsArrowRightCircleFill} from "react-icons/bs"
import {useAuth} from "../context/AuthContext"

export default function ProductComponent(props) {

  const [slide, setSlide] = React.useState(0);
  const [itemAddedToCart, setItemAddedToCart] = React.useState(false);
  const { isUserAuthenticated, username, userId, mail, firstName, lastName, role, logOut, increaseAmountOfItemsInCart  } = useAuth()
  const [searchParams, setSearchParams] = useSearchParams();
  // const navigate = useNavigate();

  const itemId = searchParams.get(`itemid`);

  const [product, setProduct] = React.useState({})
  const [page, setPage] = useState(0)

  console.log(itemId)

  async function fetchProduct() {
    if (itemId){
      fetch(`http://localhost:8080/api/v1/products/${itemId}`).then((response) =>
      response.json().then((data) => {
        console.log(data)
        setProduct(data);
      }),
      );
    }
  }

  React.useEffect(() => {
    fetchProduct();
  },[itemId])

  async function handleAddItemToCart(itemId) {
    if (isUserAuthenticated) {
      const addToCartElement = {
        userId: userId,
        itemId: itemId
      }
      console.log(JSON.stringify())
      const res = await fetch("http://localhost:8080/api/v1/user/cart/additem", {
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

  return (
    <div>
      <h1 style={{maxHeight: "100px", maxWidth: "100px"}}>{product?.itemName}</h1>
      <img src={product?.itemImage} style={{maxHeight: "100px", maxWidth: "100px"}}/>
      <h4 style={{maxHeight: "100px", maxWidth: "100px"}}>{product?.itemCategory}</h4>
      <h4 style={{maxHeight: "100px", maxWidth: "1000px"}}>{product?.itemDescription}</h4>
      <h4 style={{maxHeight: "100px", maxWidth: "100px"}}>{product?.itemPrice}</h4>
      <h4 style={{maxHeight: "100px", maxWidth: "100px"}}>{product?.itemStock}</h4>
      {/* itemCategory
      "apparel"
      itemDescription
      "The sports jacket, a versatile and timeless piece of outerwear, seamlessly blends style and functionality. Crafted from high-quality materials, this jacket embodies a perfect marriage of form and function, making it an essential addition to any wardrobe. The exterior showcases a sophisticated design, characterized by a tailored fit that accentuates the wearer's silhouette. The meticulous attention to detail is evident in the fine stitching and carefully chosen fabrics, ensuring a polished and refined appearance.\n\nConstructed to withstand varying weather conditions, the sports jacket provides a comfortable and breathable layer. Its lightweight yet durable composition makes it an ideal choice for transitional seasons or as a stylish outer layer during cooler evenings. The jacket features a zippered front closure and a well-designed collar, offering both protection from the elements and a touch of classic elegance.\n\nVersatility is a key attribute of this sports jacket. Whether paired with jeans for a casual outing or worn over a crisp shirt for a more formal affair, it effortlessly adapts to various occasions. Pockets, both functional and stylish, add practicality to the design, allowing for the convenient storage of essentials while maintaining a sleek aesthetic.\n\nIn summary, the sports jacket is a sartorial essential, marrying fashion and function in a way that complements the modern lifestyle. With its timeless appeal and thoughtful design, this jacket stands as a symbol of sophistication and practicality, making it a wardrobe staple for those who appreciate both style and substance."
      itemId
      1
      itemImage
      "https://pngimg.com/d/jacket_PNG8047.png"
      itemInStock
      true
      itemName
      "Jacket"
      itemPrice
      36.088667288943256
      itemStock
      250 */}
    </div>
  );
}
