package com.oskworks.framework.configure;

import com.oskworks.framework.common.bean.ErrorEnum;
import com.oskworks.framework.common.bean.JSONResult;
import com.oskworks.framework.exception.AuthenticationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

@Slf4j
@RestControllerAdvice
public class ErrorHandler {
    /**
     * 捕捉 CustomRealm 抛出的异常
     */
    @ExceptionHandler({Exception.class})
    public JSONResult handleShiroException(Exception ex) {

        log.error(ex.getMessage(), ex);

        if (ex instanceof NoHandlerFoundException) {
            return JSONResult.fail(ErrorEnum.NoHandlerFound);
        }

        if (ex instanceof AuthenticationException) {
            return JSONResult.fail(ErrorEnum.FAIL);
        }

        return JSONResult.fail(ex.getMessage());
    }
}
