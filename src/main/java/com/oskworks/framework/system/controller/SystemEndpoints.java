package com.oskworks.framework.system.controller;


import com.oskworks.framework.common.bean.JSONResult;
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
@RequestMapping("/system")
public class SystemEndpoints {



    @GetMapping("/version")
    public JSONResult<String> version() {
        return null;
    }


}
