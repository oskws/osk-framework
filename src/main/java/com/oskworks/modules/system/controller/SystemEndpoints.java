package com.oskworks.modules.system.controller;


import com.oskworks.framework.common.bean.JSONResult;
import com.oskworks.framework.configure.ApplicationConfiguration;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping
@AllArgsConstructor
public class SystemEndpoints {

    private final ApplicationConfiguration configuration;

    @GetMapping("/version")
    public JSONResult<String> version() {
        return JSONResult.success(configuration.getVersion());
    }

}
