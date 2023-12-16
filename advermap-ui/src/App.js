import { createBrowserRouter, Outlet, RouterProvider } from "react-router-dom";
import HomePage from "./Pages/HomePage";
import React from "react";

function App() {
  const Layout = () => {
    return (
      <div className="h-screen w-screen bg-black">
        <Outlet />
      </div>
    );
  };

  //Setting Router
  const route = createBrowserRouter([
    {
      path: "/",
      element: <Layout />,
      children: [{ path: "/Home", element: <HomePage /> }],
    },
  ]);

  return <RouterProvider router={route} />;
}

export default App;
