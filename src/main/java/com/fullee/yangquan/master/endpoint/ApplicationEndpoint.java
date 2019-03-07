package com.fullee.yangquan.master.endpoint;

import com.fullee.yangquan.master.framework.common.bean.JSONResult;
import com.fullee.yangquan.master.system.model.SystemUser;
import com.fullee.yangquan.master.framework.serve.JWTKit;
import com.fullee.yangquan.master.system.service.ISystemUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Slf4j
@RestController
@RequestMapping
public class ApplicationEndpoint {

    @Autowired
    private ISystemUserService userService;

    @GetMapping({"/version","/index"})
    public JSONResult version() {
        return JSONResult.success();
    }

    /**
     * 用户注册
     * @return
     */
    @PostMapping("/join")
    public JSONResult join(SystemUser user){
        try {
            userService.userJoin(user);
        }catch (Exception e){
            log.error("用户注册失败：{}",user.toJSON(),e);
            return JSONResult.fail("用户注册失败");
        }

        return JSONResult.success();
    }

    /**
     * 用户登录
     *
     * @return
     */
    @PostMapping("/login")
    public JSONResult login(String loginName, String password, HttpServletResponse response) {

        SystemUser systemUser = new SystemUser(loginName, password);

        SystemUser user = userService.userLogin(systemUser);

        if (Objects.nonNull(user)){
            // TODO jwt 中加入过期时间和用户信息 授权信息
            Map<String,String> maps = new HashMap<>();
            maps.put(JWTKit.KEY.AUTHORIZATION.getValue(), user.getLoginName());
            String jwt = JWTKit.createJWT(maps);

            response.setHeader("Authorization",jwt);
            // TODO 将用户信息加入Cache

            return JSONResult.success(user);
        }else {
            return JSONResult.fail();
        }

    }

    @Autowired
    private Cache cache;

    @GetMapping("/cache")
    public JSONResult cache(String name) {
        return JSONResult.success(cache.get(name,SystemUser.class).toJSON());
    }

    /**
     * 退出登录
     * @return
     */
    @PostMapping("/logout")
    @CacheEvict(cacheNames = "LOGIN_CACHE",key = "#loginName",condition = "#result.code == 1")
    public JSONResult logout(String loginName){
        // TODO 主动清空 Cache
        System.out.println("清空缓存");
        return JSONResult.success();
    }

}
