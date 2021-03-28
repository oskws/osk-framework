package com.oskworks.modules.sampled.dto;

import cn.hutool.core.date.DatePattern;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class SampledDataListQuery {

    private String sampledName;

    private String detectUnitName;

    private String detectItem;

    private Integer detectResult;

    /* 开始时间 */
    @JsonFormat(pattern = DatePattern.NORM_DATE_PATTERN)
    private Date detectTimeStart;

    /* 结束时间 */
    @JsonFormat(pattern = DatePattern.NORM_DATE_PATTERN)
    private Date detectTimeEnd;

    private Integer current = 1;

    private Integer pageSize = 20;

}
