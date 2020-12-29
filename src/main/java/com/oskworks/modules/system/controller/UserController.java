package com.oskworks.modules.system.controller;


import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.stp.StpUtil;
import com.oskworks.framework.common.bean.JSONResult;
import com.oskworks.modules.system.entity.User;
import com.oskworks.modules.system.mapper.UserMapper;
import com.oskworks.modules.system.service.IUserService;
import lombok.AllArgsConstructor;
import org.osgl.util.S;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author osk-generator
 * @since 2020-08-27
 */
@RestController
@AllArgsConstructor
@RequestMapping("/system/user")
public class UserController {

    private UserMapper userMapper;

    private IUserService userService;

    /**
     * 用户登录
     * @return
     */
    @PutMapping("/login")
    public JSONResult<?> login(String loginName,String passwd) {

        User user = userService.lambdaQuery()
                .eq(User::getLoginName, loginName)
                .one();

        if (S.eq(user.getUserPassword(), passwd)) {
            StpUtil.setLoginId(user.getLoginName());
        }

        return JSONResult.success(StpUtil.getTokenInfo());
    }

    /**
     * 用户注册
     * @return
     */
    @PutMapping("/join")
    public JSONResult<?> join() {
        return null;
    }


    @SaCheckLogin
    @GetMapping("/user")
    public JSONResult<?> user() {
        User user = userMapper.selectById(1);
        return JSONResult.success(user);
    }

}
