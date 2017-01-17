/*
 * Copyright (c) 2014-2015 XXX, Inc. All Rights Reserved.
 */

package com.mzjf.common.exceptions;

public class ConflictException extends ErrorCodeException {
    private static final long serialVersionUID = -3232608731643018669L;

    public ConflictException(String message) {
        super(message);
    }

    public ConflictException(String message, Throwable cause) {
        super(message, cause);
    }

    public ConflictException(int code) {
        super(code);

    }
}
