package com.tongji.express.entity.inputVo;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Repository;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

/**
 * created by kz on
 */

@Data
@Validated
public class Account {

    @Length(min=11,max=11)
    private String userID;
    private String password;
    @NotNull
    private String name="default";
    @Length(min=1,max=1)
    private String sex="男";

    public Account(String id,String name){
        this.userID=id;
        this.name=name;
    }
}
