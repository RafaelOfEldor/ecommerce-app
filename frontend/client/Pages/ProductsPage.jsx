import React, { useState, useEffect } from "react";
import { useNavigate } from "react-router-dom";
import { useAuth } from "../context/AuthContext";
import { BsArrowLeftCircleFill, BsArrowRightCircleFill } from "react-icons/bs";

const apiUrl = window.__ENV__?.BACKEND_API_BASE_URL;

export default function ProductsPage(props) {
  const [slide, setSlide] = useState(0);
  const [itemAddedToCart, setItemAddedToCart] = useState(false);
  const { isUserAuthenticated, userId, increaseAmountOfItemsInCart } = useAuth();
  const navigate = useNavigate();
  const [products, setProducts] = useState([]);
  const [page, setPage] = useState(0);
  const [loading, setLoading] = useState(false);

  useEffect(() => {
    changePage(page);
  }, []);

  async function fetchProducts(page) {
    console.log(`Fetching products for page ${page}`);
    const res = await fetch(`${apiUrl}/api/v1/products/page/${page}`);
    if (res.ok) {
      const data = await res.json();
      console.log("Products data fetched:", data);
      if (data.length > 0) {
        setPage(page);
        await loadImages(data);
        setProducts(data);
      }
    } else {
      console.error("Failed to fetch products");
    }
  }

  async function loadImages(products) {
    console.log("Loading images for products");
    const promises = products.map(
      (product) =>
        new Promise((resolve) => {
          const img = new Image();
          img.src = product.itemImage;
          img.onload = () => {
            console.log(`Image loaded for product ${product.itemId}`);
            resolve();
          };
          img.onerror = () => {
            console.error(`Failed to load image for product ${product.itemId}`);
            resolve();
          };
        })
    );
    return Promise.all(promises);
  }

  function handleViewProduct(productId) {
    navigate(`/products/product/view?itemid=${productId}`);
  }

  const handleAddItemToCart = async (event, itemId) => {
    event.stopPropagation();
    if (isUserAuthenticated) {
      const addToCartElement = {
        userId: userId,
        itemId: itemId,
      };
      const res = await fetch(`${apiUrl}/api/v1/user/cart/additem`, {
        method: "POST",
        body: JSON.stringify(addToCartElement),
        headers: {
          "content-type": "application/json",
          Authorization: `Bearer ${localStorage.getItem("access_token")}`,
        },
      });
      if (res.ok) {
        const data = await res.json();
        increaseAmountOfItemsInCart();
        setItemAddedToCart(true);

        const addedToCartDuration = setTimeout(() => {
          setItemAddedToCart(false);
        }, 2000);
        return () => clearTimeout(addedToCartDuration);
      }
    } else {
      navigate("/login");
    }
  };

  const handleBuyItem = async (event) => {
    event.stopPropagation();
    if (isUserAuthenticated) {
      console.log("yoo");
    } else {
      navigate("/login");
    }
  };

  const changePage = async (newPage) => {
    setLoading(true);
    await fetchProducts(newPage);
    setLoading(false);
  };

  const productsElements = products.map((item, index) => (
    <div className="item-card" key={index} onClick={() => handleViewProduct(item.itemId)}>
      <img src={item.itemImage} loading="eager" style={{ maxHeight: "200px", maxWidth: "300px" }} />
      <h4>{item.itemName}</h4>
      <h4>${item.itemPrice.toFixed(2)}</h4>
      <h5>
        {Array.from(item.itemDescription).map((item, index) => {
          if (index < 150) {
            return item;
          } else if (index >= 150 && index <= 153) {
            return ".";
          }
        })}
      </h5>
      <div style={{ display: "flex", justifyContent: "space-between", alignItems: "center" }}>
        <h4 style={{ color: "green" }}>{item.itemInStock === true ? "in stock" : "out of stock"}</h4>
        <div style={{ display: "flex", justifyContent: "space-between", alignItems: "center", gap: "5px" }}>
          <button className="item-card-addcart-button" onClick={(event) => handleAddItemToCart(event, item?.itemId)}>
            Add To Cart
          </button>
          <button className="item-card-buy-button" onClick={() => handleBuyItem(item?.itemId)}>
            Buy
          </button>
        </div>
      </div>
    </div>
  ));

  return (
    <div>
      <div style={{ display: "flex", marginLeft: "10vw" }}>
        <h1>Products:</h1>
      </div>
      <div className="item-cards">
        {loading ? <div>Loading...</div> : productsElements.length > 0 ? productsElements : <div>No products available</div>}
      </div>
      <div className={`item-added-to-cart-component ${itemAddedToCart ? "show" : ""}`}>
        <h1>Item added to cart</h1>
      </div>
      <div style={{ display: "flex", justifyContent: "center", alignItems: "center" }}>
        <button
          onClick={() => changePage(page - 1)}
          disabled={page === 0}
          style={{
            marginTop: "50px",
            width: "200px",
            height: "100px",
            backgroundColor: "blue",
            color: "white",
            border: "none",
            fontSize: "1.2rem",
          }}
        >
          previous page
        </button>
        <button
          onClick={() => changePage(page + 1)}
          style={{
            marginLeft: "50vw",
            transform: "translate(-50%",
            marginTop: "50px",
            width: "200px",
            height: "100px",
            backgroundColor: "blue",
            color: "white",
            border: "none",
            fontSize: "1.2rem",
          }}
        >
          next page
        </button>
      </div>
    </div>
  );
}
