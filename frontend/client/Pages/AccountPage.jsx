import React from "react";
import { Outlet, useNavigate, NavLink, useLocation } from "react-router-dom";
import {useAuth} from "../context/AuthContext"
import "./css/pages/accountPage.css"
const apiUrl = window.__ENV__?.BACKEND_API_BASE_URL;

export default function AccountPage(props) {


  const { isUserAuthenticated, username, mail, firstName, lastName, role, logOut  } = useAuth()
  const navigate = useNavigate();
  const location = useLocation();
  const {pathname, hash, search} = location
  const pathText = pathname.split("/")

  function handleLogout() {
    logOut()
    navigate("/")
  }
  return (
    <div className="account-page-div">
      <div className="account-page-sidelayout">
        <div className="account-page-sidelayout routes">
        {pathText[1] && 
          <NavLink
          to={"/" + pathText[1] + "/" + "profile"}
          className={
          !pathText[2]  ? "account-sidelayout-routes-link-active" : "account-sidelayout-routes-link"
          }
          >
          {pathText[1]}
          </NavLink>
        }
        {pathText[2] && 
          <NavLink
          style={{marginLeft: "3px"}}
          className={
            !pathText[3] ? "account-sidelayout-routes-link-active" : "account-sidelayout-routes-link"
          }
          to={"/" + pathText[1] + "/" + pathText[2]}
          >
          / {pathText[2]}
          </NavLink>
        }
        {pathText[3] && 
          <NavLink
          style={{marginLeft: "2px"}}
          className={
            isActive ? "account-sidelayout-routes-link-active" : "account-sidelayout-routes-link"
          }
          to={pathText[3]}
          >
          {pathText[3]}
          </NavLink>
        }   
        </div>
        <div>
          <div className="account-page-sidelayout personal">
            <h2>Personal</h2>
            <div className="account-page-sidelayout personal links">
              <NavLink
              to="profile"
              className={({isActive}) => 
              isActive ? "account-sidelayout-link-active profile" : "account-sidelayout-link profile"
              }
              >
              <h4>My Profile</h4>
              </NavLink>
              <NavLink
              to="adress"
              className={({isActive}) => 
              isActive ? "account-sidelayout-link-active adress" : "account-sidelayout-link adress"
              }
              >
              <h4>My Adresses</h4>
              </NavLink>
              {/* <NavLink
              to="privacy"
              className={({isActive}) => 
              isActive ? "account-sidelayout-link-active privacy" : "account-sidelayout-link privacy"
              }
              >
              <h4>My Privacy</h4>
              </NavLink> */}
            </div>
          </div>
          <div className="account-page-sidelayout billing">
            <h2>Billing</h2>
            <div className="account-page-sidelayout billing links">
            <NavLink
              to="paymentdetails"
              className={({isActive}) => 
            isActive ? "account-sidelayout-link-active payment" : "account-sidelayout-link paymet"
              }
              >
              <h4>My Payment Details</h4>
              </NavLink>
              <NavLink
              to="purchases"
              className={({isActive}) => 
            isActive ? "account-sidelayout-link-active purchases" : "account-sidelayout-link purchases"
          }
              >
              <h4>My Purchases</h4>
              </NavLink>
              {/* <NavLink
              to="cancellations"
              className={({isActive}) => 
            isActive ? "account-sidelayout-link-active cancellations" : "account-sidelayout-link cancellations"
          }
              >
              <h4>My Cancellations</h4>
              </NavLink> */}
            </div>
          </div>
        </div>
        <div>
          <button 
          className="account-sidelayout-logout-button" 
          onClick={handleLogout}>Logout</button>
        </div>
      </div>
      {
        !pathText[2] 
        ?
        <div>
          Yooo
        </div>
        :
        <Outlet />
      }
  </div>
  )
}
