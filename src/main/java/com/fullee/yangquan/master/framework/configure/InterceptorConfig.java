package com.fullee.yangquan.master.framework.configure;

import org.osgl.util.C;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * https://www.cnblogs.com/paddix/p/8365558.html
 * https://yq.aliyun.com/articles/617307
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Value("${application.version}")
    private String version;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new HandlerInterceptor() {
            @Override
            public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
                String authorization = request.getHeader("Authorization");
                System.out.println(authorization);

                System.out.println("执行了吗"+version);

//                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                return true;
            }
        }).addPathPatterns(authorizationURL());
    }

    private List<String> authorizationURL(){
        List<String> list = C.newList();
        list.add("/**");

        return list;
    }





}

