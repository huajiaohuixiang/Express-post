package com.tongji.express.intercepter.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class JsonData implements Serializable {

    private static final long serialVersionUID = 1L;


    //状态码 0 表示成功，1表示处理中，-1表示失败

    private Integer code;

    private Object data;

    private String msg;

    public static JsonData buildSuccess() {
        return new JsonData(0, null, null);
    }


    public static JsonData buildSuccess(Object data) {
        return new JsonData(0, data, null);
    }


    public static JsonData buildError(String msg) {
        return new JsonData(-1, null, msg);
    }


    public static JsonData buildError(String msg, Integer code) {
        return new JsonData(code, null, msg);
    }

    public static JsonData buildSuccess(Object data, String msg) {
        return new JsonData(0, data, msg);
    }


    public static JsonData buildSuccess(Object data, int code) {
        return new JsonData(code, data, null);
    }

}
