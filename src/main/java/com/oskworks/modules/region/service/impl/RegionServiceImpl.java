package com.oskworks.modules.region.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.oskworks.modules.region.domain.Region;
import com.oskworks.modules.region.mapper.RegionMapper;
import com.oskworks.modules.region.service.IRegionService;
import com.oskworks.modules.system.domain.User;
import com.oskworks.modules.system.mapper.UserMapper;
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
public class RegionServiceImpl extends ServiceImpl<RegionMapper, Region> implements IRegionService {

}
