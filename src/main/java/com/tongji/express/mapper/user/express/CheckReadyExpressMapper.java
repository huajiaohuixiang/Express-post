package com.tongji.express.mapper.user.express;

import com.tongji.express.entity.inputVo.MyPackage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * created by kz on
 */
//PACKAGE_ID,SENDER_NAME,SENDER_PHONE,SENDER_ADDRESS,COMPANY,RECEIVER_NAME,RECEIVER_PHONE,RECEIVER_ADDRESS,STATUS
@Mapper
@Repository
public interface CheckReadyExpressMapper {

    @Select("select * from package where receiver_phone=#{id,jdbcType=VARCHAR} order by status")
    List<MyPackage> checkReadyExpress(@Param("id") String id);
}
