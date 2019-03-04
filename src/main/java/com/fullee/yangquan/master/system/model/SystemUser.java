package com.fullee.yangquan.master.system.model;

import com.alibaba.fastjson.JSON;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "system_user")
@NoArgsConstructor
public class SystemUser {

    public static final String PREFIX = "USER";

    public SystemUser(String loginName, String loginPassword) {
        this.loginName = loginName;
        this.loginPassword = loginPassword;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public String toJSON() {
        return JSON.toJSONString(this);
    }
}
