package com.tongji.express.service;

import com.tongji.express.entity.inputVo.InBoxRecord;
import com.tongji.express.entity.inputVo.MyPackage;
import com.tongji.express.mapper.pack.QueryPackageMapper;
import com.tongji.express.mapper.worker.DelWareDetailMapper;
import com.tongji.express.mapper.pack.GetBoxIDMapper;
import com.tongji.express.mapper.worker.InsertBoxRecordMapper;
import com.tongji.express.mapper.worker.UpdateBoxInfoMapper;
import com.tongji.express.result.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;

/**
 * created by kz on
 */
@Service
public class InBoxService {
    @Autowired
    DelWareDetailMapper delWareDetailMapper;

    @Autowired
    GetBoxIDMapper getBoxIDMapper;

    @Autowired
    UpdateBoxInfoMapper updateBoxInfoMapper;

    @Autowired
    InsertBoxRecordMapper insertBoxRecordMapper;
    @Autowired
    QueryPackageMapper queryPackageMapper;

    @Transactional
    public State packageInBox(InBoxRecord inBoxRecord){
        try {
            java.util.Date date=new java.util.Date();
            Date sqlDate=new Date(date.getTime());
            inBoxRecord.setInDate(sqlDate);
            String boxID=getBoxIDMapper.getBoxID(inBoxRecord);
            System.out.println("-------boxID--------:"+boxID);
            inBoxRecord.setBoxID(boxID);
            MyPackage pack=queryPackageMapper.queryPackage(inBoxRecord.getPackageID());
            inBoxRecord.setUserID(pack.getReceiverPhone());
            insertBoxRecordMapper.insert(inBoxRecord);
            delWareDetailMapper.delete(inBoxRecord.getPackageID());
            inBoxRecord.setStatus("warning");
            inBoxRecord.setCode(getlinkNo());
            updateBoxInfoMapper.updateBoxStatus(inBoxRecord);
            return State.success;
        }catch (Exception e)
        {
            e.printStackTrace();

            return State.fail;
        }
    }

    public String getlinkNo() {
        String linkNo = "";
        // 用字符数组的方式随机
        String model = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder sb=new StringBuilder();
        char[] m = model.toCharArray();
        for (int j = 0; j < 7; j++) {
            char c = m[(int) (Math.random() * 36)];
            sb.append(c);
        }
        return sb.toString();
    }


}
