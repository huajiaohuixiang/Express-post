package com.tongji.express.mapper.worker;



import com.tongji.express.entity.Message;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;

@Mapper
@Repository
public interface MessageMapper {

    @Select("select * from message order by cast(message_id as int)")
    LinkedList<Message> getMessage();

    @Select("select * from message where user_id=#{id} order by cast(message_id as int)")
    LinkedList<Message> getMyMessage(String id);

    @Insert("insert into message   values(#{message_id},#{send_date},#{user_id},#{content},#{message_type}，#{status})")
    void addMessage(String message_id, String send_date, String user_id, String content, String message_type, String status);

    @Select("select * from message where user_id = #{user_id} and message_type=#{message_type}")
    LinkedList<Message> searchMessage(String user_id, String message_type);

//    @Select("select * from message where message_id = #{message_id} ")
//    public LinkedList<Message> searchMessage(String message_id);

    @Update("update message set status=#{status} where message_id=#{id}")
    void updateMessage(String id, String status);
    @Delete("delete from message where message_id=#{message_id}")
    void deleteMessage(String message_id);
    @Select("select * from (select * from message order by cast(message_id as int)  desc) where rownum=1")
    Message lastMessage();
    @Select("select count(*) from message")
    int getMessageNum();
    @Select("select count(*) from users")
    int getUsersNum();
    @Select("select count(*) from package")
    int getPackageNum();
}
