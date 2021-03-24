package com.oskworks.modules.device.dto;

import lombok.Data;

@Data
public class DeviceListQuery {

    private String deviceNo;

    /* 地区路径 */
    private String regionPath;

    private Integer page = 1;

    private Integer size = 20;

}
