package com.fullee.yangquan.master.system.repository;


import com.fullee.yangquan.master.system.model.SystemGeneratorMac;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface SystemGeneratorMacRepository extends JpaRepository<SystemGeneratorMac, Integer>, JpaSpecificationExecutor<SystemGeneratorMac>, Serializable {

    SystemGeneratorMac findByPrefix(String prefix);
}
