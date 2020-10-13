package com.oskworks.modules.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
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

    private Integer loginName;

    private Integer nickname;

    private Integer userSlat;

    private Integer userPassword;

}
