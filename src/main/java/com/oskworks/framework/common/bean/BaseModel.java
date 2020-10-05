package com.oskworks.framework.common.bean;

import com.alibaba.fastjson.JSON;

import java.io.Serializable;

public class BaseModel implements Serializable {

    public String toJSON() {
        return JSON.toJSONString(this);
    }
}
