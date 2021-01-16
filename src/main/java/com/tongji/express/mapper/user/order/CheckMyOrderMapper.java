package com.tongji.express.mapper.user.order;


import com.tongji.express.entity.inputVo.TrueExOrder;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * created by kz on
 */

@Mapper
@Repository
public interface CheckMyOrderMapper {

    @Select("select ORDER_ID,SENDER_NAME,SENDER_PHONE,SENDER_ADDRESS,COMPANY,RECEIVER_NAME,RECEIVER_PHONE,RECEIVER_ADDRESS,STATUS" +
            " from ex_order where sender_phone=#{id,jdbcType=VARCHAR}")

    List<TrueExOrder> checkMyOrder(@Param("id") String id);
}
