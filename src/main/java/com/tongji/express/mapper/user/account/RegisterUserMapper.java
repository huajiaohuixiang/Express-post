package com.tongji.express.mapper.user.account;

import com.tongji.express.entity.inputVo.Account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * created by kz on
 */

@Mapper
@Repository
public interface RegisterUserMapper {

    @Insert("insert into users(USER_ID,NAME,PASSWORD,SEX) values(#{userID},#{name},#{password},#{sex})")
    int insertNewUser(Account account);
}
