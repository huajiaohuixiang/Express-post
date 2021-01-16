package com.tongji.express.mapper.worker;

import com.tongji.express.entity.inputVo.InBoxRecord;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * created by kz on
 */
@Mapper
@Repository
public interface GetBoxIDMapper {

    @Select("select box_ID from box where cupboard_ID=#{cupboardID,jdbcType=VARCHAR} and rowx=#{x,jdbcType=VARCHAR} and coly=#{y,jdbcType=VARCHAR}")
    String getBoxID(InBoxRecord inBoxRecord);
}
