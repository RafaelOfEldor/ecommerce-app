import React, { useContext, useState } from "react";
import { Link, Routes, Route, Outlet, useNavigate, useSearchParams } from "react-router-dom";
// import data from "../data";
import jacketImage from "../images/random-jacket.jpg"
import {BsArrowLeftCircleFill, BsArrowRightCircleFill} from "react-icons/bs"
import {useAuth} from "../context/AuthContext"
const apiUrl = window.__ENV__?.BACKEND_API_BASE_URL;

export default function ProductComponent(props) {

  const [slide, setSlide] = React.useState(0);
  const [itemAddedToCart, setItemAddedToCart] = React.useState(false);
  const { isUserAuthenticated, username, userId, mail, firstName, lastName, role, logOut, orders, increaseAmountOfItemsInCart  } = useAuth()
  const [searchParams, setSearchParams] = useSearchParams();
  const navigate = useNavigate();

  const itemId = searchParams.get(`itemid`);

  const [product, setProduct] = useState({})
  const [productRating, setProductRating] = useState(null)
  const [page, setPage] = useState(0)
  const [canReview, setCanReview] = useState(false);
  const [reviewText, setReviewText] = useState("");
  const [reviewRating, setReviewRating] = useState(1);
  const [showReviewAddition, setShowReviewAddition] = useState(false);


  async function fetchProduct() {
    if (itemId){
      fetch(`${apiUrl}/api/v1/products/${itemId}`).then((response) =>
      response.json().then((data) => {
        console.log(data)
        let alreadyReviewed = data?.reviews?.find(item => item.reviewAuthor === username);
        console.log(username)
        console.log(alreadyReviewed)
        if (alreadyReviewed || username !== "") {
          setCanReview(false);
        } else {
          orders?.map((order, index) => {
            order?.items?.map((item) => {
              if (itemId.toString() === item.orderedItemOriginalItemId.toString()) {
                console.log("in here!")
                  return (
                    setCanReview(true)
                  )
              }
            })
            
          })
        }

        setProduct(data);
        let i = 0;
        data.reviews?.map((item) => {
          i += item.reviewRating;
        })
        setProductRating((i/data.reviews?.length))
      }),
      );
    }
  }

  const handleAddReview = async () => {
    location.reload();
    const reviewComponent = {
      reviewComment: reviewText,
      itemId: itemId,
      reviewRating: reviewRating,
      userId: userId,
      reviewAuthor: username,
      reviewPublishDate: new Date().toLocaleString()

    }
    const res = await fetch(`${apiUrl}/api/v1/reviews/addreview`, {
      method: "POST",
      body: JSON.stringify(reviewComponent),
      headers: {
        "content-type": "application/json",
        Authorization: `Bearer ${localStorage.getItem("access_token")}`,
      }
    })
    if (res.ok) {
      const data = await res.json();
      console.log(data)
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
  

  const handleSettingReviewText = (event) => {
    setReviewText(event.target.value);
    console.log(reviewText);
  }

  const handleSettingReviewRating = (event) => {
    setReviewRating(Number(event.target.value));
    console.log(reviewRating);
  }

  
  function handleBuyItem() {
    if (isUserAuthenticated) {
      console.log("yoo")
    } else {
      navigate("/login")
    }
  }

  return (
    <div className="product-details-page">
      <div className="product-details-page-product-div">
        <div className="product-details-page-product-div-image">
          <img src={product?.itemImage} />
        </div>
        <div className="product-details-page-product-div-info-div">
          <h1  className="product-details-page-product-div-name">{product?.itemName}</h1>
          <div style={{display: "flex", alignItems: "center"}}>
            <h4  className="product-details-page-product-div-category">
              {product?.reviews?.length > 0 && productRating.toFixed(2) + " / 5"} 
            </h4>
            <h4 style={{fontWeight: "400", marginLeft: "10px"}}> {`${product?.reviews?.length > 0 ? "(" + product?.reviews?.length + " reviews)" : "no reviews"}`}</h4>
            <h4 style={{fontWeight: "400", marginLeft: "10px"}}> | </h4>
            <h4  className="product-details-page-product-div-stock" style={{marginLeft: "5px"}}>  {product?.itemInStock ? "In stock" : "Out of stock"}</h4>
          </div>
          <h4  className="product-details-page-product-div-price">${product?.itemPrice?.toFixed(2)}</h4>
          <h4  className="product-details-page-product-div-description">{product?.itemDescription}</h4>
          <div style={{height: "1px", minWidth: "400px", maxWidth: "400px", marginTop: "20px", background: "linear-gradient(142deg, rgba(2,0,36,1) 0%, rgba(157,24,89,1) 37%, rgba(143,49,159,1) 57%, rgba(18, 61, 182, 1) 100%)"}}></div>
          <div style={{display: "flex", gap: "20px", marginTop: "20px"}}>
          <button
            className="item-card-addcart-button" style={{width: "190px", height: "50px"}}
            onClick={() => handleAddItemToCart(product?.itemId)}
            >
              Add To Cart</button>
            <button
            className="item-card-buy-button" style={{width: "190px", height: "50px"}}
            onClick={() => handleBuyItem(product?.itemId)}
            >
              Buy</button>
          </div>
          <div style={{display: "flex", flexDirection: "column", alignItems: "center", width: "400px", gap: "20px", marginTop: "20px", borderStyle: "solid", borderRadius: "10px",
          borderWidth: "2px", background: "linear-gradient(142deg, rgba(2,0,36,0.8) 0%, rgba(157,24,89,0.2) 37%, rgba(143,49,159,0.8) 57%, rgba(18, 61, 182, 0.8) 100%)"}}>
          <h3>Free shipping</h3>
          <h4>Get free shipping anywhere in the world</h4>
          </div>
        </div>
        
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
    <div style={{display: "flex", justifyContent: "center", alignItems: "center", marginTop: "50px"}}>
      <div style={{height: "1px", minWidth: "95vw", maxWidth: "95vw", marginTop: "20px", background: "linear-gradient(142deg, rgba(2,0,36,1) 0%, rgba(157,24,89,1) 37%, rgba(143,49,159,1) 57%, rgba(18, 61, 182, 1) 100%)"}}></div>
    </div>
    <div style={{display: "flex", justifyContent: "", alignItems: "center", marginTop: "50px"}}>
      <h1 style={{marginLeft: "5vw"}}>Reviews</h1>
    </div>
    
    
    <div style={{display: "flex", alignItems: "flex-start", justifyContent: "space-between", width: "100vw", height: "auto",  marginTop: "50px", paddingBottom: "5vh", overflow: "auto"}}>
    
      <div style={{display: "flex", flexDirection: "column", gap: "50px", marginTop: "50px", paddingLeft: "200px"}}>
      {/* {orders?.map((order, index) => {
          order?.items?.map((item) => {
            if (itemId.toString() === item.orderedItemOriginalItemId.toString()) {
              console.log("in here!")
              return (
                
              )
            }
          })
          
        })} */}
        
        

        
        {canReview && 
          <div style={{ display: 'flex', flexDirection: 'column', marginTop: '50px' }}> 
          <h3 style={{ color: 'green' }}>You've recently purchased this item! Leave a review: </h3>
          <div style={{
            maxWidth: '1500px',
            minWidth: '70vw',
            borderStyle: 'solid',
            borderWidth: '2px',
            borderImage: 'linear-gradient(142deg, rgba(2,0,36,1) 0%, rgba(157,24,89,1) 37%, rgba(143,49,159,1) 57%, rgba(18,61,182,1) 100%)',
            borderImageSlice: '1',
            padding: '10px',
            
          }}>
            <label htmlFor="rating" style={{ display: 'block', fontSize: '1.2em' }}>Rate: </label>
            <div style={{display: "flex", gap: "10px"}}>
            <select id="rating" name="rating" style={{ marginBottom: '10px' }} value={reviewRating} onChange={handleSettingReviewRating}>
              <option value="1">1</option>
              <option value="2">2</option>
              <option value="3">3</option>
              <option value="4">4</option>
              <option value="5">5</option>
            </select>

            <h4 style={{fontWeight: "400"}}> / </h4>
            <h4 style={{fontWeight: "400"}}> 5</h4>
            </div>
            <textarea style={{ width: '100%', height: '100px', marginBottom: '10px' }} value={reviewText} placeholder="Write review here" onChange={handleSettingReviewText}>
              {reviewText}
            </textarea>
            <h4 style={{ fontWeight: '500' }}><b>Purchased by: </b>{username}</h4>
          </div>  
          <button style={reviewText === "" ?
            { height: '25px', width: '100px', marginTop: '20px', borderStyle: "none", background: "rgba(184, 200, 181, 0.8)", borderRadius: "10px",
            }
          :
            {
              height: '25px', width: '100px', marginTop: '20px', borderStyle: "none", background: "rgba(128, 221, 154, 0.8)", borderRadius: "10px",
              cursor: "pointer"
            }}
           disabled={reviewText === ""}
           onClick={handleAddReview}>Add review</button>
        </div>
        }
        {product?.reviews?.length > 0 ? product?.reviews?.map((item, index) => {
          return (
            <div key={index} style={{
              maxWidth: "1500px",
              minWidth: "70vw",
              borderStyle: "solid",
              borderWidth: "2px",
              borderImage: "linear-gradient(142deg, rgba(2,0,36,1) 0%, rgba(157,24,89,1) 37%, rgba(143,49,159,1) 57%, rgba(18, 61, 182, 1) 100%)",
              borderImageSlice: "1",
              padding: "10px",
              background: "rgba(136, 228, 227, 0.4)"
              }}>
              <h3 style={{fontWeight: "500"}}>{item.reviewRating} / 5</h3>
              <h4 style={{fontWeight: "400", marginTop: "10px"}}>{item.reviewComment}</h4>
              <h4 style={{fontWeight: "500", marginTop: "10px"}}> <b>Purchased by: </b>{item.reviewAuthor}</h4>
            </div>
            )
          }) 
          :
          <div style={{
            maxWidth: "1500px",
            minWidth: "70vw",
            borderStyle: "solid",
            borderWidth: "2px",
            borderImage: "linear-gradient(142deg, rgba(2,0,36,1) 0%, rgba(157,24,89,1) 37%, rgba(143,49,159,1) 57%, rgba(18, 61, 182, 1) 100%)",
            borderImageSlice: "1",
            padding: "10px",
            background: "rgba(136, 228, 227, 0.4)",
            textAlign: "center"
            }}>
            <h2 style={{fontWeight: "500"}}>There are currently no reviews for this item. You can leave reviews on items that you've purchased.</h2>
          </div>
        }

      </div>
    </div>
  </div>
  );
}
