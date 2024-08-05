import React, { useContext, Component, useEffect } from "react";
import { useNavigate } from "react-router-dom";
import {useAuth} from "../context/AuthContext"
const apiUrl = window.__ENV__?.BACKEND_API_BASE_URL;

export default function ProtextedRoute({children}) {

  const navigate = useNavigate();
  const { isUserAuthenticated } = useAuth()

  
  useEffect(() => {
    const checkUserAuthenticated = setTimeout(() => {
      if (!isUserAuthenticated) {
        navigate("/login")
    }
    }, 500);
  return () => clearTimeout(checkUserAuthenticated);
  }, [isUserAuthenticated]) 
  return isUserAuthenticated ? children : ""
}
