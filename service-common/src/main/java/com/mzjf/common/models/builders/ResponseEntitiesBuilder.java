/*
 * Copyright (c) 2014-2015 XXX, Inc. All Rights Reserved.
 */

package com.mzjf.common.models.builders;

import java.util.List;

import com.mzjf.common.models.ResponseEntities;

public class ResponseEntitiesBuilder<T> {
    private int code;

    private String message;

    private List<T> data;

    public ResponseEntitiesBuilder() {
    }

    public ResponseEntitiesBuilder<T> code(int code) {
        this.code = code;
        return this;
    }

    public ResponseEntitiesBuilder<T> message(String message) {
        this.message = message;
        return this;
    }

    public ResponseEntitiesBuilder<T> data(List<T> data) {
        this.data = data;
        return this;
    }

    public ResponseEntities<T> build() {
        ResponseEntities<T> result = new ResponseEntities<>();
        result.setCode(this.code);
        result.setMessage(this.message);
        result.setData(this.data);
        return result;
    }
}
