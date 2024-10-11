import React from 'react';
import ReactDOM from 'react-dom/client';
import "./assets/styles/xCommonx.css"
import reportWebVitals from './reportWebVitals';
import MainPage from "./pages/mainPage/MainPage";
import {createBrowserRouter, RouterProvider} from "react-router-dom";
// import ErrorPage from "./ErrorPage";
import "./index.css";

const router = createBrowserRouter([
    {
        path: "/",
        element: <MainPage/>,
        // errorElement: <ErrorPage/>
    },
    // {
    //     path: "/auth",
    //     element: <AuthPage/>
    // },
    // {
    //     path: "/diary",
    //     element: <DiaryPage/>
    // },
]);

ReactDOM.createRoot(document.getElementById('root')).render(
    <React.StrictMode>
        <RouterProvider router={router}/>
    </React.StrictMode>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
