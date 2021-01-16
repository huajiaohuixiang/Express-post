package com.tongji.express.mapper.user.account;

import com.tongji.express.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * created by kz on
 */

@Mapper
@Repository
public interface GetUserInfoMapper {

    @Select("select * from users where user_ID=#{userID,jdbcType=VARCHAR}")
    UserInfo getUserInfo(@Param("userID") String userID);

}
