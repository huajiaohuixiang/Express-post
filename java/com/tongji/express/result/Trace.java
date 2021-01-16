package com.tongji.express.result;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import java.sql.Date;

/**
 * created by kz on
 */
@Data
@Repository
@NoArgsConstructor
public class Trace {

    private String warehouseID;
    private String Employee1;
    private Date inWareDate;
    private String boxID;
    private Date inBoxDate;
    private String Employee2;
    private String receiveDate;
}
