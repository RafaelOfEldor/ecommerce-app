import React, { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import { useAuth } from "../context/AuthContext";
const apiUrl = window.__ENV__?.BACKEND_API_BASE_URL;


export default function LoginCallbackPage(props) {
  const [debug, setDebug] = useState();
  const [error, setError] = useState();
  const navigate = useNavigate();
  const { loadUser } = useAuth();
  const { getUserFromToken, getUserAuthentication } = useAuth();

  async function handleCallback() {
    const hashObject = Object.fromEntries(new URLSearchParams(window.location.hash.substring(1)));
    setDebug(hashObject.access_token);
    const { access_token, state, code, error, error_description } = hashObject;

    if (error) {
      setError(error_description);
      return;
    }

    if (access_token) {
      const res = await fetch(`${apiUrl}/api/v1/auth/login/google`, {
        method: "POST",
        body: JSON.stringify({ access_token }),
        headers: {
          "Content-Type": "application/json",
        },
      });

      if (!res.ok) {
        throw new Error("Something went wrong in callback " + res.statusText);
      }

      const authResponse = await res.json();
      if (authResponse.token) {
        localStorage.setItem("access_token", authResponse.token)
        getUserFromToken();
        getUserAuthentication();
        navigate("/");
      } else {
        setError("Authentication failed");
      }
    }
  }

  useEffect(() => {
    handleCallback();
  }, [window.location.hash]);

  return (
    <div style={{ marginTop: "100px" }}>
      <div className="loading-results-layout-div">
        <h1> Loading profile... </h1>
      </div>
      <div>{error}</div>
    </div>
  );
}
