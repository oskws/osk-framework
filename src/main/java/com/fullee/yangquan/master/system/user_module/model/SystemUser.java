package com.fullee.yangquan.master.system.user_module.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "system_user")
public class SystemUser {

    @Id
    @GeneratedValue
    @Column(name = "pk_id",unique = true,nullable = false)
    private Integer pkId;

    @Column(name = "uk_mac",unique = true,nullable = false,length = 32)
    private String ukMac;

    @Column(name = "created_by",length = 64)
    private String createdBy;

    @Column(name = "created_time")
    private LocalDateTime createdTime;

    @Column(name = "updated_by", length = 64)
    private String updatedBy;

    @Column(name = "updated_time")
    private LocalDateTime updatedTime;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "login_name")
    private String loginName;

    @Column(name = "login_password",length = 32)
    private String loginPassword;

    @Column(name = "login_salt",length = 32)
    private String loginSalt;

}
