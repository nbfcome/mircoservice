/*
 * Copyright (c) 2014-2015 XXX, Inc. All Rights Reserved.
 */

package com.mzjf.common.exceptions;

public class AuthenticationFailureException extends ErrorCodeException {

    private static final long serialVersionUID = -174616242638950370L;

    public AuthenticationFailureException(String message) {
        super(message);
    }

    public AuthenticationFailureException(String message, Throwable cause) {
        super(message, cause);
    }

    public AuthenticationFailureException(int code) {
        super(code);
    }

    @Override
    protected void setDefaultErrorCode() {
        setErrorCode(ErrorCodeException.AUTHENTICATION_FAILURE_CODE);
    }
}
