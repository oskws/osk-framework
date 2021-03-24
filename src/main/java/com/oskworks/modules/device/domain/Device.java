package com.oskworks.modules.device.domain;

import cn.hutool.core.date.DatePattern;
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
@TableName(value = "lm_device", autoResultMap = true)
public class Device implements Serializable {

    @TableId
    private Long id;

    private String deviceNo;

    private String detectUnitId;

    private String regionPath;

    private String deviceType;

    private String deviceOnlineState;

    @JsonFormat(pattern = DatePattern.NORM_DATETIME_PATTERN)
    private LocalDateTime createdTime;

}
