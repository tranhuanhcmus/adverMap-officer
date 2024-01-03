import {configureStore} from "@reduxjs/toolkit";
import {default as tokenReducer} from "./useToken.tsx";
import {default as currentPageReducer} from "./currentPage.tsx";
import {default as notificationReducer} from "./notification.tsx";


export default configureStore({
    reducer:{
        token: tokenReducer,
        currentPage: currentPageReducer,
        notification: notificationReducer,
    }
})