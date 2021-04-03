package com.oskworks.modules.analysis;


import com.oskworks.framework.common.bean.JSONResult;
import com.oskworks.modules.analysis.service.AnalysisService;
import com.oskworks.modules.device.domain.Device;
import com.oskworks.modules.device.service.IDeviceService;
import com.oskworks.modules.sampled.domain.SampledData;
import com.oskworks.modules.sampled.service.ISampledDataService;
import lombok.AllArgsConstructor;
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
@RequestMapping("/analysis")
@AllArgsConstructor
public class AnalysisEndpoint {

    private final AnalysisService analysisService;

    private final IDeviceService deviceService;

    private final ISampledDataService sampledDataService;


    /**
     * 总览
     */
    @GetMapping("/overview")
    public JSONResult<?> overview() {

        List<Device> devices = deviceService.getDeviceListByCurrentUser();
        if (devices.isEmpty()) {
            return JSONResult.fail("暂无数据");
        }

        return JSONResult.success(analysisService.overviewResult(devices.stream().map(Device::getDeviceNo).collect(Collectors.toList())));
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
