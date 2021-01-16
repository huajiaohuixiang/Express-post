package com.tongji.express.mapper.user.account;

import com.tongji.express.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * created by kz on
 */
@Mapper
@Repository
public interface UpdateUserInfoMapper {

    @Update("update users set name=#{name},province=#{province},city=#{city},region=#{region},detail=#{detail} where user_ID=#{userID}")
    int updateUserInfo(UserInfo userInfo);
}
