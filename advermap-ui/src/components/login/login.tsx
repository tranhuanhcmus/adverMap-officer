import { Box, Button, TextField, Typography } from '@mui/material';
import './style.css';
import {useEffect, useState} from 'react';
import { AuthService } from '../../services/auth/authService.tsx';
import { AxiosError } from 'axios';
import {BrowserRouter, Navigate, redirect} from "react-router-dom";
import {PAGE} from "../constants.tsx";
import { useNavigate } from "react-router-dom";

export type AuthFieldForm = {
    username: string;
    password: string;
};

const initialFields: AuthFieldForm = {
    username: '',
    password: '',
};

const Login = ({setToken} ) => {
    const navigate = useNavigate();

    const [fields, setFields] = useState(initialFields)
    const [message,setMessage]=useState<string>("")
    const [loginSuccess, setStatus] = useState(false)
    const handleSubmit = async (e: React.FormEvent) => {
        e.preventDefault(); // Prevent default form submission behavior

        try {
            setMessage("Pending")
            const res = await AuthService.login(fields);
            if (res.status == 200) {
                setMessage("Login success ")
                console.log("Token:" + res.data)
                setToken(res.data)
                navigate(PAGE.HOME)
                setStatus(true)
            } else {
                setMessage("Error" + res.message)

            }

        } catch (error) {
            if (error instanceof AxiosError) {
                console.log(error);

                setMessage(error.code as string)
            }
        }
        finally{
            setFields(initialFields)
        }
    };

    const handleFieldChange = (e: React.ChangeEvent<HTMLInputElement>) => {
        const { name, value } = e.target;
        setFields({
            ...fields,
            [name]: value,
        });
    };

    return (
        <Box component="form" id="AuthForm" onSubmit={handleSubmit}>
            <div className="container">
                <TextField
                    required
                    name="username"
                    label="username"
                    fullWidth
                    value={fields.username}
                    onChange={handleFieldChange}
                />
                <TextField
                    required
                    name="password"
                    label="Password"
                    fullWidth
                    value={fields.password}
                    onChange={handleFieldChange}
                />
                <Typography>
                    {message}
                </Typography>
                <Button type="submit" variant="contained">
                    LOGIN
                </Button>
            </div>
        </Box>



    );

};

export default Login;
