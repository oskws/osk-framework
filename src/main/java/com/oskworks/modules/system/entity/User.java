package com.oskworks.modules.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 用户账号信息表
 * </p>
 *
 * @author osk-generator
 * @since 2020-08-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("system_user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String loginName;

    private String nickname;

    private String passwordSlat;

    private String userPassword;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updatedTime;

}