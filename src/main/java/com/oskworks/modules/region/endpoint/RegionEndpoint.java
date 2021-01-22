package com.oskworks.modules.region.endpoint;


import cn.dev33.satoken.stp.StpUtil;
import com.oskworks.framework.common.bean.JSONResult;
import com.oskworks.framework.configure.ApplicationConfiguration;
import com.oskworks.modules.system.domain.User;
import com.oskworks.modules.system.entity.LoginEntity;
import com.oskworks.modules.system.service.IUserService;
import lombok.AllArgsConstructor;
import org.osgl.util.S;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author fullee
 * @since 2021-01-20
 */
@RestController
@RequestMapping("/region")
@AllArgsConstructor
public class RegionEndpoint {

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
    public JSONResult<?> login(@RequestBody LoginEntity loginEntity) {

        User user = userService.lambdaQuery()
                .eq(User::getLoginName, loginEntity.getLoginName())
                .one();

        if (Objects.isNull(user)) {
            return JSONResult.fail("用户登录失败");
        }

        if (S.neq(user.getUserPassword(), loginEntity.getPasswd())) {
            return JSONResult.fail("用户名或密码不正确");
        }
        StpUtil.setLoginId(user.getLoginName());
        return JSONResult.success(StpUtil.getTokenInfo());
    }


}
