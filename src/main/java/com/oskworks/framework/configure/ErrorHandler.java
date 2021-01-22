package com.oskworks.framework.configure;

import cn.dev33.satoken.exception.NotLoginException;
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

        // 404
        if (ex instanceof NoHandlerFoundException) {
            return JSONResult.fail(ErrorEnum.NO_HANDLER_FOUND);
        }

        // 401
        if (ex instanceof NotLoginException) {
            return JSONResult.fail(ErrorEnum.NOT_LOGIN);
        }

        log.error(ex.getMessage(), ex);

        return JSONResult.fail(ex.getMessage());
    }
}
