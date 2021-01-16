package com.tongji.express.result;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * created by kz on
 */
@Data
@AllArgsConstructor
public class State {
    private String result;

    public static State success=new State("success");

    public static State fail=new State("fail");

}
