/*
 * Copyright (c) 2014-2015 XXX, Inc. All Rights Reserved.
 */

package com.mzjf.common.models.builders;

import com.mzjf.common.models.ResponseEntity;


public class ResponseEntityBuilder<T> {
    private int code;

    private String message;

    private T data;

    public ResponseEntityBuilder() {
    }

    public ResponseEntityBuilder<T> code(int code) {
        this.code = code;
        return this;
    }

    public ResponseEntityBuilder<T> message(String message) {
        this.message = message;
        return this;
    }

    public ResponseEntityBuilder<T> data(T data) {
        this.data = data;
        return this;
    }

    public ResponseEntity<T> build() {
        ResponseEntity<T> result = new ResponseEntity<>();
        result.setCode(this.code);
        result.setMessage(this.message);
        result.setData(this.data);
        return result;
    }
}
