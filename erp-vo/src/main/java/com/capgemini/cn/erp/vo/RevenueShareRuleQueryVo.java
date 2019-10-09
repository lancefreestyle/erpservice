package com.capgemini.cn.erp.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class RevenueShareRuleQueryVo implements Serializable {
    private SystemBusinessTypeVo systemBusinessTypeVo;
    private DataTemplateVo dataTemplateVo;
    private ConditionRuleVo conditionRuleVo;
    private AmountCalculationVo amountCalculationVo;
    private PartnerGroupVo partnerGroupVo;
    private ProductGroupVo productGroupVo;
}
