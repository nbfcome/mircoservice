/*
 * Copyright (c) 2014-2015 XXX, Inc. All Rights Reserved.
 */

package com.mzjf.common.exceptions;

public class MultiLoginFailureException extends ErrorCodeException {

    private static final long serialVersionUID = -174616242638950370L;

    private Object data;

    public MultiLoginFailureException(String message) {
        super(message);
    }

    public MultiLoginFailureException(String message, Throwable cause) {
        super(message, cause);
    }

    public MultiLoginFailureException(int code) {
        super(code);
    }

    @Override
    protected void setDefaultErrorCode() {
        setErrorCode(ErrorCodeException.TOKEN_USERID_NOT_MATCH_CODE);
    }

    public Object getData() {
        return this.data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}
