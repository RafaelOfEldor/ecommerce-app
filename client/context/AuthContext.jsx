import React, {
  createContext,
  useContext,
  useEffect,
  useState,
} from "react";

import {jwtDecode} from "jwt-decode";

const AuthContext = React.createContext({
  username: undefined,
  mail: undefined,
  firstName: undefined,
  lastName: undefined,
  role: undefined,
  isUserAuthenticated: undefined,
  getUserFromToken: async () => {},
  logOut: () => {}
});


export function useAuth() {
  return useContext(AuthContext);
}

export function AuthProvider({ children }) {
  const [username, setUsername] = React.useState();
  const [firstName, setFirstName] = React.useState();
  const [role, setRole] = React.useState();
  const [lastName, setLastName] = React.useState();
  const [mail, setMail] = React.useState();
  const [isUserAuthenticated, setIsUserAuthenticated] = React.useState();
  const [webSocket, setWebSocket] = React.useState();

  const getAuthConfig = () => ({
    headers: {
        Authorization: `Bearer ${localStorage.getItem("access_token")}`
    }
})

  async function getUserFromToken() {
      let token = localStorage.getItem("access_token");
      if (token) {
        const { exp: expiration } = jwtDecode(token);
        if (Date.now() < expiration * 1000) {
          token = jwtDecode(token);
          setUsername(token.sub)
          const res = await fetch("http://localhost:8080/api/v1/user/userinfo", {
            method: "POST",
            body: JSON.stringify({
              username: token.sub
            }),
            headers: {
              "content-type": "application/json",
              Authorization: `Bearer ${localStorage.getItem("access_token")}`,
            }
          })
          if (res.ok) {
            const data = await res.json();
            setIsUserAuthenticated(true)
            setUsername(data.userName)
            setFirstName(data.firstName)
            setLastName(data.lastName)
            setMail(data.email)
            setRole(data.role)
            console.log(data)
          }
        } else {
          logOut();
          resetUserInfo();
          console.log("Session expired, please login")
        }
      } else {
      }
  }

  useEffect(() => {
    getUserFromToken()
  }, [])

  const logOut = () => {
    localStorage.removeItem("access_token")
    setIsUserAuthenticated()
    setUsername()
    setFirstName()
    setLastName()
    setMail()
    setRole()
    
    // resetUserInfo()
}

const getUserAuthentication = () => {
  console.log("yoo")
    const token = localStorage.getItem("access_token");
    if (!token) {
      return false;
    }
    const { exp: expiration } = jwtDecode(token);
    if (Date.now() > expiration * 1000) {
        logOut()
    } else {
      setIsUserAuthenticated(true)
      getUserFromToken()
      return true;
    }
}

const resetUserInfo = () => {
  setUsername(null)
  setFirstName(null)
  setLastName(null)
  setMail(null)
}

  

  // async function fetchUserInfo() {
  //   fetch(`/api/users/byid/${userId}`).then((response) =>
  //     response.json().then((data) => {
  //       setUserInfo(data);
  //     }),
  //   );
  // }

  return (
    <AuthContext.Provider
      value={{
        username,
        firstName,
        lastName,
        mail,
        role,
        isUserAuthenticated,
        setFirstName,
        setLastName,
        setMail,
        setUsername,
        getUserFromToken,
        getUserAuthentication,
        logOut
      }}
    >
      {children}
    </AuthContext.Provider>
  );
}

// const AuthProvider = ({ children }) => {

  


//   const login = async (usernameAndPassword) => {
//       return new Promise((resolve, reject) => {
//           performLogin(usernameAndPassword).then(res => {
//               const jwtToken = res.headers["authorization"];
//               localStorage.setItem("access_token", jwtToken);

//               const decodedToken = jwtDecode(jwtToken);

//               setCustomer({
//                   username: decodedToken.sub,
//                   roles: decodedToken.scopes
//               })
//               resolve(res);
//           }).catch(err => {
//               reject(err);
//           })
//       })
//   }


//   return (
//       <AuthContext.Provider value={{
//           customer,
//           login,
//           logOut,
//           getUserAuthentication,
//           setCustomerFromToken
//       }}>
//           {children}
//       </AuthContext.Provider>
//   )
// }

// export const useAuth = () => useContext(AuthContext);

// export default AuthProvider;