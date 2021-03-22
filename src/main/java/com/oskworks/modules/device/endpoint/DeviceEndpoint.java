package com.oskworks.modules.device.endpoint;


import com.oskworks.framework.common.bean.JSONResult;
import com.oskworks.modules.device.domain.Device;
import com.oskworks.modules.device.service.IDeviceService;
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
@RequestMapping("/device")
@AllArgsConstructor
public class DeviceEndpoint {

    private final IDeviceService deviceService;

    /**
     * 根据地区获取检测单位列表
     */
    @GetMapping("/list/{regionId}")
    public JSONResult<?> list(@RequestParam("regionId") String regionId) {
        List<Device> units = deviceService.lambdaQuery().eq(Device::getRegionId, regionId).list();
        return JSONResult.success(units);
    }

    @PostMapping("/add")
    public JSONResult<?> add(@RequestBody Device detectUnit) {
        deviceService.save(detectUnit);
        return JSONResult.success();
    }

    @PostMapping("/remove/{id}")
    public JSONResult<?> remove(@PathVariable Long detectUnit) {
        deviceService.removeById(detectUnit);
        return JSONResult.success();
    }


}
