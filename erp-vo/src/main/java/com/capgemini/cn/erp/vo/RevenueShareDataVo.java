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
public class RevenueShareDataVo implements Serializable {
    private String id;
    private RevenueShareRuleVo revenueShareRuleVo;
    private PartnerGroupVo partnerGroupVo;
    private ProductGroupVo productGroupVo;
    private PartnerGroupItemVo partnerGroupItemVo;
    private ProductGroupItemVo productGroupItemVo;
    private String traceId;
    private BigDecimal traceAmount;
    private BigDecimal settlementAmount;
    private String payType;
    private String batchId;
    private Timestamp importDate;
    private Timestamp traceDate;
    private Timestamp updateDate;
}
