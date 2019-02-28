package com.fullee.yangquan.master.system.user_module.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "foo_test")
public class FooTest implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "pk_id")
    private Integer pkId;

    @Column(name = "uk_mac")
    private String ukMac;

    @Column(name = "create_time")
    private LocalDateTime createdTime;

    @Column(name = "name")
    private String name;


}
