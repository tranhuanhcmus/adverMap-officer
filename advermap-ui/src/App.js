import {BrowserRouter, createBrowserRouter, Outlet, redirect, Router, RouterProvider, Routes} from "react-router-dom";
import HomePage from "./Pages/HomePage";
import React, {useState} from "react";
import SignIn from "./components/login/signin.tsx";
import useToken from "./useToken";
import {PAGE} from "./components/constants.tsx";
import AppBar from "./components/appbar/appBar.tsx";

function App() {
  const { token, setToken } = useToken();

  const Layout = () => {
    return (
      <div className="h-screen w-screen bg-white">
        <AppBar></AppBar>
        <Outlet />
      </div>
    );
  };

  //Setting Router
  const route = createBrowserRouter([
    {
      path: PAGE.LOGIN,
      element: <SignIn  setToken={setToken}/>
    },
    {
      path: "/",
      element: <Layout />,
      children: [
          { path: PAGE.HOME, element: <HomePage /> },
      ],
    },
  ]);

  return (
      <RouterProvider router={route} />
  )

}

export default App;
