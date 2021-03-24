package com.oskworks.modules.system.service;

import com.oskworks.modules.system.domain.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.oskworks.modules.system.dto.RegionUserDTO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author osk-generator
 * @since 2020-08-27
 */
public interface IUserService extends IService<User> {

    RegionUserDTO getLoginRegionUser();

}
