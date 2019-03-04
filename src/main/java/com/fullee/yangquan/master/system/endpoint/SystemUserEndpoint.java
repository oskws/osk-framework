package com.fullee.yangquan.master.system.endpoint;

import com.fullee.yangquan.master.framework.common.bean.JSONResult;
import com.fullee.yangquan.master.system.service.ISystemUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class SystemUserEndpoint {

    @Autowired
    private ISystemUserService service;

    /**
     * 新增用户
     * @return
     */
    @PostMapping("/add")
    public JSONResult add(){

        return null;
    }



}
