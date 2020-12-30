package com.oskworks.modules.system.controller;


import cn.dev33.satoken.stp.StpUtil;
import com.oskworks.framework.common.bean.JSONResult;
import com.oskworks.framework.configure.ApplicationConfiguration;
import com.oskworks.modules.system.entity.User;
import com.oskworks.modules.system.service.IUserService;
import lombok.AllArgsConstructor;
import org.osgl.util.S;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author osk-generator
 * @since 2020-08-27
 */
@RestController
@RequestMapping
@AllArgsConstructor
public class SystemEndpoints {

    private final ApplicationConfiguration configuration;

    private final IUserService userService;

    @GetMapping("/version")
    public JSONResult<String> version() {
        return JSONResult.success(configuration.getVersion());
    }

    /**
     * 用户注册
     * @return
     */
    @PutMapping("/join")
    public JSONResult<?> join() {
        return null;
    }

    /**
     * 用户登录
     * @return
     */
    @PutMapping("/login")
    public JSONResult<?> login(String loginName,String passwd) {

        User user = userService.lambdaQuery()
                .eq(User::getLoginName, loginName)
                .one();

        if (Objects.isNull(user)) {

        }

        if (S.eq(user.getUserPassword(), passwd)) {
            StpUtil.setLoginId(user.getLoginName());
        }
        return JSONResult.success(StpUtil.getTokenInfo());
    }


}
