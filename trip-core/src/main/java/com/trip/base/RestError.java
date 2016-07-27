package com.trip.base;

public class RestError {

    private int code;
    private String message;

    private RestError(Status status) {
        this.code = status.getCode();
        this.message = status.getMessage();
    }

    private RestError(int code, String message) {
        this.code = code;
        this.message = message;
    }

    private RestError(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static RestError me(Status status){
        return new RestError(status);
    }

    public static RestError me(int code, String message){
        return new RestError(code, message);
    }

    public static RestError me(String message){
        return new RestError(500, message);
    }

}
