package com.oskworks.modules.system.endpoint;


import com.oskworks.framework.common.bean.JSONResult;
import com.oskworks.modules.system.domain.User;
import com.oskworks.modules.system.service.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
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
public class UserEndpoint {

    private final IUserService userService;

    @GetMapping
    public JSONResult<?> user() {
        User user = userService.getById(1);
        return JSONResult.success(user);
    }

}
