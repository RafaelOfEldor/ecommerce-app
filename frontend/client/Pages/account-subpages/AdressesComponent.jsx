import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import {useAuth} from "../../context/AuthContext"
import "../css/components/addressesComponent.css"

const apiUrl = window.__ENV__?.BACKEND_API_BASE_URL;

export default function AdressesComponent(props) {


  const { isUserAuthenticated, username, addresses, setAddresses, userId, orders, mail, firstName, lastName, role  } = useAuth()
  const [addAddress, setAddAddress] = useState(false)
  const navigate = useNavigate();

  async function handleAddAddress(e){
    e.preventDefault()
    const newAddressElement = {
      userId: userId,
      addressStreetName: e.target.streetname.value,
      addressHouseNumber: e.target.housenumber.value,
      addressPostalCode: e.target.postalcode.value
    }

    const res = await fetch(`${apiUrl}/api/v1/address`, {
            method: "POST",
            body: JSON.stringify(newAddressElement),
            headers: {
              "content-type": "application/json",
              Authorization: `Bearer ${localStorage.getItem("access_token")}`,
            }
          })
          if (res.ok) {
            const data = await res.json();
            setAddAddress(false)
            setAddresses(prevAddresses => [...prevAddresses, data]);
          }
          
  }

  if (addAddress) {
    return (
      <div className="account-add-address-div">
        <form className="account-add-address-form" onSubmit={handleAddAddress}>
          <div style={{display: "flex", gap: "100px"}}>
            <div>
              <h3>Street name:</h3>
              <input placeholder="Street Name:"style={{height: "50px", width: "400px"}} name="streetname"/>
            </div>

            <div>
              <h3>House/Apartment number:</h3>
              <input placeholder="House/Apartment Number:"style={{height: "50px", width: "400px"}} name="housenumber"/>
            </div>
          </div>
          <h3>Postal code:</h3>
          <input placeholder="Postal Code:" name="postalcode"/>
          <button>Confirm</button>
        </form>
        <button onClick={() => setAddAddress(false)}>{`<- Back`}</button>
      </div>
      )
  } else {
    return (
      addresses.length === 0 ? 
        <div className="account-addresses-page">
        <h1>Your addresses:</h1>
        
        <div>
        <h1>You currently don't have any addresses</h1>
        </div>
        
        <button onClick={() => setAddAddress(true)}>Add an address</button>
        </div>

        :

        <div className="account-addresses-page">
        <h1>Your addresses:</h1>
        
        <div>
          <div className="address-component-heading-layout">
            <div style={{minWidth: "180px", maxWidth: "180px", alignItems: "center", justifyContent: "center", textAlign: "center"}}>
              <h3>Address nr: </h3>
            </div>
            <div style={{height: "40px", width: "1px", background: "linear-gradient(142deg, rgba(2,0,36,1) 0%, rgba(157,24,89,1) 37%, rgba(143,49,159,1) 57%, rgba(18, 61, 182, 1) 100%)"}}></div>
            <div style={{minWidth: "180px", maxWidth: "180px", alignItems: "center", justifyContent: "center", textAlign: "center"}}>
              <h3>Street name: </h3>
            </div>
            <div style={{height: "40px", width: "1px", background: "linear-gradient(142deg, rgba(2,0,36,1) 0%, rgba(157,24,89,1) 37%, rgba(143,49,159,1) 57%, rgba(18, 61, 182, 1) 100%)"}}></div>
            <div style={{minWidth: "180px", maxWidth: "180px", alignItems: "center", justifyContent: "center", textAlign: "center"}}>
              <h3>House/Apartment number: </h3>
            </div>
            <div style={{height: "40px", width: "1px", background: "linear-gradient(142deg, rgba(2,0,36,1) 0%, rgba(157,24,89,1) 37%, rgba(143,49,159,1) 57%, rgba(18, 61, 182, 1) 100%)"}}></div>
            <div style={{minWidth: "180px", maxWidth: "180px", alignItems: "center", justifyContent: "center", textAlign: "center"}}>
              <h3>Postal code: </h3>
            </div>
          </div>
          <div >
            {addresses.map((item, index) => {
              return (
                  <div className="address-component">
                    <div style={{minWidth: "180px", maxWidth: "180px", alignItems: "center", justifyContent: "center", textAlign: "center"}}>
                      <h3>{index + 1}</h3>
                    </div>
                    <div style={{height: "40px", width: "1px", background: "linear-gradient(142deg, rgba(2,0,36,1) 0%, rgba(157,24,89,1) 37%, rgba(143,49,159,1) 57%, rgba(18, 61, 182, 1) 100%)"}}></div>
                    <div style={{minWidth: "180px", maxWidth: "180px", alignItems: "center", justifyContent: "center", textAlign: "center"}}>
                      <h3>{item.addressStreetName}</h3>
                    </div>
                    <div style={{height: "40px", width: "1px", background: "linear-gradient(142deg, rgba(2,0,36,1) 0%, rgba(157,24,89,1) 37%, rgba(143,49,159,1) 57%, rgba(18, 61, 182, 1) 100%)"}}></div>
                    <div style={{minWidth: "180px", maxWidth: "180px", alignItems: "center", justifyContent: "center", textAlign: "center"}}>
                      <h3>{item.addressHouseNumber}</h3>
                    </div>
                    <div style={{height: "40px", width: "1px", background: "linear-gradient(142deg, rgba(2,0,36,1) 0%, rgba(157,24,89,1) 37%, rgba(143,49,159,1) 57%, rgba(18, 61, 182, 1) 100%)"}}></div>
                    <div style={{minWidth: "180px", maxWidth: "180px", alignItems: "center", justifyContent: "center", textAlign: "center"}}>
                      <h3>{item.addressPostalCode}</h3>
                    </div>
                  </div>
                )
            })}
          </div>
        </div>
        
        <button onClick={() => setAddAddress(true)}>Add an address</button>
        </div>
        

    )
  } 
}
