package com.oskworks.modules.detectunit.domain;

import cn.hutool.core.date.DatePattern;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 检测单位
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName(value = "lm_detect_unit", autoResultMap = true)
public class DetectUnit implements Serializable {

    @TableId(value = "id",type = IdType.AUTO)
    private Long id;

    private String regionId;

    private String unitName;

    private String principalName;

    private String principalMobileNo;

    @JsonFormat(pattern = DatePattern.NORM_DATETIME_PATTERN)
    private LocalDateTime createdTime;

}
