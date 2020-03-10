package com.example.user.core.exception;

import lombok.Data;

import java.io.Serializable;

@Data
public class ErrorCode implements Serializable {
    private static final long serialVersionUID = 1L;
    private String code;
    private String msg;

    public ErrorCode(String code, String msg) {
        this.msg = msg;
        this.code = code;
    }


}
