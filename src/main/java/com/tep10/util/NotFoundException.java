package com.tep10.util;

/**
 * Created by UG34QP on 19-9-2017.
 */
public class NotFoundException extends ApiException {
    private int code;
    public NotFoundException (int code, String msg) {
        super(code, msg);
        this.code = code;
    }
}
