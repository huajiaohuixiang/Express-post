package com.tongji.express.mapper.user.express;

import com.tongji.express.entity.Box;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * created by kz on
 */
@Mapper
@Repository
public interface GetOutExpressMapper {

    @Select("select * from Box where cupboard_id=#{id} and code=#{code}")
    Box getBoxInfo(String id,String code);
}
