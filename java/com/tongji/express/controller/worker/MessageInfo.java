package com.tongji.express.controller.worker;


import com.tongji.express.entity.Message;
import com.tongji.express.mapper.worker.MessageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/worker")
public class MessageInfo {
    @Autowired
    MessageMapper messageMapper;

    @GetMapping("/getMessage")
    public LinkedList<Message> getMessage(){

        return messageMapper.getMessage();
    }

    @PostMapping("/addMessage")
    public HashMap<String,Object> addMessage(@RequestBody Message message){
        HashMap<String,Object> map=new HashMap<String,Object>();
        messageMapper.addMessage(message.getMessageId(),message.getSendDate(),message.getUserId(),message.getContent(),message.getMessageType(),message.getStatus());
        map.put("code",200);
        map.put("message","添加消息成功！");
        return map;
    }

    @GetMapping("/searchMessage")
    public LinkedList<Message> searchMessage(@RequestParam("user_id") String user_id,@RequestParam("message_type") String type){

        return messageMapper.searchMessage(user_id,type);
    }

    @PostMapping("/deleteMessage")
    public HashMap<String,Object> deleteMessage(@RequestParam("message_id") String message_id){
        HashMap<String,Object> map=new HashMap<String,Object>();
        messageMapper.deleteMessage(message_id);
        map.put("code",200);
        map.put("message","删除成功！");
        return map;
    }
    @GetMapping("/lastMessage")
    public Object lastMessage(){
        return messageMapper.lastMessage();
    }
    @PostMapping("/resendMessage")
    public  HashMap<String,Object> resendMessage(@RequestBody Message message){
        HashMap<String,Object> map=new HashMap<String,Object>();
        messageMapper.addMessage(message.getMessageId(),message.getSendDate(),message.getUserId(),message.getContent(),message.getMessageType(),"已发送");
        map.put("code",200);
        map.put("message","重新发送消息成功！");
        return map;
    }
    @PostMapping("/updateMessage")
    public  HashMap<String,Object> updateMessage(@RequestBody Message message){
        HashMap<String,Object> map=new HashMap<String,Object>();
        messageMapper.updateMessage(message.getMessageId(),message.getStatus());
        map.put("code",200);
        map.put("message","重新发送消息成功！");
        return map;
    }
    @PostMapping("/getNum")
    public Map<String,Object> getNum(){
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("user_total",messageMapper.getUsersNum());
        map.put("message_total",messageMapper.getMessageNum());
        map.put("package_total",messageMapper.getPackageNum());
        return  map;
    }
}