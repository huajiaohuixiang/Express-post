package com.tongji.express.controller;

import com.timesten.jdbc.JdbcOdbcStatement;
import com.timesten.jdbc.TimesTenConnection;
import com.timesten.jdbc.TimesTenDataSource;
import com.tongji.express.ExpressApplication;
import com.tongji.express.entity.CouponStore;
import com.tongji.express.mapper.worker.GetCouponsMapper;
import com.tongji.express.result.State;
import org.hibernate.boot.model.relational.AuxiliaryDatabaseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.jdbc.core.CallableStatementCallback;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@CrossOrigin
public class CouponsController {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping("/createNCoupons")
    public Integer createaNCoupons(@RequestParam("N")String N, @RequestParam("date")String date, @RequestParam("amount")float amount){
        try {
            this.jdbcTemplate.execute("call createNCoupon("+N+",'"+date+"',"+amount+")");
            return 1;
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }
    @GetMapping("/showCoupons")
    public List<Map<String, Object>> showCoupons(){
        List<Map<String, Object>> list = (List<Map<String, Object>>) jdbcTemplate.execute(
                con -> {
                    String storedProc = "{call showCoupon(?)}";// 调用的sql
                    CallableStatement cs = con.prepareCall(storedProc);

                    cs.registerOutParameter(1, Types.REF_CURSOR );// 注册输出参数的类型
                    return cs;
                }, (CallableStatementCallback) cs -> {
                    List resultsMap = new ArrayList();
                    cs.execute();
                    ResultSet rs = (ResultSet) cs.getObject(1);// 获取游标一行的值
                    while (rs.next()) {// 转换每行的返回值到Map中
                        Map rowMap = new HashMap();
                        rowMap.put("BATCH_ID", rs.getString("BATCH_ID"));
                        rowMap.put("DUE_DATE", rs.getString("DUE_DATE"));
                        rowMap.put("AMOUNT",rs.getString("AMOUNT"));
                        rowMap.put("NUM",rs.getString("NUM"));
                        resultsMap.add(rowMap);
                    }
                    rs.close();
                    return resultsMap;
                });
return list;
    }

    @GetMapping("/getUserCoupon")
    public List<Map<String,Object>> getUserCoupons(@RequestParam("id")String id){
        List<Map<String, Object>> list = (List<Map<String, Object>>) jdbcTemplate.execute(
                con -> {
                    String storedProc = "{call searchCoupon(?,?)}";// 调用的sql
                    CallableStatement cs = con.prepareCall(storedProc);
                    cs.setString(1,id);
                    cs.registerOutParameter(2, Types.REF_CURSOR );// 注册输出参数的类型
                    return cs;
                }, (CallableStatementCallback) cs -> {
                    List resultsMap = new ArrayList();
                    cs.execute();
                    ResultSet rs = (ResultSet) cs.getObject(2);// 获取游标一行的值
                    while (rs.next()) {// 转换每行的返回值到Map中
                        Map rowMap = new HashMap();

                        rowMap.put("BATCH_ID", rs.getString("BATCH_ID"));
                        rowMap.put("DUE_DATE", rs.getString("DUE_DATE"));
                        rowMap.put("AMOUNT",rs.getString("AMOUNT"));
                        resultsMap.add(rowMap);
                    }
                    rs.close();
                    return resultsMap;
                });
        return list;
    }

    @Autowired
    RedisTemplate<String,String> redisTemplate;
    @Autowired
    GetCouponsMapper getCouponsMapper;
    @GetMapping("/startGrab")
    public State StartGrab(){
        try{
            ArrayList<CouponStore> arr=getCouponsMapper.query();
            for(CouponStore c : arr){
                redisTemplate.opsForValue().set(c.getBatchID(),c.getNum()+"");
            }
            return State.success;
        }catch(Exception e){
                e.printStackTrace();
                return State.fail;
            }
    }

    @GetMapping("/grabCoupons1")
    public Integer grabCoupons1(@RequestParam("userid")String userid,@RequestParam("batch_id")String batch_id){
        long stock=redisTemplate.opsForValue().decrement(batch_id);
        //System.out.println("-------"+stock+"----------");
        if(stock<0)
        {
            redisTemplate.opsForValue().increment(batch_id);
            return 0;
        }
        try {
            this.jdbcTemplate.execute("call grabCoupon1('"+userid+"','"+batch_id+"')");
            return 1;
        }catch (Exception e){
            System.out.println("-----秒杀失败-----");
            redisTemplate.opsForValue().increment(batch_id);
            return 0;
        }
    }


    @GetMapping("/grabCoupons2")
    public Integer grabCoupons2(@RequestParam("userid")String userid,@RequestParam("batch_id")String batch_id){
        long stock=redisTemplate.opsForValue().decrement(batch_id);
        //System.out.println("-------"+stock+"----------");
        if(stock<0)
        {
            redisTemplate.opsForValue().increment(batch_id);
            return 0;
        }
        try {
            TimesTenConnection ttcon = (TimesTenConnection) ExpressApplication.ttds
                    .getConnection();
            CallableStatement callableStatement= ttcon.prepareCall("{call grabcoupon1(?,?)}");
            callableStatement.setString(1,userid);
            callableStatement.setString(2,batch_id);
            callableStatement.execute();
            ttcon.close();
            return 1;
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("-----秒杀失败-----");
            redisTemplate.opsForValue().increment(batch_id);
            return 0;
        }

    }


    @GetMapping("/grabCoupons")
    public Integer grabCoupons(@RequestParam("userid")String userid,@RequestParam("batch_id")String batch_id){
        try {
            this.jdbcTemplate.execute("call grabCoupon('"+userid+"','"+batch_id+"')");
            return 1;
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }

//
//    @GetMapping("/getAllCoupons")
//    public List<Map<String,Object>> getAllCoupons(){
//        List<Map<String, Object>> list = (List<Map<String, Object>>) jdbcTemplate.execute(
//                con -> {
//                    String storedProc = "{call searchCoupon(?)}";// 调用的sql
//                    CallableStatement cs = con.prepareCall(storedProc);
//
//                    cs.registerOutParameter(1, Types.REF_CURSOR );// 注册输出参数的类型
//                    return cs;
//                }, (CallableStatementCallback) cs -> {
//                    List resultsMap = new ArrayList();
//                    cs.execute();
//                    ResultSet rs = (ResultSet) cs.getObject(1);// 获取游标一行的值
//                    while (rs.next()) {// 转换每行的返回值到Map中
//                        Map rowMap = new HashMap();
//
//                        rowMap.put("BATCH_ID", rs.getString("BATCH_ID"));
//                        rowMap.put("DUE_DATE", rs.getString("DUE_DATE"));
//                        rowMap.put("AMOUNT",rs.getString("AMOUNT"));
//                        rowMap.put("NUM",rs.getString("NUM"));
//                        resultsMap.add(rowMap);
//                    }
//                    rs.close();
//                    return resultsMap;
//                });
//        return list;
//    }

}
