package com.fullee.yangquan.master.endpoint;

import com.fullee.yangquan.master.framework.common.bean.JSONResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class ApplicationEndpoint {

    @GetMapping({"/version","/index"})
    public JSONResult version(){
        return JSONResult.success();
    }

    /**
     * 用户注册
     * @return
     */
    @PostMapping("/join")
    public JSONResult join(){

        return null;
    }

    /**
     * 用户登录
     * @return
     */
    @PostMapping("/login")
    public JSONResult login(){




        return null;
    }

    /**
     * 退出登录
     * @return
     */
    @PostMapping("/logout")
    public JSONResult logout(){
        return null;
    }

}
