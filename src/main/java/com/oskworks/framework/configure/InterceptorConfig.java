package com.oskworks.framework.configure;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * https://www.cnblogs.com/paddix/p/8365558.html
 * https://yq.aliyun.com/articles/617307
 */
@Getter
@Setter
@Slf4j
@Configuration
@AllArgsConstructor
public class InterceptorConfig implements WebMvcConfigurer {

    private final ApplicationConfiguration configuration;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(new SaLoginCheckInterceptor()).addPathPatterns("/**").excludePathPatterns(configuration.getExcludeUrls());
    }
}

