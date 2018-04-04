package com.wave.utils;


public enum ResponseCode {

    NO_SUCH_USER(400, "No Such User"),
    SUCCESS(200,"Success"),
    FAIL(500,"Fail"),
    PASSWORD_ERROR(401,"Incorrect Password"),
    REGISTER_SUCCESS(200,"Register Success"),
    USER_ALREADY_REGISTERED(402,"The User is Already exist"),
    ILLEGAL_PARAMETER(403,"The Parameter is illegal!"),



    ;

    private int code;
    private String msg;


    ResponseCode(int code, String msg) {

        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
