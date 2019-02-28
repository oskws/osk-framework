package com.fullee.yangquan.master.framework.configure;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * https://www.cnblogs.com/paddix/p/8365558.html
 * https://yq.aliyun.com/articles/617307
 */
public class InterceptorConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {

    }


}
