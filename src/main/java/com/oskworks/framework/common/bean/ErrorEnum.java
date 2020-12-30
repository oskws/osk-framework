package com.oskworks.framework.common.bean;

public enum ErrorEnum {
    SUCCESS(1, "success", "成功"),
    FAIL(0, "fail"),
    NOT_LOGIN(401, "NotLoginException", "用户未登录"),
    NO_HANDLER_FOUND(404, "NoHandlerFoundException", "404");



    private Integer code;

    // 开发者友好提示
    private String msg;

    // 用户友好提示
    private String view;

    ErrorEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    ErrorEnum(Integer code, String msg, String view) {
        this.code = code;
        this.msg = msg;
        this.view = view;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getView() {
        return view;
    }

    public void setView(String view) {
        this.view = view;
    }
}
