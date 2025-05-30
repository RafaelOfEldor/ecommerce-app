import React from "react";
import { useNavigate } from "react-router-dom";
import {useAuth} from "../../context/AuthContext"
import "../css/components/privacyComponent.css"
const apiUrl = window.__ENV__?.BACKEND_API_BASE_URL;

export default function PrivacyComponent(props) {


  const { isUserAuthenticated, username, mail, firstName, lastName, role  } = useAuth()
  const navigate = useNavigate();

  return (
    <div className="account-page-div">
      <form className="profile-form">
        <h1>Your Profile</h1>
        <div style={{display: "flex", gap: "150px", marginTop: "100px"}}>
          <div>
            <h3>First Name</h3>
            <input placeholder={firstName} className="profile-form-input firstname"/>
          </div>
          <div>
            <h3>Last Name</h3>
            <input placeholder={lastName} className="profile-form-input lastname"/>
          </div>
        </div>
        <div style={{display: "flex", flexDirection: "column"}}>
            <h3>Username</h3>
            <input placeholder={username} className="profile-form-input username"/>
            <h3>Email</h3>
            <input placeholder={mail} className="profile-form-input email"/>
        </div>

        <button>Save Changes</button>
        
      </form>
  </div>
  )
}




