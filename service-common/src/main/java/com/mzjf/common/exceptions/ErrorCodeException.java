/*
 * Copyright (c) 2014-2015 XXX, Inc. All Rights Reserved.
 */

package com.mzjf.common.exceptions;

import java.util.HashMap;
import java.util.Map;

public class ErrorCodeException extends Exception {

    public static final int DEFAULT_FAILURE_CODE = -50000;
    public static final String DEFAULT_FAILURE_MESSAGE = "Failed to process the request. Detailed error message has been logged on server side.";

    public static final int AUTHENTICATION_FAILURE_CODE = 0;
    public static final String AUTHENTICATION_FAILURE_MESSAGE = "invalid token";

    public static final int TOKEN_USERID_NOT_MATCH_CODE = -1;
    public static final String TOKEN_USERID_NOT_MATCH_STRING = "verify userid failed";

    public static final int SUCCESS_CODE = 1;
    public static final String SUCCESS_MESSAGE = "success";

    public static final int INVALID_HTTP_METHOD_CODE = -1001;
    public static final String INVALID_HTTP_METHOD_MESSAGE = "Invalid http request method";

    public static final int MISSING_REQUIRED_PARAMETER_CODE = -1002;
    public static final String MISSING_REQUIRED_PARAMETER_MESSAGE = "Missing required parameter";

    public static final int INTERNAL_SERVER_ERROR_CODE = -1003;
    public static final String INTERNAL_SERVER_ERROR_MESSAGE = "Internal server error";

    public static final int INVALID_OPERATION_CODE = -1004;
    public static final String INVALID_OPERATION_MESSAGE = "Invalid operation";

    public static final int CREATE_AUTHORIZATION_FAILED_CODE = -4003;
    public static final String CREATE_AUTHORIZATION_FAILED_MESSAGE = "create user authorization failed";

    public static final int GET_THIRD_PARTY_FAILED_CODE = -4004;
    public static final String GET_THIRD_PARTY_FAILED_MESSAGE = "get third party failed";

    public static final Map<Integer, String> MAP = new HashMap<>();

    static {
        MAP.put(DEFAULT_FAILURE_CODE, DEFAULT_FAILURE_MESSAGE);
        MAP.put(AUTHENTICATION_FAILURE_CODE, AUTHENTICATION_FAILURE_MESSAGE);
        MAP.put(TOKEN_USERID_NOT_MATCH_CODE, TOKEN_USERID_NOT_MATCH_STRING);
        MAP.put(SUCCESS_CODE, SUCCESS_MESSAGE);
        MAP.put(INVALID_HTTP_METHOD_CODE, INVALID_HTTP_METHOD_MESSAGE);
        MAP.put(MISSING_REQUIRED_PARAMETER_CODE, MISSING_REQUIRED_PARAMETER_MESSAGE);
        MAP.put(INTERNAL_SERVER_ERROR_CODE, INTERNAL_SERVER_ERROR_MESSAGE);
        MAP.put(INVALID_OPERATION_CODE, INVALID_OPERATION_MESSAGE);
        MAP.put(CREATE_AUTHORIZATION_FAILED_CODE, CREATE_AUTHORIZATION_FAILED_MESSAGE);
        MAP.put(GET_THIRD_PARTY_FAILED_CODE, GET_THIRD_PARTY_FAILED_MESSAGE);
    }

    private static final long serialVersionUID = -4556515656361708799L;

    private int errorCode = DEFAULT_FAILURE_CODE;

    public ErrorCodeException() {
        super();
        setDefaultErrorCode();
    }

    public ErrorCodeException(int errorCode) {
        super();
        setErrorCode(errorCode);
    }

    public ErrorCodeException(String message) {
        super(message);
        setDefaultErrorCode();
    }

    public ErrorCodeException(String message, Throwable cause) {
        super(message, cause);
        setDefaultErrorCode();
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    /**
     * Specific exception types MAY override this to specify their own "default" error code.
     */
    protected void setDefaultErrorCode() {
    }

}
