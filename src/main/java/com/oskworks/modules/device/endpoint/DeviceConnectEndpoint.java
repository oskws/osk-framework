package com.oskworks.modules.device.endpoint;

import com.github.benmanes.caffeine.cache.LoadingCache;
import com.oskworks.framework.common.bean.ErrorEnum;
import com.oskworks.framework.common.bean.JSONResult;
import com.oskworks.modules.device.domain.Device;
import com.oskworks.modules.device.service.IDeviceService;
import com.oskworks.modules.sampled.dto.SampledDataUpload;
import com.oskworks.modules.sampled.service.ISampledDataService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/device")
@AllArgsConstructor
public class DeviceConnectEndpoint {

    private LoadingCache<String, Device> cache;

    private IDeviceService deviceService;

    private ISampledDataService sampledDataService;

    /**
     * 设备心跳保持链接
     */
    @PostMapping("/keepalive")
    public JSONResult<?> keepalive(@RequestParam("deviceNo") String deviceNo) {

        Device device = cache.get(deviceNo);
        if (Objects.isNull(device)) {
            return JSONResult.fail(ErrorEnum.DEVICE_NOT_EXISTS);
        }

        return JSONResult.success();
    }

    /**
     * 数据上传
     */
    @PostMapping("/sampled")
    public JSONResult<?> upload(@RequestBody SampledDataUpload data) {

        Device device = deviceService.getByDeviceNo(data.getDeviceNo());
        if (Objects.isNull(device)) {
            return JSONResult.fail(ErrorEnum.DEVICE_NOT_EXISTS);
        }
        sampledDataService.save(data.toSampledData(device));
        return JSONResult.success();
    }

}
