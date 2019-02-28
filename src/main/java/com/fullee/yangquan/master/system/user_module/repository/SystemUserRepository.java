package com.fullee.yangquan.master.system.user_module.repository;


import com.fullee.yangquan.master.system.user_module.model.SystemUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface SystemUserRepository extends JpaRepository<SystemUser,Integer>,JpaSpecificationExecutor<SystemUser>,Serializable {

}
