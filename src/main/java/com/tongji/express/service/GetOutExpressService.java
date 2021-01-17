package com.tongji.express.service;

import com.tongji.express.entity.Box;
import com.tongji.express.entity.inputVo.InBoxRecord;
import com.tongji.express.mapper.user.express.AckExpressMapper;
import com.tongji.express.mapper.user.express.GetOutExpressMapper;
import com.tongji.express.mapper.pack.GetBoxIDMapper;
import com.tongji.express.mapper.worker.UpdateBoxInfoMapper;
import com.tongji.express.result.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.CallableStatementCallback;
import org.springframework.jdbc.core.CallableStatementCreator;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

/**
 * created by kz on
 */
@Service
public class GetOutExpressService {

    @Autowired
    UpdateBoxInfoMapper updateBoxInfoMapper;
    @Autowired
    GetBoxIDMapper getBoxIDMapper;
    @Autowired
    GetOutExpressMapper getOutExpressMapper;
    @Autowired
    AckExpressMapper ackExpressMapper;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Transactional
    public State getOutExpress(String cupboardID,String code){
        try {
            int result = (int) jdbcTemplate.execute(
                    con -> {
                        String storedProc = "{call getoutexpress(?,?,?)}";// 调用的sql
                        CallableStatement cs = con.prepareCall(storedProc);
                        cs.setString(1,cupboardID);// 设置输入参数的值
                        cs.setString(2,code);
                        cs.registerOutParameter(3, Types.INTEGER);// 注册输出参数的类型
                        return cs;
                    }, (CallableStatementCallback) cs -> {
                        cs.execute();
                        return cs.getInt(3);// 获取输出参数的值
                    });
            System.out.println(result);
            if (result==1)
                return State.success;
            else
                return State.fail;
        }catch (Exception e){
            e.printStackTrace();
            return State.fail;
        }
    }
}
