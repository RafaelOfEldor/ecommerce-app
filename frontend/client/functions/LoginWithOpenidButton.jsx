import React from "react";
import "../Pages/css/pages/registerAndLoginPage.css"
import GoogleLogo from "../images/Google-g-logo.svg";
const apiUrl = window.__ENV__?.BACKEND_API_BASE_URL;

export default function LoginWithOpenidButton() {
  const [authorizationUrl, setAuthorizationUrl] = React.useState();

  async function loadAuthorizationUrl() {
    const credentialsRes = await fetch(apiUrl + "/api/v1/auth/login/credentials");
    const credentials = await credentialsRes.json();
    const { google_openid_config, google_client_id } = credentials;

    const state = randomString(50);
    window.sessionStorage.setItem("state", state);

    const res = await fetch(google_openid_config);
    const discoveryDoc = await res.json();
    const params = {
      response_mode: "fragment",
      response_type: "token",
      client_id: google_client_id,
      redirect_uri: window.location.origin + "/login/callback",
      scope: "profile email",
      prompt: "consent",
      state,
    };
    setAuthorizationUrl(discoveryDoc.authorization_endpoint + "?" + new URLSearchParams(params));
  }
  React.useEffect(() => {
    loadAuthorizationUrl();
  }, []);

  const handleClick = (event) => {
    event.preventDefault();
    event.stopPropagation();
  };

  return (
    <div >
      <a style={{textDecoration: "none", color: "black"}} href={authorizationUrl} className="login-google-button">
        <img src={GoogleLogo} alt="Google Logo" />
        Sign up with Google
      </a>
    </div>
  );
}

function randomString(length) {
  let result = "";
  const characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
  const charactersLength = characters.length;
  let counter = 0;
  while (counter < length) {
    result += characters.charAt(Math.floor(Math.random() * charactersLength));
    counter += 1;
  }
  return result;
}