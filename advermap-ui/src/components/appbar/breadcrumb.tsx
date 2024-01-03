import * as React from 'react';
import Breadcrumbs from '@mui/material/Breadcrumbs';
import Link from '@mui/material/Link';
import {useDispatch, useSelector} from "react-redux";
import {PAGE} from "../constants.tsx";

function handleClick(event: React.MouseEvent<HTMLDivElement, MouseEvent>) {
    event.preventDefault();
    console.log(event);
    console.info('You clicked a breadcrumb.');
}

export default function ActiveLastBreadcrumb() {
    const dispatch = useDispatch();
    const {currentPage} = useSelector(state => state.currentPage);

    return (
        <div role="presentation">
            <Breadcrumbs aria-label="breadcrumb" sx={{padding: 5}} variant="h4">
                <Link underline="hover" color="inherit" href={PAGE.HOME.path} >
                    Menu
                </Link>
                <Link
                    underline="hover"
                    color="text.primary"
                    href={currentPage.path}
                    aria-current="page"
                >
                    {currentPage.name}
                </Link>

            </Breadcrumbs>
        </div>
    );
}