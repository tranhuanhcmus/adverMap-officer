import {createSlice} from "@reduxjs/toolkit";
import {PAGE} from "../components/constants.tsx";

const currentPage = createSlice({
    name: 'currentPage',

    initialState: {
        currentPage: PAGE.HOME
    },
    reducers: {
        getCurrentPage: state => {
            return state.currentPage;
        },
        setCurrentPage: (state, action) =>  {
            state.currentPage = action.payload;
        }
    }
});

export const {getCurrentPage, setCurrentPage} = currentPage.actions;
export default currentPage.reducer;