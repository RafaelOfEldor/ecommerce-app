import React, { useContext } from "react";
import { Link, Routes, Route, Outlet, useNavigate } from "react-router-dom";
import { useAuth } from "../../context/AuthContext";
import "../css/components/paymentComponent.css";
import DollarEmoji from "../../images/dollar-emoji.png";

const capitalizeFirstLetter = (string) => {
  return string.charAt(0).toUpperCase() + string.slice(1).toLowerCase();
};

export default function PaymentComponent(props) {
  const { isUserAuthenticated, username, mail, firstName, lastName, role } = useAuth();
  const navigate = useNavigate();

  return (
    <div className="account-page-div">
      <div className="payment-details-page-div">
        <h1 style={{ marginBottom: "80px" }}>Your card</h1>
        <div className="credit-card">
          <img src={DollarEmoji} alt="Dollar Emoji" className="dollar-emoji-one" />
          <img src={DollarEmoji} alt="Dollar Emoji" className="dollar-emoji-two" />

          <div className="card-chip"></div>
          <div className="card-info">
            <div className="card-number">1234 5678 9876 5432</div>
            <div className="card-holder">
              <div className="label">Card Holder</div>
              <div className="name">
                {firstName?.charAt(0).toUpperCase() + firstName?.slice(1).toLowerCase() + " "}
                {lastName?.charAt(0).toUpperCase() + lastName?.slice(1).toLowerCase()}
              </div>
            </div>
            <div className="card-expiry">
              <div className="label">Expires</div>
              <div className="expiry-date">12/34</div>
            </div>
          </div>
          <div className="card-footer">
            <div className="unlimited-money">
              <i>$</i> Unlimited Money <i>$</i>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}
