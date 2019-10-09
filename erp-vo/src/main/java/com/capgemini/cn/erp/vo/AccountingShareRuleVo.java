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
public class AccountingShareRuleVo implements Serializable {
    private String id;
    private RuleTitleVo ruleTitleVo;
    private RuleTypeVo ruleTypeVo;
    private String shareType;
    private Timestamp beginDate;
    private Timestamp endDate;
    private Integer dateFreq;
    private String freqType;
    private Timestamp createDate;
    private Timestamp updateDate;
}
