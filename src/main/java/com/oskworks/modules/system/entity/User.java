package com.oskworks.modules.system.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.FastjsonTypeHandler;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

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
@TableName(value = "system_user",autoResultMap = true)
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String loginName;

    private String nickname;

    private String passwordSlat;

    private String userPassword;

    @TableField(typeHandler = FastjsonTypeHandler.class)
    private Details details;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updatedTime;

    @Data
    private static class Details {
        String sex;
        Integer age;
    }

}

