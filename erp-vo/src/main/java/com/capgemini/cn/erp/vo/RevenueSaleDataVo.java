package com.capgemini.cn.erp.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RevenueSaleDataVo implements Serializable {
    private String id;
    private SystemBusinessTypeVo systemBusinessTypeVo;
    private String status;
    private ProductGroupVo productGroupVo;
    private ProductGroupItemVo productGroupItemVo;
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
