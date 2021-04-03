package com.oskworks.modules.device.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.oskworks.modules.device.domain.Device;
import com.oskworks.modules.device.mapper.DeviceMapper;
import com.oskworks.modules.device.service.IDeviceService;
import com.oskworks.modules.region.dto.RegionType;
import com.oskworks.modules.system.dto.RegionUserDTO;
import com.oskworks.modules.system.service.IUserService;
import lombok.AllArgsConstructor;
import org.osgl.util.N;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author osk-generator
 * @since 2020-08-27
 */
@Service
@AllArgsConstructor
public class DeviceServiceImpl extends ServiceImpl<DeviceMapper, Device> implements IDeviceService {

    private final IUserService userService;

    @Override
    public Device getByDeviceNo(String deviceNo) {
        return lambdaQuery().eq(Device::getDeviceNo, deviceNo).one();
    }

    @Override
    public List<Device> getDeviceListByCurrentUser() {
        RegionUserDTO regionUser = userService.getLoginRegionUser();

        LambdaQueryWrapper<Device> wrapper = Wrappers.lambdaQuery(Device.class);
        if (N.eq(regionUser.getRegionType(), RegionType.REGION)) {
            wrapper = wrapper.likeRight(Device::getRegionPath, regionUser.getRegionPath());
        } else {
            wrapper = wrapper.eq(Device::getRegionPath, regionUser.getRegionPath());
        }

        return list(wrapper);
    }
}
