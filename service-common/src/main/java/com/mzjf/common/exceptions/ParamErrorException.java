/*
 * Copyright (c) 2014-2015 XXX, Inc. All Rights Reserved.
 */

package com.mzjf.common.exceptions;

public class ParamErrorException extends ErrorCodeException {

    private static final long serialVersionUID = -6494806214529459826L;

    public ParamErrorException(String message) {
        super(message);
    }

    public ParamErrorException(String message, Throwable cause) {
        super(message, cause);
    }

    public ParamErrorException(int code) {
        super(code);
    }

}
