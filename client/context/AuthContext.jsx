import {
  createContext,
  useContext,
  useEffect,
  useState,
  useNavigate
} from "react";

import {userNavigate} from "react-router-dom"
import {getCustomers, login as performLogin} from "../../services/client.js";
import jwtDecode from "jwt-decode";

const AuthContext = React.createContext({
  username: undefined,
  mail: undefined,
  firstName: undefined,
  lastName: undefined,
  loadUser: async () => {},
  fetchUserInfo: async () => {},
});


export function useAuth() {
  return useContext(AuthContext);
}

export function AuthProvider({ children }) {
  const navigate = useNavigate();
  const [username, setUsername] = React.useState();
  const [fullName, setFullName] = React.useState();
  const [userId, setUserId] = React.useState();
  const [mail, setMail] = React.useState();
  const [webSocket, setWebSocket] = React.useState();
  const [userBio, setUserBio] = React.useState();
  const [userInfo, setUserInfo] = React.useState();

  const getAuthConfig = () => ({
    headers: {
        Authorization: `Bearer ${localStorage.getItem("access_token")}`
    }
})

  async function getUserFromToken() {
      let token = localStorage.getItem("access_token");
      if (token) {
        if (Date.now() < token.exp) {
          token = jwtDecode(token);
          setUsername(token.sub)
          const res = await fetch("http://localhost:8080/api/v1/user/userinfo", {
            method: "POST",
            headers: {
              Authorization: `Bearer ${localStorage.getItem("access_token")}`
            }
          })
        } else {
          // resetUserInfo()
          // localStorage.removeItem("access_token")
          console.log("Session expired, please login")
          navigate("/login")
        }
      } else {
        navigate("/login")
      }
  }

  useEffect(() => {
    getUserFromToken()
  }, [])

  

  async function fetchUserInfo() {
    fetch(`/api/users/byid/${userId}`).then((response) =>
      response.json().then((data) => {
        setUserInfo(data);
      }),
    );
  }

  return (
    <AuthContext.Provider
      value={{
        username,
        fullName,
        userId,
        userInfo,
        mail,
        webSocket,
        userBio,
        google_client_id: googleClientId,
        microsoft_client_id: microsoftClientId,
        microsoft_openid_config: openIdMicrosoftUrl,
        google_openid_config: openIdGoogleUrl,
        setUsername,
        setUserId,
        setWebSocket,
        fetchUserInfo,
        loadUser,
      }}
    >
      {children}
    </AuthContext.Provider>
  );
}

const AuthProvider = ({ children }) => {

  


  const login = async (usernameAndPassword) => {
      return new Promise((resolve, reject) => {
          performLogin(usernameAndPassword).then(res => {
              const jwtToken = res.headers["authorization"];
              localStorage.setItem("access_token", jwtToken);

              const decodedToken = jwtDecode(jwtToken);

              setCustomer({
                  username: decodedToken.sub,
                  roles: decodedToken.scopes
              })
              resolve(res);
          }).catch(err => {
              reject(err);
          })
      })
  }

  const logOut = () => {
      localStorage.removeItem("access_token")
      setCustomer(null)
  }

  const isCustomerAuthenticated = () => {
      const token = localStorage.getItem("access_token");
      if (!token) {
          return false;
      }
      const { exp: expiration } = jwtDecode(token);
      if (Date.now() > expiration * 1000) {
          logOut()
          return false;
      }
      return true;
  }

  return (
      <AuthContext.Provider value={{
          customer,
          login,
          logOut,
          isCustomerAuthenticated,
          setCustomerFromToken
      }}>
          {children}
      </AuthContext.Provider>
  )
}

export const useAuth = () => useContext(AuthContext);

export default AuthProvider;