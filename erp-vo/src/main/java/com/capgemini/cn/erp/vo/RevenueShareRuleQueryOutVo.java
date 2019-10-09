package com.capgemini.cn.erp.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RevenueShareRuleQueryOutVo implements Serializable {
    private List<SystemBusinessTypeVo> systemBusinessTypeVos;
    private List<DataTemplateVo> dataTemplateVos;
    private List<ConditionRuleVo> conditionRuleVos;
    private List<AmountCalculationVo> amountCalculationVos;
    private List<PartnerGroupVo> partnerGroupVos;
    private List<ProductGroupVo> productGroupVos;
}
