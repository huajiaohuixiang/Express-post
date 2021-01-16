package com.tongji.express.mapper.user.order;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

/**
 * created by kz on
 */
@Mapper
@Repository
public interface QuitOrderMapper {

    @Update("update ex_order set status='已取消' where order_id=#{id,jdbcType=INTEGER}")
    int quitOrder(@Param("id") int id);
}
