package com.capgemini.cn.erp.vo;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

@Data
public class RevenueShareRuleVo implements Serializable {
    private String id;
    private String ruleTitleId;
    private String ruleTypeId;
    private String conditionRuleId;
    private String amountCalculationId;
    private String partnerGroupId;
    private String productGroupId;
    private String settlementPeriod;
    private int autoClear;
    private int autoOffset;
    private String remark;
    private Timestamp beginDate;
    private Timestamp endDate;
    private Timestamp createDate;
    private Timestamp updateDate;
}
