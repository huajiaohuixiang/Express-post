package com.tongji.express.mapper.worker;

import com.tongji.express.entity.inputVo.InBoxRecord;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

/**
 * created by kz on
 */
@Mapper
@Repository
public interface UpdateBoxInfoMapper {

    @Update("update BOX set state=#{status},package_ID=#{packageID},user_ID=#{userID,jdbcType=VARCHAR},code=#{code,jdbcType=VARCHAR} where box_ID=#{boxID}")
    int updateBoxStatus(InBoxRecord inBoxRecord);

}
