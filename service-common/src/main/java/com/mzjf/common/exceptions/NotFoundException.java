/*
 * Copyright (c) 2014-2015 XXX, Inc. All Rights Reserved.
 */

package com.mzjf.common.exceptions;

public class NotFoundException extends ErrorCodeException {

    private static final long serialVersionUID = -6034516639136422421L;

    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotFoundException(int code) {
        super(code);

    }
}
