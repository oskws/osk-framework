package com.oskworks.framework.system.service.impl;

import com.oskworks.framework.system.entity.User;
import com.oskworks.framework.system.mapper.UserMapper;
import com.oskworks.framework.system.service.IUserService;
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
