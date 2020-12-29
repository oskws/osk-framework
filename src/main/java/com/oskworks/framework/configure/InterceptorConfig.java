package com.oskworks.framework.configure;

import cn.dev33.satoken.interceptor.SaCheckInterceptor;
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

        registry.addInterceptor(new SaCheckInterceptor()).addPathPatterns("/**");

//        registry.addInterceptor(new HandlerInterceptor() {
//            @Override
//            public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//                String jwt = request.getHeader("Authorization").replace("Bearer ", "");
//
//                try {
//                    DecodedJWT decodedJWT = JWTKit.verifierJWT(jwt);
//                    Claim claim = decodedJWT.getClaim(JWTKit.KEY.AUTHORIZATION.getValue());
//                    String loginName = claim.asString();
//
////                    if (userService.checkedUser(loginName)) {
////                        System.out.println("认证成功");
////                        return true;
////                    }
//
//                } catch (Exception e) {
//                    log.info("Token认证失败");
//                    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//                    return false;
//                }
//
//
//                return true;
//            }
//        }).addPathPatterns("/**").excludePathPatterns(excludeUrls);
    }

}

