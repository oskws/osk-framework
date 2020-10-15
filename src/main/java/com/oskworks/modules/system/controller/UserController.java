package com.oskworks.modules.system.controller;


import com.oskworks.framework.common.bean.JSONResult;
import com.oskworks.modules.system.entity.User;
import com.oskworks.modules.system.mapper.UserMapper;
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
@RequestMapping("/system/user")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @PutMapping("/signin")
    public JSONResult<?> join() {
        return null;
    }

    @GetMapping("/user")
    public JSONResult<?> user() {
        User user = userMapper.selectById(1);
        return JSONResult.success(user);
    }

}
