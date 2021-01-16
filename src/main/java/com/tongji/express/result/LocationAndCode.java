package com.tongji.express.result;

import lombok.Data;
import org.springframework.stereotype.Repository;

/**
 * created by kz on
 */
@Data
@Repository
public class LocationAndCode {
    private String x;
    private String y;
    private String cupboardID;
    private String code;
    private String state;
}
