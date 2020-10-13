package com.oskworks.modules.system.service.impl;

import com.oskworks.modules.system.entity.User;
import com.oskworks.modules.system.mapper.UserMapper;
import com.oskworks.modules.system.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
