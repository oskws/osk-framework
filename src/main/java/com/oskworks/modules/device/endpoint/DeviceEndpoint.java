package com.oskworks.modules.device.endpoint;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.oskworks.framework.common.bean.JSONResult;
import com.oskworks.modules.device.domain.Device;
import com.oskworks.modules.device.dto.DeviceListQuery;
import com.oskworks.modules.device.service.IDeviceService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/list")
    public JSONResult<?> list(@RequestBody DeviceListQuery query) {


        Page<Device> result = deviceService.lambdaQuery()
                .likeRight(Device::getRegionPath, query.getRegionPath())
                .page(new Page<>(query.getPage(), query.getSize()));
        return JSONResult.success(result);
    }

    @PutMapping("/{id}")
    public JSONResult<?> modify(@PathVariable Long id, @RequestBody Device device) {
        device.setId(id);
        deviceService.updateById(device);
        return JSONResult.success();
    }

    @PostMapping
    public JSONResult<?> add(@RequestBody Device device) {
        deviceService.save(device);
        return JSONResult.success();
    }

    @DeleteMapping("/{id}")
    public JSONResult<?> remove(@PathVariable Long id) {
        deviceService.removeById(id);
        return JSONResult.success();
    }


}
