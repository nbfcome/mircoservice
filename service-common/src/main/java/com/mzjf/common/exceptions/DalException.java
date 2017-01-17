/*
 * Copyright (c) 2014-2015 XXX, Inc. All Rights Reserved.
 */

package com.mzjf.common.exceptions;

import java.io.PrintStream;
import java.io.PrintWriter;

public class DalException extends ErrorCodeException {

    private static final long serialVersionUID = -7595780942996218596L;

    /**
     * the source error, use this to print the origin stack trace
     */
    private Throwable sourceException;

    public DalException() {
        super();
    }

    public DalException(String message) {
        super(message);
    }

    public DalException(Throwable soucrException) {
        super();
        this.sourceException = soucrException;
    }

    public DalException(String message, Throwable soucrException) {
        super(message);
        this.sourceException = soucrException;
    }

    @Override
    public String getMessage() {
        if (this.sourceException != null) {
            String msg = super.getMessage() + ", " + this.sourceException.getMessage();
            return msg;
        }
        return super.getMessage();
    }

    public Throwable getSourceException() {
        return this.sourceException;
    }

    public void setSourceException(Throwable sourceException) {
        this.sourceException = sourceException;
    }

    @Override
    public void printStackTrace() {
        super.printStackTrace();
        if (null != this.sourceException) {
            this.sourceException.printStackTrace();
        }
    }

    @Override
    public void printStackTrace(PrintStream s) {
        super.printStackTrace(s);
        if (null != this.sourceException) {
            this.sourceException.printStackTrace(s);
        }
    }

    @Override
    public void printStackTrace(PrintWriter s) {
        super.printStackTrace(s);
        if (null != this.sourceException) {
            this.sourceException.printStackTrace(s);
        }
    }

    @Override
    public synchronized Throwable fillInStackTrace() {

        if (null != this.sourceException) {
            return this.sourceException.fillInStackTrace();
        }
        return super.fillInStackTrace();

    }

}
