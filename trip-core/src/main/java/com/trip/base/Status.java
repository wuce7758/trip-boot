package com.trip.base;

public enum Status {

    SUCCESS(200, "请求成功"),
    FAIL(400,"请求失败"),
    SERVER_FAIL(500,"服务器异常");

    /**
     * 返回状态吗
     */
    private int code;

    /**
     * 返回状态信息
     */
    private String message;

    Status(int code, String message){
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
