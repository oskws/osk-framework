package com.oskworks.framework.configure;

import com.oskworks.framework.common.bean.ErrorEnum;
import com.oskworks.framework.common.bean.JSONResult;
import com.oskworks.framework.exception.AuthenticationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

@Slf4j
@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler({Exception.class})
    public JSONResult<?> handleShiroException(Exception ex) {

        log.error(ex.getMessage(), ex);
        // 404
        if (ex instanceof NoHandlerFoundException) {
            return JSONResult.fail(ErrorEnum.NoHandlerFound);
        }

        if (ex instanceof AuthenticationException) {
            return JSONResult.fail(ErrorEnum.FAIL);
        }

        return JSONResult.fail(ex.getMessage());
    }
}
