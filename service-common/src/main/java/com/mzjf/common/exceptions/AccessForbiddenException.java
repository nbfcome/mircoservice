/*
 * Copyright (c) 2014-2015 XXX, Inc. All Rights Reserved.
 */

package com.mzjf.common.exceptions;

public class AccessForbiddenException extends ErrorCodeException {

    private static final long serialVersionUID = 540962104000279600L;

    public AccessForbiddenException(String message) {
        super(message);
    }

    public AccessForbiddenException(String message, Throwable cause) {
        super(message, cause);
    }

    public AccessForbiddenException(int code) {
        super(code);
    }

    @Override
    protected void setDefaultErrorCode() {
        setErrorCode(ErrorCodeException.AUTHENTICATION_FAILURE_CODE);
    }
}
