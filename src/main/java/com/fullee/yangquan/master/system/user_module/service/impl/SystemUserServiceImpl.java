package com.fullee.yangquan.master.system.user_module.service.impl;

import com.fullee.yangquan.master.system.user_module.model.SystemUser;
import com.fullee.yangquan.master.system.user_module.repository.SystemUserRepository;
import com.fullee.yangquan.master.system.user_module.service.ISystemUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SystemUserServiceImpl implements ISystemUserService {

    @Autowired
    private SystemUserRepository repository;

    @Override
    public List<SystemUser> findAll(){
        return repository.findAll();
    }
}
