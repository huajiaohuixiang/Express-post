package com.tongji.express.service;

import com.tongji.express.entity.inputVo.TrueExOrder;
import com.tongji.express.mapper.user.order.CheckMyOrderMapper;
import com.tongji.express.mapper.user.order.ExpressOrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * created by kz on
 */
@Service
public class OrderExpressService {
    @Autowired
    ExpressOrderMapper expressOrderMapper;

    @Autowired
    CheckMyOrderMapper checkMyOrderMapper;

    public int addOrder(TrueExOrder order){
        try {
            return expressOrderMapper.addOrder(order);
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }

    public List<TrueExOrder> checkReadyExpress(String id){
        try {
            return checkMyOrderMapper.checkMyOrder(id);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

}
