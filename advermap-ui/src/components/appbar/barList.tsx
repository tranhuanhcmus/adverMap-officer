import {PAGE} from "../constants.tsx";
import BarItem, {BarItemProp} from "./barItem.tsx";
import * as url from "url";
import {useSelector} from "react-redux";
import {JwtPayload} from "jwt-decode";
import List from "@mui/material/List";
import * as React from "react";


const nav = {
    district:   {text: "Quản lý quận", url: PAGE.DISTRICT,icon: null},
    ward:   {text: "Quản lý phường", url: PAGE.WARD,icon: null},
    city:   {text: "Quản lý thành phố", url: PAGE.CITY,icon: null},
    report:   {text: "Quản lý báo cáo", url: PAGE.REPORT,icon: null},
    surface:   {text: "Quản lý các quảng cáo", url: PAGE.SURFACE,icon: null},
    space:   {text: "Quản lý điểm quảng cáo", url: PAGE.SPACE,icon: null},
    surface_request:   {text: "Quản lý các yêu cầu thay đổi quảng cáo", url: PAGE.SURFACE,icon: null},
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
    const role = token.role;
    var list = [];

    if (role == 'WARD_ADMIN') {
        list = WARD_ADMIN_LIST;
    }

    return (
        <List>
            {WARD_ADMIN_LIST.map((data, index) => (
                <BarItem prop={{text: data.text, url: data.url,icon: data.icon}}></BarItem>
            ))}
        </List>
    )
}