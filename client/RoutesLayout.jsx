import React, { useEffect } from "react";
import { Routes, Route } from "react-router-dom";
import HomePage from "./Pages/HomePage";
import NavBar from "./Layout/Navbar";

export default function RoutesPage() {
  return (
    <Routes>
      
      <Route path="/" element={<NavBar />}>
        <Route index element={<HomePage />}/>
      </Route>
      <Route path="*" element={<h1>Page not found</h1>} />
    </Routes>
  );
}
