package com.tongji.express.entity;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * created by kz on
 */
@Data
@Repository
public class UserInfo {

    //密码
    @Length(min=11,max=11)
    private String userID;

    //性别
    @NotEmpty
    private String sex="男";

    @NotNull
    private String name;
    private String province;
    private String city;
    private String region;
    private String detail;


}
