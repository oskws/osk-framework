package com.fullee.yangquan.master.framework.configure;

import com.fullee.yangquan.master.framework.common.bean.JSONResult;
import com.fullee.yangquan.master.framework.exception.AuthenticationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ErrorHandler {
    /**
     * 捕捉 CustomRealm 抛出的异常
      */
    @ExceptionHandler({AuthenticationException.class})
    public JSONResult handleShiroException(Exception ex) {
        log.info(ex.getMessage(),ex);
        return JSONResult.fail(ex.getMessage());
    }
//
//    @ExceptionHandler({AuthenticationException.class})
//    public JSONResult authenticationException() {
//        return JSONResult.fail(2,"token认证失败");
//    }

//    @ExceptionHandler(Exception.class)
//    public JSONResult ex() {
//        Thread.currentThread().getStackTrace();
//        return JSONResult.fail("中午");
//    }
}
