package com.oskworks.framework.common.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class JSONResult<T> implements Serializable {

    private Integer code = 1;

    // 开发者友好提示
    private String msg = "success";

    // 用户友好提示
    private String view = "成功";

    private T payload;

    private JSONResult() {
    }


    public JSONResult(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public JSONResult(Integer code, String msg, String view) {
        this.code = code;
        this.msg = msg;
        this.view = view;
    }

    public JSONResult(T payload) {
        this.payload = payload;
    }

    public static <T> JSONResult<T> success() {
        return new JSONResult<T>();
    }

    public static <T> JSONResult<T> fail() {
        return new JSONResult<>(0, "fail", "失败");
    }

    public static <T> JSONResult<T> fail(String view) {
        return new JSONResult<>(0, "fail", view);
    }

    public static <T> JSONResult<T> fail(Integer code, String msg) {
        return new JSONResult<>(code, msg);
    }

    public static <T> JSONResult<T> success(Integer code, String msg) {
        return new JSONResult<>(code, msg);
    }

    public static <T> JSONResult<T> success(T payload) {
        return new JSONResult<>(payload);
    }

    public static <T> JSONResult<T> fail(ErrorEnum errorEnum) {
        return new JSONResult<>(errorEnum.getCode(), errorEnum.getMsg(), errorEnum.getView());
    }

}
