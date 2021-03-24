package com.oskworks.modules.sampled.endpoint;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.oskworks.framework.common.bean.JSONResult;
import com.oskworks.modules.device.domain.Device;
import com.oskworks.modules.device.service.IDeviceService;
import com.oskworks.modules.region.dto.RegionType;
import com.oskworks.modules.sampled.domain.SampledData;
import com.oskworks.modules.sampled.service.ISampledDataService;
import com.oskworks.modules.system.dto.RegionUserDTO;
import com.oskworks.modules.system.service.IUserService;
import lombok.AllArgsConstructor;
import org.osgl.util.N;
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
@RequestMapping("/sampled")
@AllArgsConstructor
public class SampledDataEndpoint {

    private final IUserService userService;

    private final IDeviceService deviceService;

    private final ISampledDataService sampledDataService;


    /**
     * 展示用户可视区域的采样数据
     */
    @GetMapping("/list")
    public JSONResult<?> list(@RequestParam(value = "page",defaultValue = "1") int page, @RequestParam(value = "size",defaultValue = "20") int size) {

        RegionUserDTO regionUser = userService.getLoginRegionUser();

        LambdaQueryWrapper<Device> wrapper = Wrappers.lambdaQuery(Device.class);
        if (N.eq(regionUser.getRegionType(), RegionType.REGION)) {
            wrapper = wrapper.likeRight(Device::getRegionPath, regionUser.getRegionPath());
        } else {
            wrapper = wrapper.eq(Device::getRegionPath, regionUser.getRegionPath());
        }

        List<Device> devices = deviceService.list(wrapper);
        if (devices.isEmpty()) {
            return JSONResult.fail("暂无数据");
        }


        Page<SampledData> sampledData = sampledDataService.lambdaQuery()
                .in(SampledData::getDeviceNo, devices.stream().map(Device::getDeviceNo).collect(Collectors.toList()))
                .page(new Page<>(page, size));

        return JSONResult.success(sampledData);
    }

    /**
     * 设备上传数据
     */
    @PostMapping("/add")
    public JSONResult<?> add(@RequestBody SampledData data) {
        sampledDataService.save(data);
        return JSONResult.success();
    }

    @PostMapping("/remove/{id}")
    public JSONResult<?> remove(@PathVariable Long detectUnit) {
        sampledDataService.removeById(detectUnit);
        return JSONResult.success();
    }


}
