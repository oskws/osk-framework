package com.oskworks.modules.system.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.oskworks.modules.system.domain.User;
import com.oskworks.modules.system.dto.RegionUserDTO;
import com.oskworks.modules.system.mapper.UserMapper;
import com.oskworks.modules.system.service.IUserService;
import lombok.AllArgsConstructor;
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
@AllArgsConstructor
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    private final UserMapper userMapper;

    @Override
    public RegionUserDTO getLoginRegionUser() {
        User user = userMapper.selectById(StpUtil.getLoginIdAsLong());
        return new RegionUserDTO(user);
    }
}
