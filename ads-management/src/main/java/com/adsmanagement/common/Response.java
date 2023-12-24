package com.adsmanagement.common;

public class Response<T> {

    private String message;
    private T data;

    public Response( String message, T data) {
        this.message = message;
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }
}