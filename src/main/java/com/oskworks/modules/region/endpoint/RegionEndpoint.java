package com.oskworks.modules.region.endpoint;


import com.oskworks.framework.common.bean.JSONResult;
import com.oskworks.modules.region.domain.Region;
import com.oskworks.modules.region.dto.RegionNodeResult;
import com.oskworks.modules.region.service.IRegionService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 前端控制器
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
     * 获取子地区列表
     */
    @GetMapping("/child/{id}")
    public JSONResult<?> login(@PathVariable String id) {

        List<Region> regions = regionService.lambdaQuery().eq(Region::getParentId, id).list();
        List<RegionNodeResult> result = regions.stream().map(RegionNodeResult::new).collect(Collectors.toList());
        return JSONResult.success(result);
    }


}
