package com.tongji.express.controller.worker;



import com.tongji.express.entity.ExOrder;
import com.tongji.express.entity.Message;
import com.tongji.express.mapper.worker.EmployeeMapper;
import com.tongji.express.mapper.worker.MessageMapper;
import com.tongji.express.mapper.worker.order.orderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.LinkedList;

@RestController
@CrossOrigin
public class getOrderInfo {

    @Autowired
    orderMapper ordermapper;

    @Autowired
    MessageMapper messageMapper;

    @Autowired
    EmployeeMapper employeeMapper;

    @GetMapping("/worker/getOrderById")
    public ExOrder getOrder(@RequestParam("id")String id){
        return  ordermapper.getOrderById(id);
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
        System.out.println(id);
        System.out.println(status);
        Message lastest=messageMapper.lastMessage();
        int newID=Integer.valueOf(lastest.getMessageId());
        newID+=1;
        LocalDate now = LocalDate.now();
        if(status=="已分配"){
            //  messageMapper.addMessage(String.valueOf(newID),now.toString(),phone,"您的寄件订单已被分配，快递员"+employeeId+"将在您预约时间内上门，上门后给取件码4410，为安全取件，建议与快递小哥电话联系","寄件消息","已发送");

        }else if(status.equals("已接单")){
            messageMapper.addMessage(String.valueOf(newID),now.toString(),phone,"您的寄件订单已接单","寄件消息","已发送");

        }else if(status=="已完成"){
            //   messageMapper.addMessage(String.valueOf(newID),now.toString(),phone,"您的寄件订单已完成","寄件消息","已发送");

        }else if(status=="已取消"){
            messageMapper.addMessage(String.valueOf(newID),now.toString(),phone,"您的寄件订单已取消","寄件消息","已发送");

        }else{
            System.out.println("状态输入错误");
        }
        return ordermapper.UpdateOrderState(id,status);

    }
    @GetMapping("/worker/updateOK")
    public Integer updateOrderOK(@RequestParam("id")String id,@RequestParam("status")String status,@RequestParam("phone")String phone,@RequestParam("employeeID")String employeeID){
        System.out.println(id);
        System.out.println(status);
        Message lastest=messageMapper.lastMessage();
        int newID=Integer.valueOf(lastest.getMessageId());
        newID+=1;
        LocalDate now = LocalDate.now();
        messageMapper.addMessage(String.valueOf(newID),now.toString(),phone,"您的寄件订单已完成","寄件消息","已发送");
        employeeMapper.dispatcherEmployee(employeeID,"空闲");
        return ordermapper.UpdateOrderState(id,status);

    }
    @GetMapping("/worker/updateOrderEmployee")
    public Integer updateOrderEmployee(@RequestParam("id")String id,@RequestParam("employeeId")String employeeId,@RequestParam("phone")String phone){
        System.out.println(id);
        System.out.println(employeeId);
        Message lastest=messageMapper.lastMessage();
        int newID=Integer.valueOf(lastest.getMessageId());
        newID+=1;
        LocalDate dateTime = LocalDate.now();
        System.out.println(phone);
        messageMapper.addMessage(String.valueOf(newID),dateTime.toString(),phone,"您的寄件订单已被分配，快递员"+employeeId+"将在您预约时间内上门，上门后给取件码4410，为安全取件，建议与快递小哥电话联系","寄件消息","已发送");
        ordermapper.UpdateOrderState(id,"已分配");
        return ordermapper.UpdateOrderEmployee(id,employeeId);

    }
}
