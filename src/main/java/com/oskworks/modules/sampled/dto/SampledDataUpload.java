package com.oskworks.modules.sampled.dto;

import cn.hutool.core.date.DatePattern;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.oskworks.modules.device.domain.Device;
import com.oskworks.modules.sampled.domain.SampledData;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 设备上传采样数据
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class SampledDataUpload implements Serializable {

    private String sampledName;

    private String sampledNo;

    private String deviceNo;

    private String detectItem;

    private String detectValue;

    private Integer detectResult;

    @JsonFormat(pattern = DatePattern.NORM_DATETIME_PATTERN)
    private LocalDateTime detectTime;

    public SampledData toSampledData(Device device) {
        return SampledData.builder()
                .createdTime(LocalDateTime.now())
                .detectItem(this.detectItem)
                .detectResult(this.detectResult)
                .detectTime(this.detectTime)
                .detectUnitId(device.getDetectUnitId())
                .detectUnitName(device.getDetectUnitName())
                .detectValue(this.detectValue)
                .deviceNo(this.deviceNo)
                .sampledName(this.sampledName)
                .sampledNo(this.sampledNo)
                .build();
    }
}
