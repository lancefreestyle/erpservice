package com.capgemini.cn.erp.vo;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

@Data
public class AccountingShareRuleVo implements Serializable {
    private String id;
    private String ruleTitleId;
    private String ruleTypeId;
    private String shareType;
    private Timestamp beginDate;
    private Timestamp endDate;
    private Integer dateFreq;
    private String freqType;
    private Timestamp createDate;
    private Timestamp updateDate;
}
