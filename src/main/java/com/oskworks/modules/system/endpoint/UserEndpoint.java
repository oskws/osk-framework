package com.oskworks.modules.system.endpoint;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.oskworks.framework.common.bean.JSONResult;
import com.oskworks.modules.system.domain.User;
import com.oskworks.modules.system.dto.UserListQuery;
import com.oskworks.modules.system.service.IUserService;
import lombok.AllArgsConstructor;
import org.osgl.util.N;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author osk-generator
 * @since 2020-08-27
 */
@RestController
@AllArgsConstructor
@RequestMapping("/system/user")
public class UserEndpoint {

    private final IUserService userService;

    /**
     * 显示用户列表
     */
    @PostMapping("/list")
    public JSONResult<?> list(@RequestBody UserListQuery query) {

        LambdaQueryWrapper<User> wrapper = Wrappers.lambdaQuery(User.class);
        if (N.eq(query.getType(), UserListQuery.Type.ALL)) {
            wrapper = wrapper.likeRight(User::getRegionPath, query.getRegionPath());
        } else {
            wrapper = Wrappers.lambdaQuery(User.class)
                    .eq(User::getRegionPath, query.getRegionPath());
        }
        wrapper = wrapper.likeRight(Objects.nonNull(query.getNickname()), User::getNickname, query.getNickname())
        .likeRight(Objects.nonNull(query.getLoginName()),User::getLoginName,query.getLoginName());

        Page<User> page = userService.page(new Page<>(query.getCurrent(), query.getPageSize()), wrapper);

        return JSONResult.success(page);
    }

    /**
     * 添加用户
     */
    @PostMapping
    public JSONResult<?> add(@RequestBody User user) {
        if (Objects.nonNull(userService.lambdaQuery().eq(User::getLoginName, user.getLoginName()).one())) {
            return JSONResult.fail("用户账号已存在");
        }
        userService.save(user);
        return JSONResult.success();
    }

    /**
     * 重置密码
     */
    @PutMapping("/reset/passwd/{id}")
    public JSONResult<?> resetPasswd(@PathVariable Long id) {
        userService.lambdaUpdate().eq(User::getId, id).set(User::getUserPassword, "123456").update();
        return JSONResult.success();
    }

    /**
     * 编辑用户
     */
    @PutMapping("/{id}")
    public JSONResult<?> editUser(@PathVariable Long id, @RequestBody User user) {
        user.setId(id);
        userService.updateById(user);
        return JSONResult.success();
    }
}
