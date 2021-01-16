package com.tongji.express.mapper.worker;



import com.tongji.express.entity.Message;
import org.apache.ibatis.annotations.*;

import java.util.LinkedList;

@Mapper
public interface MessageMapper {

    @Select("select * from message order by cast(message_id as int)")
    public LinkedList<Message> getMessage();

    @Select("select * from message where user_id=#{id} order by cast(message_id as int)")
    public LinkedList<Message> getMyMessage(String id);

    @Insert("insert into message   values(#{message_id},#{send_date},#{user_id},#{content},#{message_type}，#{status})")
    public void addMessage(String message_id, String send_date, String user_id,String content,String message_type,String status);

    @Select("select * from message where user_id = #{user_id} and message_type=#{message_type}")
    public LinkedList<Message> searchMessage(String user_id,String message_type);

//    @Select("select * from message where message_id = #{message_id} ")
//    public LinkedList<Message> searchMessage(String message_id);

    @Update("update message set status=#{status} where message_id=#{id}")
    public void updateMessage(String id,String status);
    @Delete("delete from message where message_id=#{message_id}")
    public void deleteMessage(String message_id);
    @Select("select * from (select * from message order by cast(message_id as int)  desc) where rownum=1")
    public Message lastMessage();
    @Select("select count(*) from message")
    public int getMessageNum();
    @Select("select count(*) from users")
    public int getUsersNum();
    @Select("select count(*) from package")
    public int getPackageNum();
}
