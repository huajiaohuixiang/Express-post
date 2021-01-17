package com.tongji.express.mapper.worker;

import com.tongji.express.entity.CouponStore;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

/**
 * created by kz on
 */
@Mapper
@Repository
public interface GetCouponsMapper {

    @Select("select batch_id,num from coupons where num!=0")
    ArrayList<CouponStore> query();
}
