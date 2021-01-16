package com.tongji.express.controller.worker;



import com.baomidou.mybatisplus.extension.plugins.pagination.dialects.Oracle12cDialect;
import com.tongji.express.entity.ExOrder;
import com.tongji.express.entity.Message;
import com.tongji.express.mapper.worker.EmployeeMapper;
import com.tongji.express.mapper.worker.MessageMapper;
import com.tongji.express.mapper.worker.order.orderMapper;
import org.hibernate.dialect.OracleTypesHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.CallableStatementCallback;
import org.springframework.jdbc.core.CallableStatementCreator;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDate;
import java.util.*;

@RestController
@CrossOrigin
public class getOrderInfo {

    @Autowired
    orderMapper ordermapper;

    @Autowired
    MessageMapper messageMapper;

    @Autowired
    EmployeeMapper employeeMapper;
    @Qualifier("dataSource")
    @Autowired
    DataSource dataSource;
    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping("/worker/getOrderById")
    public List<Map<String, Object>> getOrder(@RequestParam("id")String id) {
        List<Map<String, Object>> list = (List<Map<String, Object>>) jdbcTemplate.execute(
                con -> {
                    String storedProc = "{call getorderbyid(?,?)}";// 调用的sql
                    CallableStatement cs = con.prepareCall(storedProc);
                    cs.setString(1, id);// 设置输入参数的值
                    cs.registerOutParameter(2,Types.REF_CURSOR );// 注册输出参数的类型
                    return cs;
                }, (CallableStatementCallback) cs -> {
                    List resultsMap = new ArrayList();
                    cs.execute();
                    ResultSet rs = (ResultSet) cs.getObject(2);// 获取游标一行的值
                    while (rs.next()) {// 转换每行的返回值到Map中
                        Map rowMap = new HashMap();
                        rowMap.put("senderName", rs.getString("sender_name"));
                        rowMap.put("senderPhone", rs.getString("sender_phone"));
                        rowMap.put("senderAddress",rs.getString("sender_address"));
                        rowMap.put("company",rs.getString("company"));
                        rowMap.put("receiverName",rs.getString("receiver_name"));
                        rowMap.put("receiverAddress",rs.getString("receiver_address"));
                        rowMap.put("receiverPhone",rs.getString("receiver_phone"));
                        rowMap.put("packageContent",rs.getString("package_content"));
                        rowMap.put("orderDate",rs.getDate("order_date"));
                        rowMap.put("weight",rs.getDouble("weight"));
                        rowMap.put("status",rs.getString("status"));
                        rowMap.put("employeeId",rs.getString("employee_id"));
                        rowMap.put("orderId",rs.getInt("order_id"));
                        resultsMap.add(rowMap);
                    }
                    rs.close();
                    return resultsMap;
                });

        return list;

    }

    @GetMapping("/worker/getOrderNum")
    public Integer getNum(){
        return ordermapper.getOrderNum();
    }

    @GetMapping("/worker/getOrder")
    public LinkedList<ExOrder> getAllOrder(@RequestParam("pageindex")int pageindex, @RequestParam("pagesize") int pagesize){
        System.out.println(pageindex);
        System.out.println(pagesize);
        return  ordermapper.getOrder(pageindex,pagesize);
    }

    @GetMapping("/worker/getSomeNum")
    public Integer getSomeNum(@RequestParam("status") String status){
        return ordermapper.getSomeNum(status);
    }

    @GetMapping("/worker/getSomeOrder")
    public LinkedList<ExOrder> getSomeOrder(@RequestParam("status") String status,@RequestParam("pageindex")int pageindex, @RequestParam("pagesize") int pagesize){
        System.out.println(status);
        System.out.println(pageindex);
        System.out.println(pagesize);
        return  ordermapper.getSomeOrder(status,pageindex,pagesize);
    }
    @PostMapping("/worker/updateOrder")
    public Integer UpdateOrder(@RequestBody ExOrder order){
        System.out.println(order);
        System.out.println(order.getCompany());
        System.out.println(order.getOrderId());
        System.out.println(order.getSenderName());
        System.out.println(order.getReceiverAddress()  );
        System.out.println();
        return ordermapper.UpdateOrder1(order.getOrderId(),order.getSenderName(),order.getSendPhone(),order.getReceiverName(),order.getReceiverPhone(),order.getReceiverAddress(),order.getCompany(),order.getEmployeeId(),order.getStatus());
        //return ordermapper.UpdateOrder(order);
    }

    @DeleteMapping("/worker/deleteOrder")
    public Integer delOrder(@RequestParam("id")String id){
        return ordermapper.delOrder(id);

    }
    @GetMapping("/worker/updateStatus")
    public Integer updateOrderStatus(@RequestParam("id")String id,@RequestParam("status")String status,@RequestParam("phone")String phone){
        try {
            this.jdbcTemplate.execute("call updateOrderStatusForJdbc('"+id+"','"+status+"','"+phone+"')");
            return 1;
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }
    @GetMapping("/worker/updateOK")
    public Integer updateOrderOK(@RequestParam("id")String id,@RequestParam("status")String status,@RequestParam("phone")String phone,@RequestParam("employeeID")String employeeID){
        try {
            this.jdbcTemplate.execute("call updateOrderCompleteForJdbc('"+id+"','"+status+"','"+phone+"','"+employeeID+"')");
            return 1;
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }
    @GetMapping("/worker/updateOrderEmployee")
    public Integer updateOrderEmployee(@RequestParam("id")String id,@RequestParam("employeeId")String employeeId,@RequestParam("phone")String phone){
        try {
            this.jdbcTemplate.execute("call updateOrderEmployeeForJdbc('"+id+"','"+employeeId+"','"+phone+"')");
            return 1;
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }
}
