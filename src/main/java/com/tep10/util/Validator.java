package com.tep10.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * Created by UG34QP on 20-9-2017.
 */
public class Validator {
    public static <T> ResponseEntity<T> checkNotNull (T object) {
        if (object == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(object, HttpStatus.OK);
        }
    }
}
