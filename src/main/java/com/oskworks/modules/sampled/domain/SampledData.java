package com.oskworks.modules.sampled.domain;

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
@TableName(value = "lm_sampled_data", autoResultMap = true)
public class SampledData implements Serializable {

    @TableId(value = "id",type = IdType.AUTO)
    private Long id;

    private String sampledName;

    private String sampledNo;

    private Long detectUnitId;

    private String detectUnitName;

    private String deviceNo;

    private String detectItem;

    private String detectValue;

    private String detectResult;

    @JsonFormat(pattern = DatePattern.NORM_DATETIME_PATTERN)
    private LocalDateTime detectTime;

    @JsonFormat(pattern = DatePattern.NORM_DATETIME_PATTERN)
    private LocalDateTime createdTime;

}
