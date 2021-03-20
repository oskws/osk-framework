package com.oskworks.modules.region.endpoint;


import cn.dev33.satoken.stp.StpUtil;
import com.oskworks.framework.common.bean.JSONResult;
import com.oskworks.framework.configure.ApplicationConfiguration;
import com.oskworks.modules.region.domain.Region;
import com.oskworks.modules.region.service.IRegionService;
import com.oskworks.modules.system.domain.User;
import com.oskworks.modules.system.entity.LoginEntity;
import com.oskworks.modules.system.service.IUserService;
import lombok.AllArgsConstructor;
import org.osgl.util.S;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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

    private final IRegionService regionService;

    /**
     *  获取子地区列表
     */
    @PutMapping("/child/{id}")
    public JSONResult<?> login(@PathVariable String id) {

        List<Region> regions = regionService.lambdaQuery().eq(Region::getParentId, id).list();
        return JSONResult.success(regions);
    }


}
