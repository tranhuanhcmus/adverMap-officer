import {createBrowserRouter, Outlet, redirect, RouterProvider} from "react-router-dom";
import HomePage from "./Pages/HomePage";
import React, {useState} from "react";
import Login from "./components/login/login.tsx";
import useToken from "./useToken";
import {PAGE} from "./components/constants.tsx";

function App() {
  const { token, setToken } = useToken();

  if(!token) {
//    redirect("/login")
    return <Login setToken={setToken} />
  }

  const Layout = () => {
    return (
      <div className="h-screen w-screen bg-white">
        <Outlet />
      </div>
    );
  };





  //Setting Router
  const route = createBrowserRouter([
    {
      path: PAGE.LOGIN,
      element: <Login  setToken={setToken}/>
    },
    {
      path: "/",
      element: <Layout />,
      children: [
          { path: PAGE.HOME, element: <HomePage /> },
      ],
    },
  ]);

  return <RouterProvider router={route} />;
}

export default App;
