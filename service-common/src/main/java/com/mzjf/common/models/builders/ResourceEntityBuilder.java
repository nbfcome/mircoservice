/*
 * Copyright (c) 2014-2015 XXX, Inc. All Rights Reserved.
 */

package com.mzjf.common.models.builders;

import com.mzjf.common.models.ResponseEntity;

public class ResourceEntityBuilder<T> {
    private int code;

    private String message;

    private T item;

    public ResourceEntityBuilder() {
    }

    public ResourceEntityBuilder<T> code(int code) {
        this.code = code;
        return this;
    }

    public ResourceEntityBuilder<T> message(String message) {
        this.message = message;
        return this;
    }

    public ResourceEntityBuilder<T> item(T item) {
        this.item = item;
        return this;
    }

    public ResponseEntity<T> build() {
        ResponseEntity<T> result = new ResponseEntity<>();
        result.setCode(this.code);
        result.setMessage(this.message);
        result.setData(this.item);
        return result;
    }
}
