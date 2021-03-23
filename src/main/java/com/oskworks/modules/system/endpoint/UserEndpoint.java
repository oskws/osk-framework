package com.oskworks.modules.system.endpoint;


import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.oskworks.framework.common.bean.JSONResult;
import com.oskworks.modules.system.domain.User;
import com.oskworks.modules.system.dto.UserListQuery;
import com.oskworks.modules.system.service.IUserService;
import lombok.AllArgsConstructor;
import org.osgl.util.N;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    @GetMapping
    public JSONResult<?> list(@RequestBody UserListQuery query) {


        if (N.eq(query.getType(), UserListQuery.Type.ALL)) {
            Wrappers.lambdaQuery(User.class).likeRight(User::getRegionPath, query.getRegionPath());
        } else {

        }


//        if (S.isEmpty(query.getRegionPath())) {
//            return JSONResult.success();
//        }

        userService.lambdaQuery();

        return null;
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
