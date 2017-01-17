/*
 * Copyright (c) 2014-2015 XXX, Inc. All Rights Reserved.
 */

package com.mzjf.common.exceptions.handler;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.MediaType;

import org.apache.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.google.common.collect.ImmutableList;
import com.mzjf.common.exceptions.AccessForbiddenException;
import com.mzjf.common.exceptions.AuthenticationFailureException;
import com.mzjf.common.exceptions.BadRequestException;
import com.mzjf.common.exceptions.ConflictException;
import com.mzjf.common.exceptions.DalException;
import com.mzjf.common.exceptions.ErrorCodeException;
import com.mzjf.common.exceptions.MultiLoginFailureException;
import com.mzjf.common.exceptions.NotFoundException;
import com.mzjf.common.exceptions.ParamErrorException;
import com.mzjf.common.exceptions.UnprocessableEntityException;
import com.mzjf.common.models.ResponseEntity;
import com.mzjf.common.models.builders.ResponseEntityBuilder;
import com.mzjf.common.utils.JsonUtils;
import com.netflix.hystrix.exception.HystrixRuntimeException;

@Component
public class ExceptionHandler implements HandlerExceptionResolver {

    private static Logger logger = LoggerFactory.getLogger(ExceptionHandler.class);

    private static final Map<Class<?>, Integer> map = new HashMap<>();
    private static final ImmutableList<?> omittedExceptions = ImmutableList
            .of(NotFoundException.class, ConflictException.class);

    static {
        map.put(AccessForbiddenException.class, HttpStatus.SC_UNAUTHORIZED);
        map.put(AuthenticationFailureException.class, HttpStatus.SC_UNAUTHORIZED);
        map.put(BadRequestException.class, HttpStatus.SC_BAD_REQUEST);
        map.put(DalException.class, HttpStatus.SC_INTERNAL_SERVER_ERROR);
        map.put(NotFoundException.class, HttpStatus.SC_NOT_FOUND);
        map.put(ParamErrorException.class, HttpStatus.SC_BAD_REQUEST);
        map.put(UnprocessableEntityException.class, HttpStatus.SC_UNPROCESSABLE_ENTITY);
        map.put(MultiLoginFailureException.class, HttpStatus.SC_OK);
        map.put(ConflictException.class, HttpStatus.SC_CONFLICT);
    }

    public static Throwable setResponse(HttpServletRequest request, HttpServletResponse response,
            Object obj,
            Exception ex) {
        Throwable t = ex;
        if (ex instanceof HystrixRuntimeException &&
                ex.getCause() != null) {
            t = ex.getCause();
        }

        Integer status = map.get(t.getClass());
        if (status == null) {
            status = HttpStatus.SC_INTERNAL_SERVER_ERROR;
        }

        if (shouldLogException(ex)) {
            // only log those ones that are real failures
            logger.error("request {}, response {}, obj {}", request, response, obj, t);
            logger.error("status {}", status, t);
        }

        response.setStatus(status);
        response.setContentType(MediaType.APPLICATION_JSON);
        return t;
    }

    public static void addExceptionToResponseBody(HttpServletResponse response,
            ErrorCodeException ex,
            Map<String, String> data) {
        try {
            ResponseEntity<Object> entity = new ResponseEntityBuilder<Object>()
                    .code(ex.getErrorCode())
                    .message(ErrorCodeException.MAP.get(ex.getErrorCode()))
                    .data(data)
                    .build();
            if (shouldLogException(ex)) {
                logger.error("Exception {}", entity, ex);
            }
            response.getWriter().print(JsonUtils.serialize(entity));
        } catch (IOException e) {
            logger.error("failed to write response JSON", e);
            throw new IllegalStateException(e);
        }
    }

    public static void addExceptionToResponse(HttpServletResponse response, ErrorCodeException ex) {
        addExceptionToResponseBody(response, ex, null);
    }

    private static boolean shouldLogException(Exception ex) {
        // only log exceptions that we don't expect
        boolean ret = !omittedExceptions.contains(ex.getClass());
        logger.error("{} exception thrown, message = {}", ret ? "unexpected" : "expected",
                ex.getMessage());
        return ret;
    }

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response,
            Object obj, Exception ex) {
        Throwable t = setResponse(request, response, obj, ex);
        addExceptionToResponse(response, (ErrorCodeException) t);
        return new ModelAndView();
    }

}