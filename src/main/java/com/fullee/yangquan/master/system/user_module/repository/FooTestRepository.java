package com.fullee.yangquan.master.system.user_module.repository;


import com.fullee.yangquan.master.system.user_module.model.FooTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public interface FooTestRepository extends JpaRepository<FooTest,Integer>,JpaSpecificationExecutor<FooTest>,Serializable {

    @Override
    List<FooTest> findAll();
}
