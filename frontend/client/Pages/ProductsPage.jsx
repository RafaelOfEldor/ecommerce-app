import React, { useState, useEffect } from "react";
import { useNavigate } from "react-router-dom";
import { useAuth } from "../context/AuthContext";
import { BsArrowLeftCircleFill, BsArrowRightCircleFill } from "react-icons/bs";
import { VscListFilter } from "react-icons/vsc";
import { FiSearch } from "react-icons/fi";
import "./css/pages/productsPage.css"

const apiUrl = window.__ENV__?.BACKEND_API_BASE_URL;

export default function ProductsPage(props) {
  const [slide, setSlide] = useState(0);
  const [itemAddedToCart, setItemAddedToCart] = useState(false);
  const { isUserAuthenticated, userId, increaseAmountOfItemsInCart } = useAuth();
  const navigate = useNavigate();
  const [products, setProducts] = useState([]);
  const [page, setPage] = useState(0);
  const [loading, setLoading] = useState(false);
  const [category, setCategory] = useState("");
  const [searchQuery, setSearchQuery] = useState("");
  const [noResults, setNoResults] = useState(false);

  useEffect(() => {
    fetchProducts(0, false)
  }, []); 

  useEffect(() => {
    changePage(0, true)
  }, [category]);

  async function fetchProducts(page, changeByFilter) {
    const res = await fetch(`${apiUrl}/api/v1/products/${category === "" ? "" : category + "/"}page/${page}${
      searchQuery === "" ? "" : !changeByFilter ? "/" + searchQuery : ""}`);
    if (res.ok) {
      const data = await res.json();
      if (data.length > 0) {
        setNoResults(false)
        setPage(page);
        await loadImages(data);
        setProducts(data);
      } else if (searchQuery !== "") {
        setNoResults(true)
      }
    } else {
      // console.error("Failed to fetch products");
    }
  }

  async function loadImages(products) {
    const promises = products.map(
      (product) =>
        new Promise((resolve) => {
          const img = new Image();
          img.src = product.itemImage;
          img.onload = () => {
            // console.log(`Image loaded for product ${product.itemId}`);
            resolve();
          };
          img.onerror = () => {
            // console.error(`Failed to load image for product ${product.itemId}`);
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

  const handleBuyItem = async (event, itemId) => {
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
        navigate("/cart");
    } else {
      
    }
  } else {
    navigate("/login");
  };

}

  const changePage = async (newPage, changeByFilter) => {
    setLoading(true);
    await fetchProducts(newPage, changeByFilter);
    setLoading(false);
  };

  const handleCategoryChange = (event) => {
    setCategory(event.target.value);
    setPage(0); 
  };

  const handleSearchItem = async (event) => {
    event.preventDefault();
    setPage(0); 
    setLoading(true);
    await fetchProducts(0, false);
    setLoading(false);
  };


  const handleClearCategory = () => {
    setCategory("");
    setPage(0);
  };

  const handleSearchChange = (event) => {
    setSearchQuery(event.target.value);
    setPage(0, false); 
  };

  const productsElements = products.map((item, index) => (
    <div className="item-card" key={index} onClick={() => handleViewProduct(item.itemId)}>
      <img src={item.itemImage} loading="eager" className="item-image" style={{ maxHeight: "200px", maxWidth: "300px" }} />
      <h4 style={{marginTop: "auto"}}>{item.itemName}</h4>
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
        <h4 style={{ color: "green" }}>{item.itemInStock === true ? "in stock" : <h4 style={{color: "red"}}>Out of stock</h4>}</h4>
        <div style={{ display: "flex", justifyContent: "space-between", alignItems: "center", gap: "5px", marginTop: "10px" }}>
          <button disabled={!item?.inStock} className="item-card-addcart-button" onClick={(event) => handleAddItemToCart(event, item?.itemId)}>
            Add To Cart
          </button>
          <button disabled={!item?.inStock} className="item-card-buy-button" onClick={(event) => handleBuyItem(event, item?.itemId)}>
            Buy
          </button>
        </div>
      </div>
    </div>
  ));
  

  return (
    <div>
      <div style={{ display: "flex", justifyContent: "space-between", alignItems: "center", marginLeft: "10vw", marginRight: "10vw",
        marginTop: "2vh", zIndex: "99"
      }}>
        <div style={{ display: "flex", alignItems: "center" }}>
          <VscListFilter style={{ scale: "1.5" }} />
          <select value={category} onChange={handleCategoryChange} className="products-page-category-select" style={{ marginLeft: "20px" }}>
            <option value="">Sort by category</option>
            <option value="apparel">Apparel</option>
            <option value="jewelry">Jewelry</option>
            <option value="technology">Technology</option>
            <option value="gardening">Gardening</option>
            <option value="consumables">Consumables</option>
            <option value="furniture">Furniture</option>
          </select>
          {category !== "" && <button onClick={handleClearCategory} className="products-page-category-clear" style={{ marginLeft: "10px" }}>X</button>}
        </div>
        <form className="search-wrapper" onSubmit={(event) => handleSearchItem(event)}>
          <input
            type="text"
            placeholder="Search products..."
            value={searchQuery}
            onChange={handleSearchChange}
          />
          <FiSearch onClick={(event) => handleSearchItem(event)} className="search-icon" style={{ translate: "0% -30%"}} />
        </form>
      </div>
      <div className="item-cards">

        {noResults ? 
        <div>Couldnt find any such item...</div> 
        :
        loading ? <div>Loading...</div> : productsElements.length > 0 ? productsElements : <div>No products available</div>

      }
      </div>
      <div className={`item-added-to-cart-component ${itemAddedToCart ? "show" : ""}`}>
        <h1>Item added to cart</h1>
      </div>
      <div style={{ display: "flex", justifyContent: "space-around", alignItems: "center", margin: "0", padding: "10px"}}>
        <button
          onClick={() => changePage(page - 1, false)}
          disabled={page === 0}
          className="change-page-button previous"
        >
          previous page
        </button>
        <button
          onClick={() => changePage(page + 1, false)}
          className="change-page-button next"
        >
          next page
        </button>
      </div>
    </div>
  );
}
