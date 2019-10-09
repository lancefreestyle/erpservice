package com.capgemini.cn.erp.vo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;

@Data
public class RevenueSaleDataVo implements Serializable {
    private String id;
    private String systemBusinessTypeId;
    private String status;
    private String productGroupId;
    private String productGroupItemId;
    private String traceId;
    private BigDecimal traceAmount;
    private BigDecimal calculatedAmount;
    private BigDecimal calculatAmount;
    private int sharedCount;
    private int shareCount;
    private String payType;
    private String businessDepartment;
    private String profitCenter;
    private Timestamp traceBeginDate;
    private Timestamp traceEndDate;
    private Timestamp tallyBeginDate;
    private Timestamp tallyEndDate;
    private Timestamp createDate;
    private Timestamp updateDate;
}
