package com.oskworks.modules.detectunit.endpoint;


import com.oskworks.framework.common.bean.JSONResult;
import com.oskworks.modules.detectunit.domain.DetectUnit;
import com.oskworks.modules.detectunit.service.IDetectUnitService;
import com.oskworks.modules.region.dto.RegionNodeResult;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 检测单位
 * </p>
 *
 * @author fullee
 * @since 2021-01-20
 */
@RestController
@RequestMapping("/detectunit")
@AllArgsConstructor
public class DetectUnitEndpoint {

    private final IDetectUnitService detectUnitService;

    /**
     * 根据地区获取检测单位列表
     */
    @GetMapping("/list/{regionId}")
    public JSONResult<?> list(@PathVariable("regionId") String regionId) {
        List<DetectUnit> units = detectUnitService.lambdaQuery().eq(DetectUnit::getRegionId, regionId).list();
        List<RegionNodeResult> result = units.stream().map(RegionNodeResult::new).collect(Collectors.toList());
        return JSONResult.success(result);
    }

    @GetMapping("/{id}")
    public JSONResult<?> one(@PathVariable("id") Long id) {
        return JSONResult.success(detectUnitService.getById(id));
    }

    @PostMapping
    public JSONResult<?> add(@RequestBody DetectUnit detectUnit) {
        detectUnitService.save(detectUnit);
        return JSONResult.success(new RegionNodeResult(detectUnit));
    }

    @PutMapping("/{id}")
    public JSONResult<?> modify(@PathVariable Long id, @RequestBody DetectUnit detectUnit) {
        detectUnit.setId(id);
        detectUnitService.updateById(detectUnit);
        return JSONResult.success();
    }

    @DeleteMapping("/{id}")
    public JSONResult<?> remove(@PathVariable Long id) {
        detectUnitService.removeById(id);
        return JSONResult.success();
    }


}
