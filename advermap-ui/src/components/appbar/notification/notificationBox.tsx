import * as React from 'react';

import IconButton from "@mui/material/IconButton";
import Badge from "@mui/material/Badge";
import NotificationsIcon from "@mui/icons-material/Notifications";
import {DEFAULT} from "../../constants.tsx";
import {useDispatch, useSelector} from "react-redux";
import {useNavigate} from "react-router-dom";
import NotificationList from "./notificationList.tsx";
import { useSpring, useSpringRef, animated } from '@react-spring/web';
import { useTransitionStateManager } from '@mui/base/useTransition';
import { Unstable_Popup as BasePopup } from '@mui/base/Unstable_Popup';

export default function NotificationBox() {
    const [anchor, setAnchor] = React.useState<null | HTMLElement>(null);

    const handleClick = (event: React.MouseEvent<HTMLElement>) => {
        setAnchor(anchor ? null : event.currentTarget);
    };

    const open = Boolean(anchor);



    const {notification} = useSelector(state => state.notification);
    const dispatch = useDispatch();
    const {currentPage} = useSelector(state => state.currentPage);
    const navigate = useNavigate();

    return (
        <>
            <IconButton
                size="large"
                aria-label={"show" + {notification} + "new notifications"}
                onClick={handleClick}
                color="inherit"
            >
                <Badge badgeContent={notification} color="error">
                    <NotificationsIcon sx={{fontSize: DEFAULT.ICON_SIZE}}/>
                </Badge>
            </IconButton>
            <BasePopup  open={open} anchor={anchor} placement="bottom-end" >
                <ReactSpringTransition>
                    <NotificationList/>
                </ReactSpringTransition>
            </BasePopup>
        </>
    )
}

function ReactSpringTransition({ children }: React.PropsWithChildren<{}>) {
    const { requestedEnter, onEntering, onEntered, onExiting, onExited } =
        useTransitionStateManager();

    const api = useSpringRef();
    const springs = useSpring({
        ref: api,
        from: { opacity: 0, transform: 'translateY(-8px) scale(0.95)' },
    });

    React.useEffect(() => {
        if (requestedEnter) {
            api.start({
                opacity: 1,
                transform: 'translateY(0) scale(1)',
                config: { tension: 250, friction: 10 },
                onStart: onEntering,
                onRest: onEntered,
            });
        } else {
            api.start({
                opacity: 0,
                transform: 'translateY(-8px) scale(0.95)',
                config: { tension: 170, friction: 26 },
                onStart: onExiting,
                onRest: onExited,
            });
        }
    }, [requestedEnter, api, onEntering, onEntered, onExiting, onExited]);

    return <animated.div style={springs}>{children}</animated.div>;
}