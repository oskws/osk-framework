package com.oskworks.modules.sampled.endpoint;


import com.oskworks.framework.common.bean.JSONResult;
import com.oskworks.modules.sampled.domain.SampledData;
import com.oskworks.modules.sampled.service.ISampledDataService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
public class SampledDataEndpoint {

    private final ISampledDataService deviceService;

    /**
     * 根据地区获取检测单位列表
     */
    @GetMapping("/list/{regionId}")
    public JSONResult<?> list(@RequestParam("regionId") String regionId) {
        List<SampledData> units = deviceService.lambdaQuery().eq(SampledData::getDeviceNo, regionId).list();
        return JSONResult.success(units);
    }

    /**
     * 设备上传数据
     */
    @PostMapping("/add")
    public JSONResult<?> add(@RequestBody SampledData data) {
        deviceService.save(data);
        return JSONResult.success();
    }

    @PostMapping("/remove/{id}")
    public JSONResult<?> remove(@PathVariable Long detectUnit) {
        deviceService.removeById(detectUnit);
        return JSONResult.success();
    }


}
