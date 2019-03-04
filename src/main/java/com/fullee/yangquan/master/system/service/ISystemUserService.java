package com.fullee.yangquan.master.system.service;

import com.fullee.yangquan.master.system.model.SystemUser;

public interface ISystemUserService {

    boolean userLogin(SystemUser user);

    SystemUser userJoin(SystemUser user);

}
