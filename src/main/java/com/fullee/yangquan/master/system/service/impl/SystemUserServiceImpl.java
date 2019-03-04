package com.fullee.yangquan.master.system.service.impl;

import com.fullee.yangquan.master.system.model.SystemUser;
import com.fullee.yangquan.master.system.repository.SystemUserRepository;
import com.fullee.yangquan.master.system.service.ISystemUserService;
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
