import {configureStore} from "@reduxjs/toolkit";
import {default as tokenReducer} from "./useToken.tsx";

export default configureStore({
    reducer:{token: tokenReducer}
})