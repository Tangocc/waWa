package com.wave.dto;

import java.io.Serializable;

/**
 *
 */
public class ResponseDTO implements Serializable{

    public int code;
    public String message;
    public Object data;

    public ResponseDTO(int code , String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public ResponseDTO(Object data) {
        this.code = 200;
        this.message = "SUCCESS";
        this.data = data;

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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
