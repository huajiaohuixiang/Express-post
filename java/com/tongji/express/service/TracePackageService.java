package com.tongji.express.service;

import com.tongji.express.entity.inputVo.InBoxRecord;
import com.tongji.express.entity.inputVo.InWarehouseRecord;
import com.tongji.express.mapper.worker.TracePackageMapper;
import com.tongji.express.result.Trace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * created by kz on
 */

@Service
public class TracePackageService {

    @Autowired
    TracePackageMapper tracePackageMapper;

    public Trace getTrace(String PackageID){
        Trace trace=new Trace();
        InWarehouseRecord inWarehouseRecord=tracePackageMapper.getWareRecord(PackageID);
        if(inWarehouseRecord!=null)
        {
            trace.setInWareDate(inWarehouseRecord.getInDate());
            trace.setWarehouseID(inWarehouseRecord.getWarehouseID());
            trace.setEmployee1(inWarehouseRecord.getEmployeeID());
        }

        InBoxRecord inBoxRecord=tracePackageMapper.getBoxRecord(PackageID);
        if(inBoxRecord!=null){
            trace.setBoxID(inBoxRecord.getBoxID());

            trace.setEmployee2(inBoxRecord.getEmployeeID());

            trace.setInBoxDate(inBoxRecord.getOutDate());
        }

        return trace;
    }

}
