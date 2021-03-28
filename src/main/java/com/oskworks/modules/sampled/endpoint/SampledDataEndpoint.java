package com.oskworks.modules.sampled.endpoint;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.oskworks.framework.common.bean.JSONResult;
import com.oskworks.modules.device.domain.Device;
import com.oskworks.modules.device.service.IDeviceService;
import com.oskworks.modules.region.dto.RegionType;
import com.oskworks.modules.sampled.domain.SampledData;
import com.oskworks.modules.sampled.dto.SampledDataListQuery;
import com.oskworks.modules.sampled.service.ISampledDataService;
import com.oskworks.modules.system.dto.RegionUserDTO;
import com.oskworks.modules.system.service.IUserService;
import lombok.AllArgsConstructor;
import org.osgl.util.N;
import org.osgl.util.S;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
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
    @PostMapping("/list")
    public JSONResult<?> list(@RequestBody SampledDataListQuery query) {

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
                .likeRight(S.notBlank(query.getDetectItem()), SampledData::getDetectItem, query.getDetectItem())
                .likeRight(S.notBlank(query.getSampledName()), SampledData::getSampledName, query.getSampledName())
                .likeRight(S.notBlank(query.getDetectUnitName()),SampledData::getDetectUnitName,query.getDetectUnitName())
                .eq(Objects.nonNull(query.getDetectResult()), SampledData::getDetectResult,query.getDetectResult())
                .between(Objects.nonNull(query.getDetectTimeStart()) && Objects.nonNull(query.getDetectTimeEnd()), SampledData::getDetectTime,query.getDetectTimeStart(),query.getDetectTimeEnd())
                .page(new Page<>(query.getCurrent(), query.getPageSize()));

        return JSONResult.success(sampledData);
    }

    @PutMapping("/add")
    public JSONResult<?> add(@RequestBody SampledData data) {
        sampledDataService.save(data);
        return JSONResult.success();
    }

    /**
     * 修改设备上传结果
     */
    @PutMapping("/{id}")
    public JSONResult<?> modify(@PathVariable Long id, @RequestBody SampledData data) {

        sampledDataService.lambdaUpdate().eq(SampledData::getId, id)
                .set(Objects.nonNull(data.getDetectResult()), SampledData::getDetectResult, data.getDetectResult())
                .set(Objects.nonNull(data.getDetectValue()), SampledData::getDetectValue, data.getDetectValue())
                .update();

        return JSONResult.success();
    }




}
