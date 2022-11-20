package org.subit.subcas.handler;

import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.subit.subcas.dto.Result;
import org.subit.subcas.dto.ReturnCode;
import org.subit.subcas.exception.SubcasBaseException;

import java.nio.file.AccessDeniedException;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public Result baseException(Exception e) {
        return Result.error(e);
    }

    @ExceptionHandler(AccessDeniedException.class)
    public Result accessDenied() {
        return Result.code(ReturnCode.NoPrivileges);
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public Result requestParamsNotMatch() {
        return Result.code(ReturnCode.InvalidArgument);
    }

    @ExceptionHandler(SubcasBaseException.class)
    public Result subcasBaseException(SubcasBaseException e) {
        return Result.failed(e);
    }
}
