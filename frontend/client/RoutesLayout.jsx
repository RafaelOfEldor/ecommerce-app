import React, { useEffect } from "react";
import { Routes, Route } from "react-router-dom";
import HomePage from "./Pages/HomePage";
import NavBar from "./Layout/Navbar";
import LoginPage from "./Pages/LoginPage";
import RegisterPage from "./Pages/RegisterPage";
import AboutPage from "./Pages/AboutPage";
import ProtectedRoute from "./Components/ProtectedRoute";
import ProductComponent from "./Components/ProductComponent";
import AccountPage from "./Pages/AccountPage";
import CartPage from "./Pages/CartPage";
import AccountProfileComponent from "./Pages/account-subpages/ProfileComponent";
import AccountAdressesComponent from "./Pages/account-subpages/AdressesComponent";
import AccountCancellationsComponent from "./Pages/account-subpages/CancellationsComponent";
import AccountPaymentComponent from "./Pages/account-subpages/PaymentComponent";
import AccountPurchasesComponent from "./Pages/account-subpages/PurchasesComponent";
import AccountPrivacyComponent from "./Pages/account-subpages/PrivacyComponent";
import ProductsPage from "./Pages/ProductsPage";

export default function RoutesPage() {
  return (
    <Routes>
      
      <Route path="/" element={<NavBar />}>
        <Route index element={<HomePage />}/>

        <Route path="/products" element={<ProductsPage />}/>
        <Route path="/products/product/:itemid" element={<ProductComponent />}/>

        <Route path="/login" element={<LoginPage />}/>
        <Route path="/register" element={<RegisterPage />}/>
        <Route path="/about" element={<AboutPage />}/>
        <Route path="/cart" element={<ProtectedRoute><CartPage /></ProtectedRoute>}/>
  
        <Route path="/account" element={<ProtectedRoute><AccountPage /></ProtectedRoute>}>
          <Route path="profile" element={<AccountProfileComponent />}/>
          <Route path="adress" element={<AccountAdressesComponent />}/>
          <Route path="cancellations" element={<AccountCancellationsComponent />}/>
          <Route path="paymentdetails" element={<AccountPaymentComponent />}/>
          <Route path="purchases" element={<AccountPurchasesComponent />}/>
          <Route path="privacy" element={<AccountPrivacyComponent />}/>
        </Route>

        <Route path="*" element={<h1>Page not found</h1>} />
      </Route>
    </Routes>
  );
}
