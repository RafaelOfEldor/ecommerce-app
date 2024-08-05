import React, { useContext, useEffect, useState, Component } from "react";
import { Link, Routes, Route, Outlet, useNavigate } from "react-router-dom";
import {useAuth} from "../../context/AuthContext"
import "../css/components/profileComponent.css"

const apiUrl = window.__ENV__?.BACKEND_API_BASE_URL;

export default function AccountProfileComponent(props) {

const [loadingChanges, setLoadingChanges] = React.useState(false)
  const { isUserAuthenticated, username, mail, firstName,
    lastName, role, setFirstName, setLastName, setMail,
    setUsername, getUserFromToken, getUserAuthentication  } = useAuth()
  const navigate = useNavigate();

  async function handleSaveChanges(e) {
    e.preventDefault();
    setLoadingChanges(true)
    const refreshPage = setTimeout(() => {
      location.reload()
      setLoadingChanges(false)
    }, 2000);
    
    if (e.target.firstname.value !== "") {
      const res = await fetch(`${apiUrl}/api/v1/user/change/firstname`, {
        method: "POST",
        body: JSON.stringify({
          username: username,
          detailToChange: e.target.firstname.value
        }),
        headers: {
          "content-type": "application/json",
          Authorization: `Bearer ${localStorage.getItem("access_token")}`,
        }
      })
      if (res.ok) {
        setFirstName(prev => e.target.firstname.value)
      }
    }
    if (e.target.lastname.value !== "") {
      const res = await fetch(`${apiUrl}/api/v1/user/change/lastname`, {
        method: "POST",
        body: JSON.stringify({
          username: username,
          detailToChange: e.target.lastname.value
        }),
        headers: {
          "content-type": "application/json",
          Authorization: `Bearer ${localStorage.getItem("access_token")}`,
        }
      })
      if (res.ok) {
        setLastName(prev => e.target.lastname.value)
      }
    }
    // if (e.target.username.value !== "") {
    //   const res = await fetch(`${apiUrl}/api/v1/user/change/username`, {
    //     method: "POST",
    //     body: JSON.stringify({
    //       username: username,
    //       detailToChange: e.target.username.value
    //     }),
    //     headers: {
    //       "content-type": "application/json",
    //       Authorization: `Bearer ${localStorage.getItem("access_token")}`,
    //     }
    //   })
    //   if (res.ok) {
    //     setUsername(prev => e.target.username.value)
    //     getUserFromToken();
    //     getUserAuthentication();
    //     navigate("/account/profile")
    //   }
    // }
    if (e.target.mail.value !== "") {
      e.preventDefault()
      const res = await fetch(`${apiUrl}/api/v1/user/change/email`, {
        method: "POST",
        body: JSON.stringify({
          username: username,
          detailToChange: e.target.mail.value
        }),
        headers: {
          "content-type": "application/json",
          Authorization: `Bearer ${localStorage.getItem("access_token")}`,
        }
      })
      if (res.ok) {
        setLastName(prev => e.target.mail.value)
      }
    }

    return () => clearTimeout(refreshPage);
  }

  const [displayUsername, setDisplayUsername] = useState("");

    useEffect(() => {
        const words = username.split(' ');

        const hasNumbers = words.slice(1).some(word => /\d/.test(word));

        if (hasNumbers) {
            setDisplayUsername(words[0]);
        } else {
            setDisplayUsername(username);
        }
    }, [username]);

  return (
    <div className="account-page-div">
      <form className="profile-form" onSubmit={handleSaveChanges}>
        <h1>Your Profile</h1>
        <div style={{display: "flex", gap: "150px", marginTop: "100px"}}>
          <div>
            <h3>First Name</h3>
            <input placeholder={firstName} className="profile-form-input firstname" name="firstname"/>
          </div>
          <div>
            <h3>Last Name</h3>
            <input placeholder={lastName} className="profile-form-input lastname" name="lastname"/>
          </div>
        </div>
        <div style={{display: "flex", flexDirection: "column"}}>
            <h3>Username {"(immutable)"}</h3>
            <input placeholder={displayUsername} disabled={true}className="profile-form-input username" name="username"/>
            <h3>Email</h3>
            <input placeholder={mail} className="profile-form-input email" name="mail"/>
        </div>
        {
          loadingChanges && <h1 style={{position: "absolute", marginTop: "59.5vh", marginLeft: "15vw", fontSize: "1.8rem", color: "green"}}>Loading changes...</h1>
        }
        <button>Save Changes</button>
        
      </form>
  </div>
  )
}




