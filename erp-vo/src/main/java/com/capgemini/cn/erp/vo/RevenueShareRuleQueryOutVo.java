package com.capgemini.cn.erp.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class RevenueShareRuleQueryOutVo implements Serializable {
    private List<SystemBusinessTypeVo> systemBusinessTypeVos;
    private List<DataTemplateVo> dataTemplateVos;
    private List<ConditionRuleVo> conditionRuleVos;
    private List<AmountCalculationVo> amountCalculationVos;
    private List<PartnerGroupVo> partnerGroupVos;
    private List<ProductGroupVo> productGroupVos;
}
