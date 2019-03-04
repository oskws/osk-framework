package com.fullee.yangquan.master.system.service.impl;

import com.fullee.yangquan.master.framework.exception.AuthenticationException;
import com.fullee.yangquan.master.system.model.SystemUser;
import com.fullee.yangquan.master.system.repository.SystemUserRepository;
import com.fullee.yangquan.master.system.service.ISystemGeneratorMacService;
import com.fullee.yangquan.master.system.service.ISystemUserService;
import org.osgl.util.Crypto;
import org.osgl.util.S;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Service
public class SystemUserServiceImpl implements ISystemUserService {

    @Autowired
    private SystemUserRepository repository;

    @Autowired
    private ISystemGeneratorMacService generatorMacService;

    @Override
    public SystemUser userLogin(SystemUser user){
        SystemUser systemUser = repository.findByLoginName(user.getLoginName());

        if (Objects.isNull(systemUser)) {
            throw new AuthenticationException("用户不存在");
        }
        String systemPassword = genPassword(user.getLoginName(), systemUser.getLoginSalt(), user.getLoginPassword());

        if (S.eq(systemPassword, systemUser.getLoginPassword())) {
            return systemUser;
        }

        throw new AuthenticationException("登录认证失败");
    }

    @Override
    public SystemUser userJoin(SystemUser user) {

//        user.setUkMac(GeneratorMacKit.createdMAC(SystemUser.PREFIX));
        user.setUkMac(generatorMacService.createdMAC(SystemUser.PREFIX));
        user.setCreatedTime(LocalDateTime.now());
        user.setCreatedBy("self register");
        user.setLoginSalt(Crypto.genSecret(6));
        user.setLoginPassword(genPassword(user.getLoginName(),user.getLoginSalt(),user.getLoginPassword()));
        System.out.println(user.getLoginPassword().length());
        return repository.save(user);
    }

    private String genPassword(String acc, String salt, String password) {
        String hash = Crypto.passwordHash(password, Crypto.HashType.MD5);
        return Crypto.encryptAES(hash, acc.getBytes(), salt.getBytes());
    }
}
