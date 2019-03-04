package com.fullee.yangquan.master.framework.configure;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ErrorHandler {
    /**
     * 捕捉 CustomRealm 抛出的异常
      */
//    @ExceptionHandler({AccountException.class,AuthorizationException.class})
//    public JSONResult handleShiroException(Exception ex) {
//        log.info("shiro exception",ex);
//        return JSONResult.fail(ex.getMessage());
//    }
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
