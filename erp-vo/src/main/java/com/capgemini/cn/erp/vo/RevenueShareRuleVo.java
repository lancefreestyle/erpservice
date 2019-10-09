package com.capgemini.cn.erp.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RevenueShareRuleVo implements Serializable {
    private String id;
    private RuleTitleVo ruleTitleVo;
    private RuleTypeVo ruleTypeVo;
    private ConditionRuleVo conditionRuleVo;
    private AmountCalculationVo amountCalculationVo;
    private PartnerGroupVo partnerGroupVo;
    private ProductGroupVo productGroupVo;
    private String settlementPeriod;
    private int autoClear;
    private int autoOffset;
    private String remark;
    private Timestamp beginDate;
    private Timestamp endDate;
    private Timestamp createDate;
    private Timestamp updateDate;
}
