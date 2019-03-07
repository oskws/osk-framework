package com.fullee.yangquan.master.system.repository;


import com.fullee.yangquan.master.system.model.SystemDict;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface SystemDictRepository extends JpaRepository<SystemDict, Integer>, JpaSpecificationExecutor<SystemDict>, Serializable {

}
