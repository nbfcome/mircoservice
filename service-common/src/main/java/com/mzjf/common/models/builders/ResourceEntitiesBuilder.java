/*
 * Copyright (c) 2014-2015 XXX, Inc. All Rights Reserved.
 */

package com.mzjf.common.models.builders;

import java.util.List;

import com.mzjf.common.models.ResponseEntities;

public class ResourceEntitiesBuilder<T> {
    private int code;

    private String message;

    private List<T> items;

    public ResourceEntitiesBuilder() {
    }

    public ResourceEntitiesBuilder<T> code(int code) {
        this.code = code;
        return this;
    }

    public ResourceEntitiesBuilder<T> message(String message) {
        this.message = message;
        return this;
    }

    public ResourceEntitiesBuilder<T> items(List<T> items) {
        this.items = items;
        return this;
    }

    public ResponseEntities<T> build() {
        ResponseEntities<T> result = new ResponseEntities<>();
        result.setCode(this.code);
        result.setMessage(this.message);
        result.setData(this.items);
        return result;
    }
}
