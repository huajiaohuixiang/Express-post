package com.tongji.express.service;

import com.tongji.express.entity.Box;
import com.tongji.express.entity.inputVo.InBoxRecord;
import com.tongji.express.mapper.user.express.AckExpressMapper;
import com.tongji.express.mapper.user.express.GetOutExpressMapper;
import com.tongji.express.mapper.worker.GetBoxIDMapper;
import com.tongji.express.mapper.worker.UpdateBoxInfoMapper;
import com.tongji.express.result.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
    public State getOutExpress(String cupboardID,String code){
            Box boxInfo=getOutExpressMapper.getBoxInfo(cupboardID, code);
            if(boxInfo!=null) {
                InBoxRecord inBoxRecord = new InBoxRecord();
                inBoxRecord.setUserID(null);
                inBoxRecord.setCode("1234567");
                inBoxRecord.setStatus("success");
                inBoxRecord.setPackageID(null);
                inBoxRecord.setX(boxInfo.getRowx());
                inBoxRecord.setY(boxInfo.getColy());
                inBoxRecord.setCupboardID(cupboardID);
                String boxID = getBoxIDMapper.getBoxID(inBoxRecord);
                inBoxRecord.setBoxID(boxID);
                updateBoxInfoMapper.updateBoxStatus(inBoxRecord);
                java.util.Date date=new java.util.Date();
                java.sql.Date sqlDate=new java.sql.Date(date.getTime());
                ackExpressMapper.ackExpress(boxInfo.getPackageId(),sqlDate);
                return State.success;
            }
            return State.fail;
    }

}
