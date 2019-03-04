package com.fullee.yangquan.master.system.repository;


import com.fullee.yangquan.master.system.model.SystemUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface SystemUserRepository extends JpaRepository<SystemUser,Integer>,JpaSpecificationExecutor<SystemUser>,Serializable {

    SystemUser findByLoginName(String loginName);

}
