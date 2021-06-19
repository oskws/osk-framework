package com.oskworks.framework.configure;

import cn.dev33.satoken.annotation.SaCheckPermission;
import cn.dev33.satoken.annotation.SaMode;
import cn.dev33.satoken.interceptor.SaAnnotationInterceptor;
import cn.dev33.satoken.stp.StpUtil;
import org.springframework.web.method.HandlerMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 注解式鉴权 - 拦截器
 *
 * @author kong
 */
public class SaLoginCheckInterceptor extends SaAnnotationInterceptor {

    /**
     * 创建，并指定一个默认的 StpLogic
     */
    public SaLoginCheckInterceptor() {
        super();
    }

    /**
     * 每次请求之前触发
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        // 获取处理method
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod method = (HandlerMethod) handler;

        // 验证登录
        StpUtil.checkLogin();

        // 获取权限注解
        SaCheckPermission scp = method.getMethodAnnotation(SaCheckPermission.class);
        if (scp == null) {
            scp = method.getBeanType().getAnnotation(SaCheckPermission.class);
        }
        if (scp == null) {
            return true;
        }

        // 开始验证权限
        if (SaMode.AND == scp.mode()) {
            StpUtil.checkPermissionAnd(scp.value());        // 必须全部都有
        } else {
            StpUtil.checkPermissionOr(scp.value());        // 有一个就行了
        }

        return true;
    }
}
