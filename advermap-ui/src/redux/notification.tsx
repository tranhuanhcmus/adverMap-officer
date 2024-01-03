import {createSlice} from "@reduxjs/toolkit";

const notification = createSlice({
    name: 'notification',

    initialState: {
        notification: 17
    },
    reducers: {
        getNotificationCount: state => {
            return state.notification;
        },
        setNotificationCount: (state, action) =>  {
            state.notification = action.payload;
        }
    }
});

export const {getNotificationCount, setNotificationCount} = notification.actions;
export default notification.reducer;