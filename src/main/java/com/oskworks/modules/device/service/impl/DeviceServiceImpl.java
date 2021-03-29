package com.oskworks.modules.device.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.oskworks.modules.device.domain.Device;
import com.oskworks.modules.device.mapper.DeviceMapper;
import com.oskworks.modules.device.service.IDeviceService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author osk-generator
 * @since 2020-08-27
 */
@Service
public class DeviceServiceImpl extends ServiceImpl<DeviceMapper, Device> implements IDeviceService {

    @Override
    public Device getByDeviceNo(String deviceNo) {
        return lambdaQuery().eq(Device::getDeviceNo, deviceNo).one();
    }
}
