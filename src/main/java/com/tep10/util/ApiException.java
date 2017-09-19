package com.tep10.util;

/**
 * Created by UG34QP on 19-9-2017.
 */
public class ApiException extends Exception{
    private int code;
    public ApiException (int code, String msg) {
        super(msg);
        this.code = code;
    }
}
