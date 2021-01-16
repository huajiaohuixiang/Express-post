package com.tongji.express.mapper.user.order;

import com.tongji.express.entity.inputVo.TrueExOrder;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.springframework.stereotype.Repository;

/**
 * created by kz on
 */
@Mapper
@Repository
public interface ExpressOrderMapper {
    @Options(useGeneratedKeys=true,keyProperty="orderID",keyColumn = "order_id")

    @Insert("insert into ex_order(sender_name,SENDER_PHONE,SENDER_ADDRESS,COMPANY,RECEIVER_NAME,RECEIVER_PHONE,RECEIVER_ADDRESS,ORDER_DATE) values(#{senderName,jdbcType=VARCHAR}," +
            "#{senderPhone,jdbcType=VARCHAR},#{senderAddress,jdbcType=VARCHAR},#{company,jdbcType=VARCHAR},#{receiverName,jdbcType=VARCHAR},#{receiverPhone,jdbcType=VARCHAR},#{receiverAddress,jdbcType=VARCHAR},#{orderDate,jdbcType=DATE})")
    int addOrder(TrueExOrder order);
}
