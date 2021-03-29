package com.oskworks.modules.device.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.oskworks.modules.device.domain.Device;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author osk-generator
 * @since 2020-08-27
 */
public interface IDeviceService extends IService<Device> {

    Device getByDeviceNo(String deviceNo);

}
