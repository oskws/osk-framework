package com.fullee.yangquan.master.system.service.impl;

import com.fullee.yangquan.master.framework.exception.AuthenticationException;
import com.fullee.yangquan.master.framework.serve.GeneratorMacKit;
import com.fullee.yangquan.master.system.model.SystemUser;
import com.fullee.yangquan.master.system.repository.SystemUserRepository;
import com.fullee.yangquan.master.system.service.ISystemGeneratorMacService;
import com.fullee.yangquan.master.system.service.ISystemUserService;
import org.osgl.util.Crypto;
import org.osgl.util.CryptoService;
import org.osgl.util.S;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Objects;

@Service
public class SystemUserServiceImpl implements ISystemUserService {

    @Autowired
    private SystemUserRepository repository;

    @Autowired
    private ISystemGeneratorMacService generatorMacService;

    @Override
    public boolean userLogin(SystemUser user){
        SystemUser systemUser = repository.findByLoginName(user.getLoginName());

        if (Objects.isNull(systemUser)) {
            throw new AuthenticationException("用户不存在");
        }
        String systemPassword = genPassword(user.getLoginName(), systemUser.getLoginSalt(), user.getLoginPassword());

        if (S.eq(systemPassword, systemUser.getLoginPassword())) {
            return true;
        }

        throw new AuthenticationException("用户登录失败");
    }

    @Override
    public SystemUser userJoin(SystemUser user) {

//        user.setUkMac(GeneratorMacKit.createdMAC(SystemUser.PREFIX));
        user.setUkMac(generatorMacService.createdMAC(SystemUser.PREFIX));
        user.setCreatedTime(LocalDateTime.now());
        user.setCreatedBy("self register");
        user.setLoginSalt(Crypto.genSecret(6));
        user.setLoginPassword(genPassword(user.getLoginName(),user.getLoginSalt(),user.getLoginPassword()));

        return repository.save(user);
    }

    private String genPassword(String acc, String salt, String password) {
        char[] chars = S.concat(acc, salt, Crypto.passwordHash(password, Crypto.HashType.MD5)).toCharArray();
        return S.string(Crypto.generatePassword(chars));
    }
}
