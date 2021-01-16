package com.tongji.express.mapper.worker.order;


import com.tongji.express.entity.ExOrder;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.LinkedList;

@Mapper
public interface orderMapper {
    @Select("select * from Ex_Order where order_id=#{id}")
    public ExOrder getOrderById(String id);

    @Select("select e.* from (select G.*,ROWNUM rn from (Ex_order) G where   ROWNUM<=#{pageindex}*#{pagesize})  e where rn >=(#{pageindex}-1)*#{pagesize}+1 ")
    public LinkedList<ExOrder> getOrder(int pageindex, int pagesize);

    @Select("select count(*) from EX_ORDER ")
    public Integer getOrderNum();
    @Select("select count(*) from EX_ORDER where status=#{status}")
    public Integer getSomeNum(String status);
    @Select("select e.* from (select G.*,ROWNUM rn from (Ex_order) G where status=#{status} AND ROWNUM<=#{pageindex}*#{pagesize})  e where rn >=(#{pageindex}-1)*#{pagesize}+1  ")
    public LinkedList<ExOrder> getSomeOrder(String status, int pageindex, int pagesize);

    @Delete("delete from EX_ORDER where order_id=#{id}")
    public Integer delOrder(String id);


    @Update("update EX_ORDER e set e.status = #{state} where e.order_id= #{id}")
    public Integer UpdateOrderState(String id, String state);

    @Update("update EX_ORDER e set e.employee_id = #{employee_id} where e.order_id= #{id}")
    public Integer UpdateOrderEmployee(String id, String employee_id);


    @Update("update EX_ORDER e set e.employee_id = #{employeeId}, e.sender_name=#{senderName}, e.sender_phone=#{sendPhone} ,e.company=#{company}, e.receiver_name=#{receiverName}, e.receiver_phone=#{receiverPhone}, e.receiver_address='${receiverAddress}', e.status=#{status} where e.order_id= #{orderId}")
    public Integer UpdateOrder(ExOrder order);


    @Update("update EX_ORDER e set e.employee_id = #{employeeId}, e.sender_name=#{senderName}, e.sender_phone=#{sendPhone} ,e.company=#{company}, e.receiver_name=#{receiverName}, e.receiver_phone=#{receiverPhone}, e.receiver_address=#{receiverAddress,jdbcType=VARCHAR}, e.status=#{status} where e.order_id= #{orderId}")
    public Integer UpdateOrder1(String orderId, String senderName, String sendPhone, String receiverName, String receiverPhone, String receiverAddress, String company, String employeeId, String status);
//    @Update("update EX_ORDER set ")
//    public String UpdateOrder(ExOrder order);

}
