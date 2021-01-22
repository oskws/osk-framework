package com.oskworks.modules.region.domain;

import cn.hutool.core.date.DatePattern;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 行政区划
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName(value = "osk_region", autoResultMap = true)
public class Region implements Serializable {


    private String id;

    private String name;

    private String parentId;

    private String lng;

    private String lat;

    @JsonFormat(pattern = DatePattern.NORM_DATETIME_PATTERN)
    private LocalDateTime createdAt;

    @JsonFormat(pattern = DatePattern.NORM_DATETIME_PATTERN)
    private LocalDateTime updatedAt;

}
