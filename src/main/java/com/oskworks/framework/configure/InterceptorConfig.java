package com.oskworks.framework.configure;

import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.oskworks.framework.utils.JWTKit;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
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
@Getter
@Setter
@Slf4j
@Configuration
@ConfigurationProperties(prefix = "application")
public class InterceptorConfig implements WebMvcConfigurer {

    private String version;

    private List<String> excludeUrls;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new HandlerInterceptor() {
            @Override
            public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
                String jwt = request.getHeader("Authorization").replace("Bearer ", "");

                try {
                    DecodedJWT decodedJWT = JWTKit.verifierJWT(jwt);
                    Claim claim = decodedJWT.getClaim(JWTKit.KEY.AUTHORIZATION.getValue());
                    String loginName = claim.asString();

//                    if (userService.checkedUser(loginName)) {
//                        System.out.println("认证成功");
//                        return true;
//                    }

                } catch (Exception e) {
                    log.info("Token认证失败");
                    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                    return false;
                }


                return true;
            }
        }).addPathPatterns("/**").excludePathPatterns(excludeUrls);
    }

}
