import {
  BrowserRouter,
  createBrowserRouter, Navigate,
  Outlet,
  redirect,
  Router,
  RouterProvider,
  Routes,
  useNavigate
} from "react-router-dom";
import HomePage from "./pages/HomePage.jsx";
import React, {useEffect, useState} from "react";
import SignIn from "./components/login/signin.tsx";
import {PAGE} from "./components/constants.tsx";
import MiniDrawer from "./components/appbar/toolBar.tsx";
import {useDispatch, useSelector} from "react-redux";

function App() {
  const Layout = () => {
    const {token} = useSelector(state => state.token);

    const navigate = useNavigate();
    // Check if the user is authenticated

    useEffect(() => {
      if (!token) {
        // If not authenticated, redirect to the login page
        navigate(PAGE.LOGIN.path, {replace: true})
      }
    }, []);



    return (
      <div className="h-screen w-screen bg-white">
        <MiniDrawer />
      </div>
    );
  };

  //Setting Router
  const route = createBrowserRouter([
    {
      path: PAGE.LOGIN.path,
      element: <SignIn />
    },
    {
      path: "/",
      element: <Layout />,
      children: [
          { path: PAGE.HOME.path, element: <HomePage /> },
      ],
    },
  ]);

  return (
        <RouterProvider router={route}/>
  )

}

export default App;
