package com.oskworks.modules.device.dto;

import lombok.Data;

@Data
public class DeviceListQuery {

    private Integer deviceOnlineState;

    private String deviceType;

    private String deviceNo;

    /* 地区路径 */
    private String regionPath;


    private Integer current = 1;

    private Integer pageSize = 20;

}
