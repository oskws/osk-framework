package com.fullee.yangquan.master.system.endpoint;

import com.fullee.yangquan.master.system.repository.FooTestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/index")
public class FooTest {

    @Autowired
    private FooTestRepository repository;

    @GetMapping
    public Object all(){
        return repository.findAll();
    }
}
