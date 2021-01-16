package com.tongji.express.mapper.user.account;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Repository;

/**
 * created by kz on
 */

@Mapper
@Repository
public interface EnrollUserMapper {


    @Select("select password from users where user_ID=#{id,jdbcType=VARCHAR}")
    String getPasswordByID(@Param("id") String id);

}
