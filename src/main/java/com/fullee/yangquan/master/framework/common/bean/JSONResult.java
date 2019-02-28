package com.fullee.yangquan.master.framework.common.bean;

import lombok.Data;

@Data
public class JSONResult {

    private Integer code = 1;

    // 开发者友好提示
    private String msg = "success";

    // 用户友好提示
    private String view = "成功";


    private Object payload;

    private JSONResult(){}


    public JSONResult(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public JSONResult(Integer code, String msg, String view) {
        this.code = code;
        this.msg = msg;
        this.view = view;
    }

    public JSONResult(Object payload) {
        this.payload = payload;
    }

    public static JSONResult success(){
        return new JSONResult();
    }

    public static JSONResult fail(){
        return new JSONResult(0,"fail","失败");
    }

    public static JSONResult fail(Integer code,String msg){
        return new JSONResult(code,msg);
    }

    public static JSONResult success(Integer code,String msg){
        return new JSONResult(code,msg);
    }

    public static JSONResult success(Object body){
        return new JSONResult(body);
    }

}
