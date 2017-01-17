/*
 * Copyright (c) 2014-2015 XXX, Inc. All Rights Reserved.
 */

package com.mzjf.common.exceptions;

public class BadResponseException extends ErrorCodeException {

    private static final long serialVersionUID = 8122631096909985709L;

    public BadResponseException(String message) {
        super(message);
    }

    public BadResponseException(String message, Throwable cause) {
        super(message, cause);
    }

    public BadResponseException(int code) {
        super(code);
    }
}
