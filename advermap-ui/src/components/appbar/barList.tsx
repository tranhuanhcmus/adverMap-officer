import {DEFAULT, PAGE, ROLE} from "../constants.tsx";
import BarItem, {BarItemProp} from "./barItem.tsx";
import * as url from "url";
import {useSelector} from "react-redux";
import {JwtPayload} from "jwt-decode";
import List from "@mui/material/List";
import * as React from "react";
import LocationCityIcon from '@mui/icons-material/LocationCity';
import ApartmentIcon from '@mui/icons-material/Apartment';
import HouseSidingIcon from '@mui/icons-material/HouseSiding';
import BugReportIcon from '@mui/icons-material/BugReport';
import PlaceIcon from '@mui/icons-material/Place';
import ViewInArIcon from '@mui/icons-material/ViewInAr';
import SummarizeIcon from '@mui/icons-material/Summarize';


const nav = {
    district:   { page: PAGE.DISTRICT,icon: <ApartmentIcon sx={{fontSize:DEFAULT.ICON_SIZE}}/>},
    ward:   { page: PAGE.WARD,icon: <HouseSidingIcon sx={{fontSize:DEFAULT.ICON_SIZE}}/>},
    city:   {page: PAGE.CITY,icon: <LocationCityIcon sx={{fontSize:DEFAULT.ICON_SIZE}}/>},
    report:   { page: PAGE.REPORT,icon: <BugReportIcon sx={{fontSize:DEFAULT.ICON_SIZE}}/>},
    surface:   { page: PAGE.SURFACE,icon: <PlaceIcon sx={{fontSize:DEFAULT.ICON_SIZE}}/>},
    space:   { page: PAGE.SPACE,icon: <ViewInArIcon sx={{fontSize:DEFAULT.ICON_SIZE}}/>},
    surface_request:   { page: PAGE.SURFACE,icon: <SummarizeIcon sx={{fontSize:DEFAULT.ICON_SIZE}}/>},
}

const WARD_ADMIN_LIST = [
    nav.space,
    nav.surface,
    nav.report,
    nav.surface_request
]


const DISTRICT_ADMIN_LIST = [
    nav.space,
    nav.surface,
    nav.report,
    nav.surface_request
]


const ADMIN_LIST = [
    nav.space,
    nav.surface,
    nav.report,
    nav.surface_request,
    nav.city,
    nav.district,
    nav.ward
]

export default function BarList(){
    const {token} = useSelector(state => state.token);
    const role = token?.role;
    var list = [];

    if (role == ROLE.WARD_ADMIN) {
        list = WARD_ADMIN_LIST;
    } else if (role == ROLE.DISTRICT_ADMIN) {
        list = DISTRICT_ADMIN_LIST;
    } else if (role == ROLE.ADMIN) {
        list = ADMIN_LIST;
    }
    return (
        <List>
            {list.map((data, index) => (
                <BarItem key={index} prop={{page: data.page,icon: data.icon}}></BarItem>
            ))}
        </List>
    )
}