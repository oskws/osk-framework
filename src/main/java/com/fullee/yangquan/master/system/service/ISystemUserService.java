package com.fullee.yangquan.master.system.service;

import com.fullee.yangquan.master.system.model.SystemUser;

public interface ISystemUserService {

    SystemUser userLogin(SystemUser user);

    SystemUser userJoin(SystemUser user);

    /**
     * 检查用户有效性
     * @param loginName
     * @return
     */
    boolean checkedUser(String loginName);

}
