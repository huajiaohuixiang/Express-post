package com.tongji.express.mapper.worker;


import com.tongji.express.entity.Box;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


import java.util.LinkedList;

@Mapper
public interface BoxMapper  {
    @Select("select count(*) from box where cupboard_ID=#{id} and state='success'")
    public int getSum(String id);


    @Select("select * from box ")
    public LinkedList<Box> getBox();


    @Insert("insert into box values(#{id},#{cupid},#{type},#{coly},#{rowx},#{state},#{paid})")
    public void insertBox(String id, String cupid, String type, String coly, String rowx, String state, String paid);



//    @Insert("insert into box values(box)")
   // public void insertBox(Box box);

    public default void a(Box box){
        box.getBoxId();
    }


}
// @Insert("insert into box values(" +
//            "#{box.getBoxId();}," +
//            "#{box.getCupboardId();}," +
//            "#{box.getType();}," +
//            "#{box.getColy();}," +
//            "#{box.getRowx();}," +
//            "#{box.getState();}," +
//            "#{box.getPackageId();}" +
//            ")")