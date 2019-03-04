package com.fullee.yangquan.master.framework.common.bean;

import com.alibaba.fastjson.JSON;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class BaseModel {

    public String toJSON() {
        return JSON.toJSONString(this);
    }
}
