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
        wrapper = wrapper.likeRight(Objects.nonNull(query.getNickname()),User::getNickname, query.getNickname());

        Page<User> page = userService.page(new Page<>(query.getPage(), query.getSize()), wrapper);

        return JSONResult.success(page);
    }

    /**
     * 设置用户所在地区
     */

    /**
     * 用户列表
     */

    /**
     * 添加用户
     */

    /**
     * 删除用户
     */


}
