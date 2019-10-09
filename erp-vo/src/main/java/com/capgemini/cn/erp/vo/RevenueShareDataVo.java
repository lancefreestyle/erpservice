package com.capgemini.cn.erp.vo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;

@Data
public class RevenueShareDataVo implements Serializable {
    private String id;
    private String revenueShareRuleId;
    private String partnerGroupId;
    private String productGroupId;
    private String partnerGroupItemId;
    private String productGroupItemId;
    private String traceId;
    private BigDecimal traceAmount;
    private BigDecimal settlementAmount;
    private String payType;
    private String batchId;
    private Timestamp importDate;
    private Timestamp traceDate;
    private Timestamp updateDate;
}
